// Define a class for MP3 players, which is another type of gadget
public class MP3 extends Gadget {
    // Additional detail for MP3 players: memory size for storing music
    private int memorySize; // The memory size of the MP3 player

    // Create a new MP3 player
    public MP3(String model, double price, int weight, String size, int memorySize) {
        // Call the constructor of the superclass (Gadget) and provide details
        super(model, price, weight, size);
        // Assign memory size for storing music
        this.memorySize = memorySize;
    }

    // Get available memory size for music
    public int getMemorySize() {
        return memorySize;
    }

    // Download music into the MP3 player
    public void downloadMusic(int downloadSize) {
        // Check if there is sufficient memory to download the music
        if (downloadSize <= memorySize) {
            // Download the music and reduce the available memory size
            System.out.println("Downloading music of size " + downloadSize + "MB.");
            memorySize -= downloadSize;
        } else {
            // Print an error message if there is insufficient memory
            System.out.println("Insufficient memory to download music.");
        }
    }

    // Delete music from the MP3 player
    public void deleteMusic(int deleteSize) {
        // Check if the delete size is valid
        if (deleteSize <= memorySize) {
            // Delete the music and increase the available memory size
            System.out.println("Deleting music of size " + deleteSize + "MB.");
            memorySize += deleteSize;
        } else {
            // Print an error message if the delete size is invalid
            System.out.println("Invalid delete size.");
        }
    }

    // Display details of the MP3 player along with available memory
    @Override
    public void display() {
        // Call the display method of the superclass (Gadget)
        super.display();
        // Print out the available memory size for music
        System.out.println("Memory Size: " + memorySize + "MB");
    }
}