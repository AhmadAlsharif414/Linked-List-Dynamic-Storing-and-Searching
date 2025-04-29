import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MSLL msll = new MSLL();

    public static void main(String[] args) {
        GUIinterface();
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add to MSLL head");
            System.out.println("2. Add to MSLL tail");
            System.out.println("3. Delete from MSLL");
            System.out.println("4. Check if key is in MSLL");
            System.out.println("5. Make city sublist empty");
            System.out.println("6. Delete city sublist");
            System.out.println("7. Display city sublist");
            System.out.println("8. Add city to sublist at rear");
            System.out.println("9. Add city to sublist at position");
            System.out.println("10. Delete city from sublist");
            System.out.println("11. Get distance");
            System.out.println("12. Search for city");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            while (true) {
                try {
                    choice = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Please Enter a valid number");
                    scanner.nextLine();
                }
            }
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addToMSLLHead();
                    break;
                case 2:
                    addToMSLLTail();
                    break;
                case 3:
                    deleteFromMSLL();
                    break;
                case 4:
                    isInMSLList();
                    break;
                case 5:
                    makeCitySublistEmpty();
                    break;
                case 6:
                    deleteCitySublist();
                    break;
                case 7:
                    displayCitySublist();
                    break;
                case 8:
                    addCityToSublistAtRear();
                    break;
                case 9:
                    addCityToSublistAtPosition();
                    break;
                case 10:
                    deleteCityFromSublist();
                    break;
                case 11:
                    getDistance();
                    break;
                case 12:
                    System.out.print("Enter city name: ");
                    String cityName = scanner.nextLine();
                    if (msll.compareCityMSLL(cityName.toLowerCase()))
                        System.out.println("City found!");
                    else
                        System.out.println("City not found!");
                    break;
                case 13:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (true);
    }

    private static void addToMSLLHead() {
        System.out.print("Enter key: ");
        String key = scanner.nextLine();
        msll.addToMSLLHead(key);
    }

    private static void addToMSLLTail() {
        System.out.print("Enter key: ");
        String key = scanner.nextLine();
        msll.addToMSLLTail(key);
    }

    private static void deleteFromMSLL() {
        System.out.print("Enter key to delete: ");
        String key = scanner.nextLine();
        try {
            msll.deleteFromMSLL(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void isInMSLList() {
        System.out.print("Enter key to search: ");
        String key = scanner.nextLine();
        boolean found = msll.isInMSLList(key);
        if (found) {
            System.out.println("Key " + key + " is in MSLL.");
        } else {
            System.out.println("Key " + key + " is not in MSLL.");
        }
    }

    private static void makeCitySublistEmpty() {
        System.out.print("Enter key for city sublist: ");
        String key = scanner.nextLine();
        try {
            msll.makeCitySublistEmpty(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteCitySublist() {
        System.out.print("Enter key for city sublist: ");
        String key = scanner.nextLine();
        try {
            msll.deleteCitySublist(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void displayCitySublist() {
        System.out.print("Enter key for city sublist: ");
        String key = scanner.nextLine();
        try {
            msll.displayCitySublist(key);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addCityToSublistAtRear() {
        System.out.print("Enter city name: ");
        String cityName = scanner.nextLine();
        System.out.print("Enter city latitude: ");
        double latitude;
        double longitude;
        while (true) {
            try {
                latitude = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Please Enter a valid number");
                scanner.nextLine();
            }
        }
        System.out.print("Enter city longitude: ");
        while (true) {
            try {
                longitude = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Please Enter a valid number");
                scanner.nextLine();
            }
        }
        City city = new City(cityName.toLowerCase(), latitude, longitude);
        try {
            msll.addCityToSublistAtRear(city);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.nextLine(); // consume newline character
    }

    private static void addCityToSublistAtPosition() {
        System.out.print("Enter city name: ");
        String cityName = scanner.nextLine();
        double latitude;
        double longitude;
        int position;
        System.out.print("Enter city latitude: ");
        while (true) {
            try {
                latitude = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Please Enter a valid number");
                scanner.nextLine();
            }
        }
        System.out.print("Enter city longitude: ");
        while (true) {
            try {
                longitude = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Please Enter a valid number");
                scanner.nextLine();
            }
        }
        System.out.print("Enter position: ");
        while (true) {
            try {
                position = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please Enter a valid number");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        City city = new City(cityName.toLowerCase(), latitude, longitude);
        try {
            msll.addCityToSublistAtPosition(city, position);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteCityFromSublist() {
        System.out.print("Enter city name to delete: ");
        String cityName = scanner.nextLine();
        try {
            msll.deleteCityFromSublist(cityName.toLowerCase());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getDistance() {
        System.out.print("Enter source city name: ");
        String sourceName = scanner.nextLine();
        System.out.print("Enter destination city name: ");
        String destName = scanner.nextLine();

        City sourceCity = msll.findCityMSLL(sourceName.toLowerCase());
        City destCity = msll.findCityMSLL(destName.toLowerCase());

        if (sourceCity != null && destCity != null) {
            try {
                double distance = City.getDistence(sourceCity, destCity);
                System.out.println("Distance between " + sourceName + " and " + destName + " is " + distance + " km.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Source city or destination city not found.");
        }
    }

    private static void GUIinterface() {
        // Create a new JFrame window
        JFrame frame = new JFrame("Symmetrical Button Interface");
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel for the welcome message and buttons
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        frame.add(panel);

        // Create a GridBagConstraints to align components vertically
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding around the components
        gbc.anchor = GridBagConstraints.CENTER;

        // Create a JLabel for the welcome message
        JLabel welcomeLabel = new JLabel("Welcome please choose what you would like to do.");
        welcomeLabel.setForeground(Color.WHITE); // Set text color to white
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        panel.add(welcomeLabel, gbc);

        // Create a JPanel for the buttons
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        gbc.gridy = 1; // Update the grid y position for the buttons
        panel.add(buttonPanel, gbc);

        // Reset the GridBagConstraints for the buttons
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Create 7 buttons on the left side
        JButton button1 = createButton("1. Add to MSLL head", "Method" + (1));
        gbc.gridy = 0;
        buttonPanel.add(button1, gbc);

        JButton button2 = createButton("2. Add to MSLL tail", "Method" + (2));
        gbc.gridy = 1;
        buttonPanel.add(button2, gbc);

        JButton button3 = createButton("3. Delete from MSLL", "Method" + (3));
        gbc.gridy = 2;
        buttonPanel.add(button3, gbc);

        JButton button4 = createButton("4. Check if key is in MSLL", "Method" + (4));
        gbc.gridy = 3;
        buttonPanel.add(button4, gbc);

        JButton button5 = createButton("5. Make city sublist empty", "Method" + (5));
        gbc.gridy = 4;
        buttonPanel.add(button5, gbc);

        JButton button6 = createButton("6. Delete city sublist", "Method" + (6));
        gbc.gridy = 5;
        buttonPanel.add(button6, gbc);

        JButton button7 = createButton("7. Display city sublist", "Method" + (7));
        gbc.gridy = 6;
        buttonPanel.add(button7, gbc);




        // Create 7 buttons on the right side
        gbc.gridx = 1;
        JButton button8 = createButton("8. Add city to sublist at rear", "Method" + (8));
        gbc.gridy = 0;
        buttonPanel.add(button8, gbc);

        JButton button9 = createButton("9. Add city to sublist at position", "Method" + (9));
        gbc.gridy = 1;
        buttonPanel.add(button9, gbc);

        JButton button10 = createButton("10. Delete city from sublist", "Method" + (10));
        gbc.gridy = 2;
        buttonPanel.add(button10, gbc);

        JButton button11 = createButton("11. Get distance", "Method" + (11));
        gbc.gridy = 3;
        buttonPanel.add(button11, gbc);

        JButton button12 = createButton("12. Search for city", "Method" + (12));
        gbc.gridy = 4;
        buttonPanel.add(button12, gbc);

        JButton button13 = createButton("13. Exit", "Method" + (13));
        gbc.gridy = 5;
        buttonPanel.add(button13, gbc);

        // Display the JFrame
        frame.setVisible(true);
    }

    private static JButton createButton(String buttonText, final String methodName) {
        JButton button = new JButton(buttonText);
        button.setBackground(new Color(255, 140, 0)); // Set button color to dark orange
        button.setForeground(Color.WHITE); // Set text color to white
        button.setPreferredSize(new Dimension(300, 50)); // Set preferred size to make it bigger
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the method based on the method name
                    Method method = Main.class.getDeclaredMethod(methodName);
                    method.invoke(null);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        return button;
    }

    // Method 1
    private static void Method1() {
        System.out.println("Method 1 executed");
        // Add your code here for Method 1
        //Add to MSLL head
        addToMSLLHeadGUI();
    }

    // Method 2
    private static void Method2() {
        System.out.println("Method 2 executed");
        // Add your code here for Method 2
        //Add to MSLL tail
        addToMSLLTailGUI();
    }

    // Method 3
    private static void Method3() {
        System.out.println("Method 3 executed");
        // Add your code here for Method 3
        // Delete from MSLL
        deleteFromMSLLGUI();
    }

    // Method 4
    private static void Method4() {
        System.out.println("Method 4 executed");
        // Add your code here for Method 4
        //Check if key is in MSLL
        isInMSLLGUI();
    }

    // Method 5
    private static void Method5() {
        System.out.println("Method 5 executed");
        // Add your code here for Method 5
        //Make city sublist empty
        makeSublistEmptyGUI();
    }

    // Method 6
    private static void Method6() {
        System.out.println("Method 6 executed");
        // Add your code here for Method 6
        //Delete city sublist
        deleteCitySublistGUI();
    }

    // Method 7
    private static void Method7() {
        System.out.println("Method 7 executed");
        // Add your code here for Method 7
        //Display city sublist
        displaySublistGUI();
    }

    // Method 8
    private static void Method8() {
        System.out.println("Method 8 executed");
        // Add your code here for Method 8
        //Add city to sublist at rear
        addAtRearGUI();
    }

    // Method 9
    private static void Method9() {
        System.out.println("Method 9 executed");
        // Add your code here for Method 9
        //Add city to sublist at position
        addAtPositionGUI();
    }

    // Method 10
    private static void Method10() {
        System.out.println("Method 10 executed");
        // Add your code here for Method 10
        //Delete city from sublist
        deleteCityfromSublistGUI();
    }

    // Method 11
    private static void Method11() {
        System.out.println("Method 11 executed");
        // Add your code here for Method 11
        //Get distance
        getDistanceGUI();
    }

    // Method 12
    private static void Method12() {
        System.out.println("Method 12 executed");
        // Add your code here for Method 12
        //Search for city
        searchForCityGUI();
    }

    // Method 13
    private static void Method13() {
        System.out.println("Method 13 executed");
        // Add your code here for Method 13
        //Exit
        System.exit(0);
    }

    public static void addAtRearGUI(){
        JFrame frame = new JFrame("Add to sublist at rear");
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(34, 40, 49)); // Set background color to dark blue

        // Create a JPanel for the left side of the interface
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(leftPanel, BorderLayout.WEST); // Add the panel to the left side of the frame

        // Create a JPanel for the right side of the interface
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(rightPanel, BorderLayout.EAST); // Add the panel to the right side of the frame

        // Create a JLabel to display an image on the left side of the interface
        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Replace "image.jpg" with the file path of your image
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel);

        // Create a JPanel for the middle of the interface
        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        frame.add(middlePanel, BorderLayout.CENTER); // Add the panel to the middle of the frame

        // Create a GridBagConstraints object to specify layout parameters for the input boxes and login button
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10); // Add some padding around the components

        // Create a JLabel for the username input box
        JLabel cityNameLabel = new JLabel("Enter City Name: ");
        cityNameLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 0;
        middlePanel.add(cityNameLabel, c);

        // Create a JTextField for the username input
        JTextField cityNameField = new JTextField(20); // Set the size of the text field to 20 characters wide
        cityNameField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 0;
        middlePanel.add(cityNameField, c);

        // Create a JLabel for the latitude input box
        JLabel latitudeLabel = new JLabel("Enter City Latitude: ");
        latitudeLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 1;
        middlePanel.add(latitudeLabel, c);

        // Create a JTextField for the latitude input
        JTextField latitudeField = new JTextField(20); // Set the size of the text field to 20 characters wide
        latitudeField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 1;
        middlePanel.add(latitudeField, c);

        // Create a JLabel for the longitude input box
        JLabel longitudeLabel = new JLabel("Enter City longitude:");
        longitudeLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 2;
        middlePanel.add(longitudeLabel, c);

        // Create a JTextField for the longitude input
        JTextField longitudeField = new JTextField(20); // Set the size of the text field to 20 characters wide
        longitudeField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 2;
        middlePanel.add(longitudeField, c);

        JButton addButton = new JButton("Add");
        addButton.setBackground(new Color(255, 140, 0)); // Set button color to dark orange
        addButton.setForeground(Color.WHITE); // Set text color to white
        addButton.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the button to 300x50 pixels
        c.gridx = 0;
        c.gridy = 3; // Change the grid y-coordinate to 3
        c.gridwidth = 2; // Set the grid width to span 2 columns
        middlePanel.add(addButton, c);

        // Add an ActionListener to the addButton
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the entered city name, latitude, and longitude
                String cityName = cityNameField.getText();
                int latitude = 0;
                int longitude = 0;
                try {
                    latitude = Integer.parseInt(latitudeField.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number for latitude.");
                    latitudeField.setText(""); // Clear the latitudeField
                }


                try {
                    longitude = Integer.parseInt(longitudeField.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number for longitude.");
                    longitudeField.setText(""); // Clear the longitudeField
                }

                City city = new City(cityName.toLowerCase(), latitude, longitude); // create City object with given name, latitude, and longitude
                try {
                    msll.addCityToSublistAtRear(city);
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }

                cityNameField.setText(""); // Clear the cityNameField
                latitudeField.setText(""); // Clear the latitudeField
                longitudeField.setText(""); // Clear the longitudeField
                frame.dispose();
            }
        });

        // Display the JFrame window
        frame.setVisible(true);
    }

    public static void addAtPositionGUI() {
        JFrame frame = new JFrame("Add to sublist at Position");
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(34, 40, 49)); // Set background color to dark blue

        // Create a JPanel for the left side of the interface
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(leftPanel, BorderLayout.WEST); // Add the panel to the left side of the frame

        // Create a JPanel for the right side of the interface
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(rightPanel, BorderLayout.EAST); // Add the panel to the right side of the frame

        // Create a JLabel to display an image on the left side of the interface
        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Replace "image.jpg" with the file path of your image
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel);

        // Create a JPanel for the middle of the interface
        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        frame.add(middlePanel, BorderLayout.CENTER); // Add the panel to the middle of the frame

        // Create a GridBagConstraints object to specify layout parameters for the input boxes and login button
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10); // Add some padding around the components

        // Create a JLabel for the fourth input box
        JLabel fourthLabel = new JLabel("Enter Position");
        fourthLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 0; // Change the grid y-coordinate to 0
        middlePanel.add(fourthLabel, c);

        // Create a JTextField for the fourth input
        JTextField fourthField = new JTextField(20); // Set the size of the text field to 20 characters wide
        fourthField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 0; // Change the grid y-coordinate to 0
        middlePanel.add(fourthField, c);

        // Create a JLabel for the username input box
        JLabel usernameLabel = new JLabel("Enter City Name: ");
        usernameLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 1; // Change the grid y-coordinate to 1
        middlePanel.add(usernameLabel, c);

        // Create a JTextField for the username input
        JTextField usernameField = new JTextField(20); // Set the size of the text field to 20 characters wide
        usernameField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 1; // Change the grid y-coordinate to 1
        middlePanel.add(usernameField, c);

        // Create a JLabel for the password input box
        JLabel passwordLabel = new JLabel("Enter City Latitude: ");
        passwordLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 2; // Change the grid y-coordinate to 2
        middlePanel.add(passwordLabel, c);

        // Create a JTextField for the password input
        JTextField passwordField = new JTextField(20); // Set the size of the text field to 20 characters wide
        passwordField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 2; // Change the grid y-coordinate to 2
        middlePanel.add(passwordField, c);

        // Create a JLabel for the third input box
        JLabel thirdLabel = new JLabel("Enter City Longitude:");
        thirdLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 3; // Change the grid y-coordinate to 3
        middlePanel.add(thirdLabel, c);

        // Create a JTextField for the third input
        JTextField thirdField = new JTextField(20); // Set the size of the text field to 20 characters wide
        thirdField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 3; // Change the grid y-coordinate to 3
        middlePanel.add(thirdField, c);

        JButton addButton = new JButton("Add");
        addButton.setBackground(new Color(255, 140, 0)); // Set button color to dark orange
        addButton.setForeground(Color.WHITE); // Set text color to white
        addButton.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the button to 300x50 pixels
        c.gridx = 0;
        c.gridy = 4; // Change the grid y-coordinate to 4
        c.gridwidth = 2; // Set the grid width to span 2 columns
        middlePanel.add(addButton, c);

        // Add an ActionListener to the addButton
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the entered city name, latitude, longitude, and position
                String cityName = usernameField.getText();
                int latitude = 0;
                int longitude = 0;
                int position = 0;

                try {
                    latitude = Integer.parseInt(passwordField.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number for latitude.");
                    passwordField.setText(""); // Clear the latitudeField
                }

                try {
                    longitude = Integer.parseInt(thirdField.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number for longitude.");
                    thirdField.setText(""); // Clear the longitudeField
                }

                try {
                    position = Integer.parseInt(fourthField.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number for position.");
                    fourthField.setText(""); // Clear the fourthField
                }

                City city = new City(cityName.toLowerCase(), latitude, longitude); // create City object with given name, latitude, and longitude
                try {
                    msll.addCityToSublistAtPosition(city, position);
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }

                usernameField.setText(""); // Clear the usernameField
                passwordField.setText(""); // Clear the passwordField
                thirdField.setText(""); // Clear the thirdField
                fourthField.setText(""); // Clear the fourthField
                frame.dispose();
            }
        });

        // Display the JFrame window
        frame.setVisible(true);
    }

    public static void addToMSLLHeadGUI(){
        // Create a new JFrame window
        JFrame frame = new JFrame("addToMSLLHeadGUI");
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(34, 40, 49)); // Set background color to dark blue

        // Create a JPanel for the left side of the interface
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(leftPanel, BorderLayout.WEST); // Add the panel to the left side of the frame

        // Create a JPanel for the right side of the interface
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(rightPanel, BorderLayout.EAST); // Add the panel to the right side of the frame

        // Create a JLabel to display an image on the left side of the interface
        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Replace "image.jpg" with the file path of your image
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel);

        // Create a JPanel for the middle of the interface
        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        frame.add(middlePanel, BorderLayout.CENTER); // Add the panel to the middle of the frame

        // Create a GridBagConstraints object to specify layout parameters for the input boxes and login button
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10); // Add some padding around the components

        // Create a JLabel for the username input box
        JLabel usernameLabel = new JLabel("Enter Key: ");
        usernameLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 0;
        middlePanel.add(usernameLabel, c);

        // Create a JTextField for the username input
        JTextField usernameField = new JTextField(20); // Set the size of the text field to 20 characters wide
        usernameField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 0;
        middlePanel.add(usernameField, c);
        // Create a JButton for the "Register new user" button
        JButton registerButton = new JButton("Add to MSLL head");
        registerButton.setBackground(new Color(255, 140, 0)); // Set button color to dark orange
        registerButton.setForeground(Color.WHITE); // Set text color to white
        registerButton.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the button to 300x50 pixels
        c.gridx = 1;
        c.gridy = 3;
        middlePanel.add(registerButton, c);

        // Add an ActionListener to the registerButton
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Add your code here to handle the registration process
                String key = usernameField.getText();
                msll.addToMSLLHead(key);
                frame.dispose();
            }
        });

        // Display the JFrame window
        frame.setVisible(true);
    }

    public static void addToMSLLTailGUI(){
        // Create a new JFrame window
        JFrame frame = new JFrame("addToMSLLTailGUI");
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(34, 40, 49)); // Set background color to dark blue

        // Create a JPanel for the left side of the interface
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(leftPanel, BorderLayout.WEST); // Add the panel to the left side of the frame

        // Create a JPanel for the right side of the interface
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(rightPanel, BorderLayout.EAST); // Add the panel to the right side of the frame

        // Create a JLabel to display an image on the left side of the interface
        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Replace "image.jpg" with the file path of your image
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel);

        // Create a JPanel for the middle of the interface
        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        frame.add(middlePanel, BorderLayout.CENTER); // Add the panel to the middle of the frame

        // Create a GridBagConstraints object to specify layout parameters for the input boxes and login button
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10); // Add some padding around the components

        // Create a JLabel for the username input box
        JLabel usernameLabel = new JLabel("Enter Key: ");
        usernameLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 0;
        middlePanel.add(usernameLabel, c);

        // Create a JTextField for the username input
        JTextField usernameField = new JTextField(20); // Set the size of the text field to 20 characters wide
        usernameField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 0;
        middlePanel.add(usernameField, c);
        // Create a JButton for the "Register new user" button
        JButton registerButton = new JButton("Add to MSLL tail");
        registerButton.setBackground(new Color(255, 140, 0)); // Set button color to dark orange
        registerButton.setForeground(Color.WHITE); // Set text color to white
        registerButton.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the button to 300x50 pixels
        c.gridx = 1;
        c.gridy = 3;
        middlePanel.add(registerButton, c);

        // Add an ActionListener to the registerButton
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Add your code here to handle the registration process
                String key = usernameField.getText();
                msll.addToMSLLTail(key);
                frame.dispose();
            }
        });

        // Display the JFrame window
        frame.setVisible(true);
    }

    public static void deleteFromMSLLGUI(){
        // Create a new JFrame window
        JFrame frame = new JFrame("deleteFromMSLLGUI");
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(34, 40, 49)); // Set background color to dark blue

        // Create a JPanel for the left side of the interface
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(leftPanel, BorderLayout.WEST); // Add the panel to the left side of the frame

        // Create a JPanel for the right side of the interface
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(rightPanel, BorderLayout.EAST); // Add the panel to the right side of the frame

        // Create a JLabel to display an image on the left side of the interface
        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Replace "image.jpg" with the file path of your image
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel);

        // Create a JPanel for the middle of the interface
        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        frame.add(middlePanel, BorderLayout.CENTER); // Add the panel to the middle of the frame

        // Create a GridBagConstraints object to specify layout parameters for the input boxes and login button
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10); // Add some padding around the components

        // Create a JLabel for the username input box
        JLabel usernameLabel = new JLabel("Enter Key to be deleted: ");
        usernameLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 0;
        middlePanel.add(usernameLabel, c);

        // Create a JTextField for the username input
        JTextField usernameField = new JTextField(20); // Set the size of the text field to 20 characters wide
        usernameField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 0;
        middlePanel.add(usernameField, c);
        // Create a JButton for the "Register new user" button
        JButton registerButton = new JButton("Delete");
        registerButton.setBackground(new Color(255, 140, 0)); // Set button color to dark orange
        registerButton.setForeground(Color.WHITE); // Set text color to white
        registerButton.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the button to 300x50 pixels
        c.gridx = 1;
        c.gridy = 3;
        middlePanel.add(registerButton, c);

        // Add an ActionListener to the registerButton
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = usernameField.getText();
                try {
                    msll.deleteFromMSLL(key);
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                frame.dispose();
            }
        });

        // Display the JFrame window
        frame.setVisible(true);
    }

    public static void isInMSLLGUI(){
        // Create a new JFrame window
        JFrame frame = new JFrame("isInMSLLGUI");
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(34, 40, 49)); // Set background color to dark blue

        // Create a JPanel for the left side of the interface
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(leftPanel, BorderLayout.WEST); // Add the panel to the left side of the frame

        // Create a JPanel for the right side of the interface
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(rightPanel, BorderLayout.EAST); // Add the panel to the right side of the frame

        // Create a JLabel to display an image on the left side of the interface
        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Replace "image.jpg" with the file path of your image
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel);

        // Create a JPanel for the middle of the interface
        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        frame.add(middlePanel, BorderLayout.CENTER); // Add the panel to the middle of the frame

        // Create a GridBagConstraints object to specify layout parameters for the input boxes and login button
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10); // Add some padding around the components

        // Create a JLabel for the username input box
        JLabel usernameLabel = new JLabel("Enter key to search: ");
        usernameLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 0;
        middlePanel.add(usernameLabel, c);

        // Create a JTextField for the username input
        JTextField usernameField = new JTextField(20); // Set the size of the text field to 20 characters wide
        usernameField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 0;
        middlePanel.add(usernameField, c);
        // Create a JButton for the "Register new user" button
        JButton registerButton = new JButton("Search");
        registerButton.setBackground(new Color(255, 140, 0)); // Set button color to dark orange
        registerButton.setForeground(Color.WHITE); // Set text color to white
        registerButton.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the button to 300x50 pixels
        c.gridx = 1;
        c.gridy = 3;
        middlePanel.add(registerButton, c);

        // Add an ActionListener to the registerButton
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = usernameField.getText();
                boolean found = msll.isInMSLList(key);
                if (found) {
                    System.out.println("Key " + key + " is in MSLL.");
                } else {
                    System.out.println("Key " + key + " is not in MSLL.");
                }
                frame.dispose();
            }
        });

        // Display the JFrame window
        frame.setVisible(true);
    }

    public static void makeSublistEmptyGUI(){
        // Create a new JFrame window
        JFrame frame = new JFrame("makeSublistEmptyGUI");
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(34, 40, 49)); // Set background color to dark blue

        // Create a JPanel for the left side of the interface
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(leftPanel, BorderLayout.WEST); // Add the panel to the left side of the frame

        // Create a JPanel for the right side of the interface
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(rightPanel, BorderLayout.EAST); // Add the panel to the right side of the frame

        // Create a JLabel to display an image on the left side of the interface
        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Replace "image.jpg" with the file path of your image
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel);

        // Create a JPanel for the middle of the interface
        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        frame.add(middlePanel, BorderLayout.CENTER); // Add the panel to the middle of the frame

        // Create a GridBagConstraints object to specify layout parameters for the input boxes and login button
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10); // Add some padding around the components

        // Create a JLabel for the username input box
        JLabel usernameLabel = new JLabel("Enter City: ");
        usernameLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 0;
        middlePanel.add(usernameLabel, c);

        // Create a JTextField for the username input
        JTextField usernameField = new JTextField(20); // Set the size of the text field to 20 characters wide
        usernameField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 0;
        middlePanel.add(usernameField, c);
        // Create a JButton for the "Register new user" button
        JButton registerButton = new JButton("Make Empty");
        registerButton.setBackground(new Color(255, 140, 0)); // Set button color to dark orange
        registerButton.setForeground(Color.WHITE); // Set text color to white
        registerButton.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the button to 300x50 pixels
        c.gridx = 1;
        c.gridy = 3;
        middlePanel.add(registerButton, c);

        // Add an ActionListener to the registerButton
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = usernameField.getText();
                try {
                    msll.makeCitySublistEmpty(key);
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                frame.dispose();
            }
        });

        // Display the JFrame window
        frame.setVisible(true);
    }

    public static void deleteCitySublistGUI(){
        // Create a new JFrame window
        JFrame frame = new JFrame("deleteCitySublistGUI");
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(34, 40, 49)); // Set background color to dark blue

        // Create a JPanel for the left side of the interface
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(leftPanel, BorderLayout.WEST); // Add the panel to the left side of the frame

        // Create a JPanel for the right side of the interface
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(rightPanel, BorderLayout.EAST); // Add the panel to the right side of the frame

        // Create a JLabel to display an image on the left side of the interface
        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Replace "image.jpg" with the file path of your image
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel);

        // Create a JPanel for the middle of the interface
        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        frame.add(middlePanel, BorderLayout.CENTER); // Add the panel to the middle of the frame

        // Create a GridBagConstraints object to specify layout parameters for the input boxes and login button
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10); // Add some padding around the components

        // Create a JLabel for the username input box
        JLabel usernameLabel = new JLabel("Enter Key");
        usernameLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 0;
        middlePanel.add(usernameLabel, c);

        // Create a JTextField for the username input
        JTextField usernameField = new JTextField(20); // Set the size of the text field to 20 characters wide
        usernameField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 0;
        middlePanel.add(usernameField, c);
        // Create a JButton for the "Register new user" button
        JButton registerButton = new JButton("Delete");
        registerButton.setBackground(new Color(255, 140, 0)); // Set button color to dark orange
        registerButton.setForeground(Color.WHITE); // Set text color to white
        registerButton.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the button to 300x50 pixels
        c.gridx = 1;
        c.gridy = 3;
        middlePanel.add(registerButton, c);

        // Add an ActionListener to the registerButton
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = usernameField.getText();
                try {
                    msll.deleteCitySublist(key);
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                frame.dispose();
            }
        });
        // Display the JFrame window
        frame.setVisible(true);
    }

    public static void deleteCityfromSublistGUI(){
        // Create a new JFrame window
        JFrame frame = new JFrame("deleteCityfromSublistGUI");
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(34, 40, 49)); // Set background color to dark blue

        // Create a JPanel for the left side of the interface
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(leftPanel, BorderLayout.WEST); // Add the panel to the left side of the frame

        // Create a JPanel for the right side of the interface
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(rightPanel, BorderLayout.EAST); // Add the panel to the right side of the frame

        // Create a JLabel to display an image on the left side of the interface
        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Replace "image.jpg" with the file path of your image
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel);

        // Create a JPanel for the middle of the interface
        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        frame.add(middlePanel, BorderLayout.CENTER); // Add the panel to the middle of the frame

        // Create a GridBagConstraints object to specify layout parameters for the input boxes and login button
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10); // Add some padding around the components

        // Create a JLabel for the username input box
        JLabel usernameLabel = new JLabel("Enter City Name to delete");
        usernameLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 0;
        middlePanel.add(usernameLabel, c);

        // Create a JTextField for the username input
        JTextField usernameField = new JTextField(20); // Set the size of the text field to 20 characters wide
        usernameField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 0;
        middlePanel.add(usernameField, c);
        // Create a JButton for the "Register new user" button
        JButton registerButton = new JButton("Delete");
        registerButton.setBackground(new Color(255, 140, 0)); // Set button color to dark orange
        registerButton.setForeground(Color.WHITE); // Set text color to white
        registerButton.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the button to 300x50 pixels
        c.gridx = 1;
        c.gridy = 3;
        middlePanel.add(registerButton, c);

        // Add an ActionListener to the registerButton
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cityName = usernameField.getText();
                try {
                    msll.deleteCityFromSublist(cityName.toLowerCase());
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                frame.dispose();
            }
        });
        // Display the JFrame window
        frame.setVisible(true);
    }

    public static void getDistanceGUI(){
        // Create a new JFrame window
        JFrame frame = new JFrame("AdminLogin");
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(34, 40, 49)); // Set background color to dark blue

        // Create a JPanel for the left side of the interface
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(leftPanel, BorderLayout.WEST); // Add the panel to the left side of the frame

        // Create a JPanel for the right side of the interface
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(rightPanel, BorderLayout.EAST); // Add the panel to the right side of the frame

        // Create a JLabel to display an image on the left side of the interface
        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Replace "image.jpg" with the file path of your image
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel);

        // Create a JPanel for the middle of the interface
        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        frame.add(middlePanel, BorderLayout.CENTER); // Add the panel to the middle of the frame

        // Create a GridBagConstraints object to specify layout parameters for the input boxes and login button
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10); // Add some padding around the components

        // Create a JLabel for the username input box
        JLabel usernameLabel = new JLabel("Source City Name: ");
        usernameLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 0;
        middlePanel.add(usernameLabel, c);

        // Create a JTextField for the username input
        JTextField usernameField = new JTextField(20); // Set the size of the text field to 20 characters wide
        usernameField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 0;
        middlePanel.add(usernameField, c);

        // Create a JLabel for the password input box
        JLabel passwordLabel = new JLabel("Destination City Name: ");
        passwordLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 1;
        middlePanel.add(passwordLabel, c);

        // Create a JPasswordField for the password input
        JTextField passwordField = new JTextField(20); // Set the size of the password field to 20 characters wide
        passwordField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the password field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 1;
        middlePanel.add(passwordField, c);

        // Create a JButton for the login button
        JButton loginButton = new JButton("Get Distance");
        loginButton.setBackground(new Color(255, 140, 0)); // Set button color to dark orange
        loginButton.setForeground(Color.WHITE); // Set text color to white
        loginButton.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the button to 300x50 pixels
        c.gridx = 1;
        c.gridy = 2;
        middlePanel.add(loginButton, c);
        // Add an ActionListener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the entered username and password
                String City1Name = usernameField.getText();
                String City2Name = passwordField.getText();

                City sourceCity = msll.findCityMSLL(City1Name.toLowerCase());
                City destCity = msll.findCityMSLL(City2Name.toLowerCase());

                if (sourceCity != null && destCity != null) {
                    try {
                        double distance = City.getDistence(sourceCity, destCity);
                        System.out.println("Distance between " + City1Name + " and " + City2Name + " is " + distance + " km.");
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                } else {
                    System.out.println("Source city or destination city not found.");
                }
                frame.dispose();
            }
        });

        // Display the JFrame window
        frame.setVisible(true);
    }

    public static void searchForCityGUI(){
        // Create a new JFrame window
        JFrame frame = new JFrame("searchForCity");
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(34, 40, 49)); // Set background color to dark blue

        // Create a JPanel for the left side of the interface
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(leftPanel, BorderLayout.WEST); // Add the panel to the left side of the frame

        // Create a JPanel for the right side of the interface
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(rightPanel, BorderLayout.EAST); // Add the panel to the right side of the frame

        // Create a JLabel to display an image on the left side of the interface
        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Replace "image.jpg" with the file path of your image
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel);

        // Create a JPanel for the middle of the interface
        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        frame.add(middlePanel, BorderLayout.CENTER); // Add the panel to the middle of the frame

        // Create a GridBagConstraints object to specify layout parameters for the input boxes and login button
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10); // Add some padding around the components

        // Create a JLabel for the username input box
        JLabel usernameLabel = new JLabel("Enter City Name for Search");
        usernameLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 0;
        middlePanel.add(usernameLabel, c);

        // Create a JTextField for the username input
        JTextField usernameField = new JTextField(20); // Set the size of the text field to 20 characters wide
        usernameField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 0;
        middlePanel.add(usernameField, c);
        // Create a JButton for the "Register new user" button
        JButton registerButton = new JButton("Search");
        registerButton.setBackground(new Color(255, 140, 0)); // Set button color to dark orange
        registerButton.setForeground(Color.WHITE); // Set text color to white
        registerButton.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the button to 300x50 pixels
        c.gridx = 1;
        c.gridy = 3;
        middlePanel.add(registerButton, c);

        // Add an ActionListener to the registerButton
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cityName = usernameField.getText();
                if (msll.compareCityMSLL(cityName.toLowerCase()))
                    System.out.println("City found!");
                else
                    System.out.println("City not found!");
                frame.dispose();
            }
        });
        // Display the JFrame window
        frame.setVisible(true);
    }

    public static void displaySublistGUI(){
        // Create a new JFrame window
        JFrame frame = new JFrame("displaySublistGUI");
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(34, 40, 49)); // Set background color to dark blue

        // Create a JPanel for the left side of the interface
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(leftPanel, BorderLayout.WEST); // Add the panel to the left side of the frame

        // Create a JPanel for the right side of the interface
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(46, 52, 63)); // Set background color to a darker shade of blue
        frame.add(rightPanel, BorderLayout.EAST); // Add the panel to the right side of the frame

        // Create a JLabel to display an image on the left side of the interface
        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Replace "image.jpg" with the file path of your image
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel);

        // Create a JPanel for the middle of the interface
        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setBackground(new Color(34, 40, 49)); // Set background color to dark blue
        frame.add(middlePanel, BorderLayout.CENTER); // Add the panel to the middle of the frame

        // Create a GridBagConstraints object to specify layout parameters for the input boxes and login button
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10); // Add some padding around the components

        // Create a JLabel for the username input box
        JLabel usernameLabel = new JLabel("Enter Key: ");
        usernameLabel.setForeground(Color.WHITE); // Set text color to white
        c.gridx = 0;
        c.gridy = 0;
        middlePanel.add(usernameLabel, c);

        // Create a JTextField for the username input
        JTextField usernameField = new JTextField(20); // Set the size of the text field to 20 characters wide
        usernameField.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the text field to 300x50 pixels
        c.gridx = 1;
        c.gridy = 0;
        middlePanel.add(usernameField, c);
        // Create a JButton for the "Register new user" button
        JButton registerButton = new JButton("Display");
        registerButton.setBackground(new Color(255, 140, 0)); // Set button color to dark orange
        registerButton.setForeground(Color.WHITE); // Set text color to white
        registerButton.setPreferredSize(new Dimension(300, 50)); // Set the preferred size of the button to 300x50 pixels
        c.gridx = 1;
        c.gridy = 3;
        middlePanel.add(registerButton, c);

        // Add an ActionListener to the registerButton
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = usernameField.getText();
                try {
                    msll.displayCitySublist(key);
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                frame.dispose();
            }
        });
        frame.setVisible(true);
    }
}