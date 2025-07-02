abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    public double calculateTax() {
        return getPrice() * 0.18;
    }

    public String getTaxDetails() {
        return "18% GST on electronics";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    public double calculateTax() {
        return getPrice() * 0.05;
    }

    public String getTaxDetails() {
        return "5% GST on clothing";
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[3];

        products[0] = new Electronics(1, "Laptop", 50000);
        products[1] = new Clothing(2, "T-Shirt", 1000);
        products[2] = new Groceries(3, "Rice", 500);

        for (Product p : products) {
            double price = p.getPrice();
            double discount = p.calculateDiscount();
            double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
            double finalPrice = price + tax - discount;

            System.out.println("Product: " + p.getName());
            System.out.println("Price: " + price);
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            if (p instanceof Taxable) {
                System.out.println("Tax Details: " + ((Taxable) p).getTaxDetails());
            }
            System.out.println("Final Price: " + finalPrice);
            System.out.println();
        }
    }
}
