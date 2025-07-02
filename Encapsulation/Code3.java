abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String policyNumber;

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 0.05 * getRentalRate();
    }

    public String getInsuranceDetails() {
        return "Policy: " + policyNumber + ", 5% of rental rate";
    }
}

class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 0.02 * getRentalRate();
    }

    public String getInsuranceDetails() {
        return "Policy: " + policyNumber + ", 2% of rental rate";
    }
}

class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500;
    }

    public double calculateInsurance() {
        return 0.1 * getRentalRate();
    }

    public String getInsuranceDetails() {
        return "Policy: " + policyNumber + ", 10% of rental rate";
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car("CAR123", 1000, "C1001");
        vehicles[1] = new Bike("BIKE456", 300, "B2002");
        vehicles[2] = new Truck("TRUCK789", 2000, "T3003");

        int days = 5;

        for (Vehicle v : vehicles) {
            double rentalCost = v.calculateRentalCost(days);
            double insurance = 0;
            String insuranceDetails = "";

            if (v instanceof Insurable) {
                insurance = ((Insurable) v).calculateInsurance();
                insuranceDetails = ((Insurable) v).getInsuranceDetails();
            }

            System.out.println("Vehicle: " + v.getType() + ", Number: " + v.getVehicleNumber());
            System.out.println("Rental Cost for " + days + " days: " + rentalCost);
            System.out.println("Insurance: " + insurance);
            System.out.println("Insurance Details: " + insuranceDetails);
            System.out.println();
        }
    }
}
