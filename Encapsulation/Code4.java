abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    public void applyForLoan(double amount) {
        System.out.println("SavingsAccount loan requested: " + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate;

    public CurrentAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    public void applyForLoan(double amount) {
        System.out.println("CurrentAccount loan requested: " + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000;
    }
}

class Main {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[2];

        accounts[0] = new SavingsAccount("SA001", "Alice", 6000, 0.04);
        accounts[1] = new CurrentAccount("CA002", "Bob", 12000, 0.02);

        for (BankAccount acc : accounts) {
            System.out.println("Account: " + acc.getAccountNumber() + ", Holder: " + acc.getHolderName());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Interest: " + acc.calculateInterest());

            if (acc instanceof Loanable) {
                ((Loanable) acc).applyForLoan(5000);
                System.out.println("Eligible for loan: " + ((Loanable) acc).calculateLoanEligibility());
            }

            System.out.println();
        }
    }
}
