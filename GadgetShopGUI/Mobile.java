// Define a class for mobile phones, which is a type of gadget
public class Mobile extends Gadget {
    // Additional detail for mobile phones: credit for calls
    private int creditMinutes; // The credit minutes for making calls
     private int credit;
    // Create a new mobile phone
    public Mobile(String model, double price, int weight, String size, int creditMinutes) {
        // Call the constructor of the superclass (Gadget) and provide details
        super(model, price, weight, size);
        // Assign credit for calls
        this.creditMinutes = creditMinutes;
    }

    public int getCallingCredit() {
        return creditMinutes; 
    }
    // Get remaining credit for calls
    public int getCreditMinutes() {
        return creditMinutes;
    }

    
    // Add more credit for calls
    public void addCallingCredit(int creditToAdd) {
        // Check if the credit to add is positive
        if (creditToAdd > 0) {
            // Add the credit to the existing credit minutes
            creditMinutes += creditToAdd;
            System.out.println("Credit added successfully.");
        } else {
            // Print an error message if the credit to add is not positive
            System.out.println("Please enter a positive amount to add calling credit.");
        }
    }

    // Make a call
    public void makeCall(String phoneNumber, int duration) {
        // Check if there is sufficient credit for the call
        if (duration <= creditMinutes) {
            // Make the call and deduct the duration from the credit minutes
            System.out.println("Making call to " + phoneNumber + " for " + duration + " minutes.");
            creditMinutes -= duration;
        } else {
            // Print an error message if there is insufficient credit
            System.out.println("Insufficient calling credit to make the call.");
        }
    }

    // Display details of the mobile phone along with remaining credit
    @Override
    public void display() {
        // Call the display method of the superclass (Gadget)
        super.display();
        // Print out the remaining credit for calls
        System.out.println("Calling credit remaining: " + creditMinutes + " minutes");
    }
}