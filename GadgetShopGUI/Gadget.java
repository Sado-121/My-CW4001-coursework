// Define a class for gadgets like phones and MP3 players
public class Gadget {
    // Details each gadget has: model, price, weight, and size
    private String model; // The model of the gadget
    private double price; // The price of the gadget
    private int weight; // The weight of the gadget
    private String size; // The size of the gadget

    // Create a new gadget with specific details
    public Gadget(String model, double price, int weight, String size) {
        // Assign the details to the gadget
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    // Get details of a gadget
    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getSize() {
        return size;
    }

    // Display details of a gadget
    public void display() {
        // Print out the details of the gadget
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Weight: " + weight);
        System.out.println("Size: " + size);
    }
}