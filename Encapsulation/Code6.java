abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }

    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - discount;
    }

    public void applyDiscount(double percent) {
        discount = (getPrice() * getQuantity()) * (percent / 100);
    }

    public String getDiscountDetails() {
        return "Discount on Veg Item: " + discount;
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discount;
    private double nonVegCharge = 20;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }

    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + nonVegCharge - discount;
    }

    public void applyDiscount(double percent) {
        discount = ((getPrice() * getQuantity()) + nonVegCharge) * (percent / 100);
    }

    public String getDiscountDetails() {
        return "Discount on Non-Veg Item: " + discount;
    }
}

public class Main {
    public static void main(String[] args) {
        FoodItem[] order = new FoodItem[2];

        order[0] = new VegItem("Paneer Tikka", 150, 2);
        order[1] = new NonVegItem("Chicken Biryani", 200, 1);

        for (FoodItem item : order) {
            System.out.println(item.getItemDetails());

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                d.applyDiscount(10);
                System.out.println(d.getDiscountDetails());
            }

            System.out.println("Total Price: " + item.calculateTotalPrice());
            System.out.println();
        }
    }
}
