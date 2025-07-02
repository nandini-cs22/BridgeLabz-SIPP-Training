abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrower;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrower = null;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public abstract int getLoanDuration();

    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }
}

interface Reservable {
    void reserveItem(String user);
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean reserved;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.reserved = false;
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem(String user) {
        if (!reserved) {
            reserved = true;
            setBorrower(user);
        }
    }

    public boolean checkAvailability() {
        return !reserved;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean reserved;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
        this.reserved = false;
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem(String user) {
        if (!reserved) {
            reserved = true;
            setBorrower(user);
        }
    }

    public boolean checkAvailability() {
        return !reserved;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean reserved;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.reserved = false;
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem(String user) {
        if (!reserved) {
            reserved = true;
            setBorrower(user);
        }
    }

    public boolean checkAvailability() {
        return !reserved;
    }
}

public class Main {
    public static void main(String[] args) {
        LibraryItem[] items = new LibraryItem[3];

        items[0] = new Book("B001", "Java Basics", "John Doe");
        items[1] = new Magazine("M001", "Tech Monthly", "Jane Smith");
        items[2] = new DVD("D001", "Inception", "Christopher Nolan");

        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable res = (Reservable) item;
                System.out.println("Available: " + res.checkAvailability());
                res.reserveItem("User123");
                System.out.println("Available after reservation: " + res.checkAvailability());
            }

            System.out.println();
        }
    }
}
