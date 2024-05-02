// Import necessary libraries
import javax.swing.*; // For GUI components
import java.awt.*; // For layout management
import java.awt.event.*; // For event handling
import java.util.ArrayList; // For managing lists of gadgets

// Define a class for the graphical user interface of the gadget shop
public class GadgetShopGUI extends JFrame {
    // List to store gadgets and a tabbed layout for different sections
    private ArrayList<Gadget> gadgets = new ArrayList<>();
    private JTabbedPane tabs;

    // Components for the Mobile tab
    private JPanel mobilePanel;
    private JTextField modelTextbox, priceTextbox, weightTextbox, sizeTextbox, creditTextbox, phoneNumberTextbox, durationTextbox, creditToAddTextbox;
    private JButton addMobileButton, clearMobileButton, displayMobileButton, makeCallButton, addCreditButton;

    // Components for the MP3 tab
    private JPanel mp3Panel;
    private JTextField mp3ModelTextbox, mp3PriceTextbox, mp3WeightTextbox, mp3SizeTextbox, memoryTextbox, downloadSizeTextbox, deleteSizeTextbox;
    private JButton addMP3Button, clearMP3Button, displayMP3Button, downloadMusicButton, deleteMusicButton;
    private JComboBox<String> cmbMP3DisplayNumber;

    // Shared components for both tabs
    private JComboBox<String> cmbDisplayNumber;
    // Shared components for both tabs (continued)
    private JTextArea txtDisplay; // Text area to display information

    // Constructor for the GUI
    public GadgetShopGUI() {
        // Set up the window properties
        setTitle("Gadget Shop");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize GUI components
        initializeComponents();
        // Organize layout of components
        organizeLayout();
        // Make the GUI visible
        setVisible(true);
    }

    // Method to initialize GUI components
    private void initializeComponents() {
        // Initialize components for the Mobile tab
        modelTextbox = new JTextField(10); // Input field for the mobile model
        priceTextbox = new JTextField(10); // Input field for the mobile price
        weightTextbox = new JTextField(10); // Input field for the mobile weight
        sizeTextbox = new JTextField(10); // Input field for the mobile size
        creditTextbox = new JTextField(10); // Input field for the mobile credit
        phoneNumberTextbox = new JTextField(10); // Input field for the phone number
        durationTextbox = new JTextField(10); // Input field for the call duration
        creditToAddTextbox = new JTextField(10); // Input field for the credit to add
        addMobileButton = new JButton("Add Mobile"); // Button to add a new mobile
        clearMobileButton = new JButton("Clear"); // Button to clear mobile input fields
        displayMobileButton = new JButton("Display All"); // Button to display all mobiles
        makeCallButton = new JButton("Make A Call"); // Button to make a call
        addCreditButton = new JButton("Add Credit"); // Button to add credit

        // Initialize components for the MP3 tab
        mp3ModelTextbox = new JTextField(10); // Input field for the MP3 model
        mp3PriceTextbox = new JTextField(10); // Input field for the MP3 price
        mp3WeightTextbox = new JTextField(10); // Input field for the MP3 weight
        mp3SizeTextbox = new JTextField(10); // Input field for the MP3 size
        memoryTextbox = new JTextField(10); // Input field for memory size
        downloadSizeTextbox = new JTextField(10); // Input field for download size
        deleteSizeTextbox = new JTextField(10); // Input field for delete size
        addMP3Button = new JButton("Add MP3"); // Button to add a new MP3
        clearMP3Button = new JButton("Clear"); // Button to clear MP3 input fields
        displayMP3Button = new JButton("Display All"); // Button to display all MP3s
        downloadMusicButton = new JButton("Download Music"); // Button to download music
        deleteMusicButton = new JButton("Delete Music"); // Button to delete music
        cmbMP3DisplayNumber = new JComboBox<>(new String[]{"-1", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"});

        // Initialize shared components for both tabs
        cmbDisplayNumber = new JComboBox<>(new String[]{"-1", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"});
        txtDisplay = new JTextArea(5, 20);
        txtDisplay.setEditable(false);

        // Add action listeners for Mobile buttons
        addMobileButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addMobile();
                }
            });
        clearMobileButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clearMobile();
                }
            });
        displayMobileButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    displayAllMobiles();
                }
            });
        makeCallButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    makeCall();
                }
            });
        addCreditButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addCredit();
                }
            });

        // Add action listeners for MP3 buttons
        addMP3Button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addMP3();
                }
            });
        clearMP3Button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clearMP3();
                }
            });
        displayMP3Button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    displayAllMP3s();
                }
            });
        downloadMusicButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    downloadMusic();
                }
            });
        deleteMusicButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    deleteMusic();
                }
            });
    }

    // Method to organize layout of GUI components
    private void organizeLayout() {
        // Set up tabbed pane
        tabs = new JTabbedPane();

        // Set up panel for Mobile tab
        mobilePanel = new JPanel(new GridLayout(12, 2));
        addToPanel(mobilePanel, new JLabel("Model:"), modelTextbox);
        addToPanel(mobilePanel, new JLabel("Price:"), priceTextbox);
        addToPanel(mobilePanel, new JLabel("Weight:"), weightTextbox);
        addToPanel(mobilePanel, new JLabel("Size:"), sizeTextbox);
        addToPanel(mobilePanel, new JLabel("Credit:"), creditTextbox);
        addToPanel(mobilePanel, new JLabel("Phone Number:"), phoneNumberTextbox);
        addToPanel(mobilePanel, new JLabel("Duration:"), durationTextbox);
        addToPanel(mobilePanel, new JLabel("Credit to Add:"), creditToAddTextbox);
        addToPanel(mobilePanel, new JLabel("Display Number:"), cmbDisplayNumber);
        addToPanel(mobilePanel, addMobileButton, clearMobileButton);
        addToPanel(mobilePanel, displayMobileButton, makeCallButton);
        addToPanel(mobilePanel, addCreditButton, new JLabel());

        // Set up panel for MP3 tab
        mp3Panel = new JPanel(new GridLayout(11, 2));
        addToPanel(mp3Panel, new JLabel("Model:"), mp3ModelTextbox);
        addToPanel(mp3Panel, new JLabel("Price:"), mp3PriceTextbox);
        addToPanel(mp3Panel, new JLabel("Weight:"), mp3WeightTextbox);
        addToPanel(mp3Panel, new JLabel("Size:"), mp3SizeTextbox);
        addToPanel(mp3Panel, new JLabel("Memory:"), memoryTextbox);
        addToPanel(mp3Panel, new JLabel("Download Size:"), downloadSizeTextbox);
        addToPanel(mp3Panel, new JLabel("Delete Size:"), deleteSizeTextbox);
        addToPanel(mp3Panel, new JLabel("Display Number:"), cmbMP3DisplayNumber);
        addToPanel(mp3Panel, addMP3Button, clearMP3Button);
        addToPanel(mp3Panel, displayMP3Button, downloadMusicButton);
        addToPanel(mp3Panel, deleteMusicButton, new JLabel());

        // Add tabs to tabbed pane
        tabs.addTab("Mobile", mobilePanel);
        tabs.addTab("MP3", mp3Panel);
        add(tabs, BorderLayout.CENTER);
        add(new JScrollPane(txtDisplay), BorderLayout.SOUTH);
    }

    // Method to add components to a panel
    private void addToPanel(JPanel panel, Component comp1, Component comp2) {
        panel.add(comp1);
        panel.add(comp2);
    }

    // Method to add a mobile phone to the list of gadgets
    private void addMobile() {
        try {
            // Get details of the mobile phone from input fields
            String model = modelTextbox.getText();
            if (model.isEmpty()) {
                // Display a prompt for empty model
                JOptionPane.showMessageDialog(this, "Please enter a model for the mobile phone.", "Missing Model", JOptionPane.WARNING_MESSAGE);
                return; // Exit the method if model is empty
            }

            String size = sizeTextbox.getText();
            if (size.isEmpty()) {
                // Display a prompt for empty model
                JOptionPane.showMessageDialog(this, "Please enter a size for the mobile phone.", "Missing Model", JOptionPane.WARNING_MESSAGE);
                return; // Exit the method if model is empty
            }

            double price = Double.parseDouble(priceTextbox.getText());
            int weight = Integer.parseInt(weightTextbox.getText());
            int creditMinutes = Integer.parseInt(creditTextbox.getText());

            // Create a new mobile phone and add it to the list
            gadgets.add(new Mobile(model, price, weight, size, creditMinutes));
            // Clear input fields
            clearMobile();
            // Prompt to indicate successful addition
            JOptionPane.showMessageDialog(this, "Mobile phone added successfully.");
        } catch (NumberFormatException e) {
            // Display a prompt for invalid input
            JOptionPane.showMessageDialog(this, "Please enter valid numeric data for price, weight, and credit.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to clear input fields for adding a mobile phone
    private void clearMobile() {
        modelTextbox.setText("");
        priceTextbox.setText("");
        weightTextbox.setText("");
        sizeTextbox.setText("");
        creditTextbox.setText("");
        phoneNumberTextbox.setText("");
        durationTextbox.setText("");
        creditToAddTextbox.setText("");
    }

    // Method to display details of all mobile phones
    private void displayAllMobiles() {
        // Clear the display area
        txtDisplay.setText("");
        // Loop through all gadgets and display details
        for (Gadget gadget : gadgets) {
            gadget.display();
            txtDisplay.append("\n");
        }
    }

    // Method to make a call with a selected mobile phone
    private void makeCall() {
        try {
            // Get the selected display number
            int displayNumber = Integer.parseInt((String) cmbDisplayNumber.getSelectedItem());
            // Check if a valid display number is selected and within range
            if (displayNumber != -1 && displayNumber < gadgets.size()) {
                // Get the mobile phone object corresponding to the selected display number
                Mobile mobile = (Mobile) gadgets.get(displayNumber);
                // Get phone number from input field
                String phoneNumber = phoneNumberTextbox.getText();
                // Validate phone number input
                if (!phoneNumber.matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid phone number containing only digits.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Get call duration from input field
                int duration = Integer.parseInt(durationTextbox.getText());
                // Make the call using the selected mobile phone
                mobile.makeCall(phoneNumber, duration);
                // Display remaining calling credit on console
                JOptionPane.showMessageDialog(this, "call was successful.");

                System.out.println("Remaining calling credit: " + mobile.getCallingCredit());
            } else {
                // Prompt the user to change the display number
                JOptionPane.showMessageDialog(this, "Please select a valid display number.", "Invalid Display Number", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // Display a prompt for invalid input
            JOptionPane.showMessageDialog(this, "Please enter a valid number for duration.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to add credit for calls to a selected mobile phone
    private void addCredit() {
        try {
            // Get the selected display number
            int displayNumber = Integer.parseInt((String) cmbDisplayNumber.getSelectedItem());
            // Check if a valid display number is selected and within range
            if (displayNumber != -1 && displayNumber < gadgets.size()) {
                // Get the mobile phone object corresponding to the selected display number
                Mobile mobile = (Mobile) gadgets.get(displayNumber);
                // Get the credit to add from input field
                String creditToAddStr = creditToAddTextbox.getText();

                // Validate input fields
                if (creditToAddStr.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter credit to add.", "Missing Information", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method if any required field is empty
                }

                int creditToAdd = Integer.parseInt(creditToAddStr);

                // Add the credit to the selected mobile phone
                mobile.addCallingCredit(creditToAdd);
                // Display remaining calling credit on console
                JOptionPane.showMessageDialog(this, "credit was added successfully.");

                System.out.println("Remaining calling credit: " + mobile.getCallingCredit());
            } else {
                // Prompt the user to change the display number
                JOptionPane.showMessageDialog(this, "Please select a valid display number.", "Invalid Display Number", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // Display a prompt for invalid input
            JOptionPane.showMessageDialog(this, "Please enter a valid number for credit to add.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Method to add an MP3 player to the list of gadgets
    private void addMP3() {
        try {
            // Get details of the MP3 player from input fields

            String model = mp3ModelTextbox.getText();
            if (model.isEmpty()) {
                // Display a prompt for empty model
                JOptionPane.showMessageDialog(this, "Please enter a model for the  MP3.", "Missing Model", JOptionPane.WARNING_MESSAGE);
                return; // Exit the method if model is empty
            }

            String size = mp3SizeTextbox.getText();
            if (size.isEmpty()) {
                // Display a prompt for empty model
                JOptionPane.showMessageDialog(this, "Please enter a size for the MP3 .", "Missing Model", JOptionPane.WARNING_MESSAGE);
                return; // Exit the method if model is empty
            }

            double price = Double.parseDouble(mp3PriceTextbox.getText());
            int weight = Integer.parseInt(mp3WeightTextbox.getText());
            int memorySize = Integer.parseInt(memoryTextbox.getText());

            // Create a new MP3 player and add it to the list
            gadgets.add(new MP3(model, price, weight, size, memorySize));
            // Clear input fields
            clearMP3();
            // Prompt to indicate successful addition
            JOptionPane.showMessageDialog(this, "MP3 player added successfully.");
        } catch (NumberFormatException e) {
            // Display a prompt for invalid input
            JOptionPane.showMessageDialog(this, "Please enter valid numeric data for price, weight, and memory size.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }   

    // Method to clear input fields for adding an MP3 player
    private void clearMP3() {
        mp3ModelTextbox.setText("");
        mp3PriceTextbox.setText("");
        mp3WeightTextbox.setText("");
        mp3SizeTextbox.setText("");
        memoryTextbox.setText("");
        downloadSizeTextbox.setText("");
        deleteSizeTextbox.setText("");
    }

    // Method to display details of all MP3 players
    private void displayAllMP3s() {
        // Clear the display area
        txtDisplay.setText("");
        // Loop through all gadgets and display details
        JOptionPane.showMessageDialog(this, "data has been displayed .");

        
        for (Gadget gadget : gadgets) {
            gadget.display();
            txtDisplay.append("\n");
        }
    }

    
    // Method to download music into a selected MP3 player
    private void downloadMusic() {
    try {
        // Get the selected display number for the MP3 player
        int displayNumber = getMP3DisplayNumber();
        // Check if a valid display number is selected
        if (displayNumber != -1) {
            // Get the MP3 player object corresponding to the selected display number
            MP3 mp3 = (MP3) gadgets.get(displayNumber);
            // Get the download size from input field
            int downloadSize = getDownloadSize();
            if (downloadSize != -1) { // Check if download size is valid
                // Download the music into the selected MP3 player
                mp3.downloadMusic(downloadSize);
                // Update the display after downloading music
                displayAllMP3s();
                // Prompt to indicate successful download
                JOptionPane.showMessageDialog(this, "Music downloaded successfully.");
            }
        } else {
            // Prompt the user to change the display number
            JOptionPane.showMessageDialog(this, "Please select a valid display number.", "Invalid Display Number", JOptionPane.WARNING_MESSAGE);
        }
    } catch (NumberFormatException e) {
        // Display a prompt for invalid input
        JOptionPane.showMessageDialog(this, "Please enter a valid number for download size.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
    }
    }

    // Helper method to get the download size from the input field
    private int getDownloadSize() {
    try {
        int downloadSize = Integer.parseInt(downloadSizeTextbox.getText());
        if (downloadSize <= 0) { // Check if download size is not negative or zero
            throw new NumberFormatException();
        }
        return downloadSize;
    } catch (NumberFormatException e) {
        // Display a prompt for invalid input
        JOptionPane.showMessageDialog(this, "Please enter a valid positive number for download size.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        return -1;
    }
    }

    // Helper method to get the display number for the MP3 player from the input field
    private int getMP3DisplayNumber() {
        try {
            int displayNumber = Integer.parseInt((String) cmbMP3DisplayNumber.getSelectedItem());
            if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                // Display a prompt for invalid input
                JOptionPane.showMessageDialog(this, "Please enter a valid display number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
            return displayNumber;
        } catch (NumberFormatException e) {
            // Display a prompt for invalid input
            JOptionPane.showMessageDialog(this, "Please enter a valid display number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }   

    // Helper method to get the delete size from the input field
    private int getDeleteSize() {
    try {
        int deleteSize = Integer.parseInt(deleteSizeTextbox.getText());
        if (deleteSize <= 0) { // Check if delete size is not negative or zero
            throw new NumberFormatException();
        }
        return deleteSize;
    } catch (NumberFormatException e) {
        // Display a prompt for invalid input
        JOptionPane.showMessageDialog(this, "Please enter a valid positive number for delete size.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        return -1;
    }
    }

    // Method to delete music from a selected MP3 player
    private void deleteMusic() {
    try {
        // Get the selected display number for the MP3 player
        int displayNumber = getMP3DisplayNumber();
        // Check if a valid display number is selected
        if (displayNumber != -1) {
            // Get the MP3 player object corresponding to the selected display number
            MP3 mp3 = (MP3) gadgets.get(displayNumber);
            // Get the delete size from input field
            int deleteSize = getDeleteSize();
            if (deleteSize != -1) { // Check if delete size is valid
                // Delete the music from the selected MP3 player
                mp3.deleteMusic(deleteSize);
                // Update the display after deleting music
                displayAllMP3s();
                // Prompt to indicate successful deletion
                JOptionPane.showMessageDialog(this, "Music deleted successfully.");
            }
        } else {
            // Prompt the user to change the display number
            JOptionPane.showMessageDialog(this, "Please select a valid display number.", "Invalid Display Number", JOptionPane.WARNING_MESSAGE);
        }
    } catch (NumberFormatException e) {
        // Display a prompt for invalid input
        JOptionPane.showMessageDialog(this, "Please enter a valid number for delete size.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
    }
    }


    // Main method to start the application
    public static void main(String[] args) {
        // Create an instance of the GUI
        new GadgetShopGUI();
    }
}