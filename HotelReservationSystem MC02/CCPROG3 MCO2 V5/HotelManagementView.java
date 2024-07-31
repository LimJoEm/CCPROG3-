// HotelManagementView.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;

public class HotelManagementView extends JFrame {
    private JComboBox<String> hotelDropdown;
    private JComboBox<String> roomDropdown;
    private JComboBox<String> discountDropdown;
    private JTextField guestNameField;
    private JTextField checkInField;
    private JTextField checkOutField;
    private JButton reserveButton;
    private JButton createHotelButton;
    private JButton addRoomButton;
    private JButton removeRoomButton;
    private JButton setModifierButton;
    private JButton viewGuestsButton;
    private JButton cancelReservationButton;
    private JButton viewGuestInfoButton;
    private JTextArea outputArea;

    private final HotelSystem hotelSystem = new HotelSystem();

    private final Color buttonNormalColor = Color.LIGHT_GRAY;
    private final Color buttonHoverColor = Color.WHITE;

    public HotelManagementView() {
        setTitle("Hotel Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Color c1 = Color.WHITE;

        ImageIcon roomIcon      = loadResizedImageIcon("resources/images/room.png", 20, 20);
        ImageIcon hotelIcon     = loadResizedImageIcon("resources/images/hotel.png", 20, 20);
        ImageIcon guestIcon     = loadResizedImageIcon("resources/images/guests.png", 20, 20);
        ImageIcon checkinIcon   = loadResizedImageIcon("resources/images/check-in.png", 20, 20);
        ImageIcon checkoutIcon  = loadResizedImageIcon("resources/images/check-out.png", 20, 20);
        ImageIcon giftIcon      = loadResizedImageIcon("resources/images/gift.png", 20, 20);

        hotelDropdown       = new JComboBox<>();
        roomDropdown        = new JComboBox<>();
        discountDropdown    = new JComboBox<>(new String[]{"None", "I_WORK_HERE", "STAY4_GET1", "PAYDAY"});

        guestNameField          = new JTextField(15);
        checkInField            = new JTextField(5);
        checkOutField           = new JTextField(5);
        reserveButton           = new JButton("Reserve Room");
        createHotelButton       = new JButton("Create Hotel");
        addRoomButton           = new JButton("Add Room");
        removeRoomButton        = new JButton("Remove Room");
        setModifierButton       = new JButton("Set Date Modifier");
        viewGuestsButton        = new JButton("View Guests");
        cancelReservationButton = new JButton("Cancel Reservation");
        viewGuestInfoButton     = new JButton("View Guest Info"); // Initialize new button
        outputArea              = new JTextArea();
        outputArea.setEditable(false);

        reserveButton.setBackground(buttonNormalColor);
        createHotelButton.setBackground(buttonNormalColor);
        addRoomButton.setBackground(buttonNormalColor);
        removeRoomButton.setBackground(buttonNormalColor);
        setModifierButton.setBackground(buttonNormalColor);
        viewGuestsButton.setBackground(buttonNormalColor);
        cancelReservationButton.setBackground(buttonNormalColor);
        viewGuestInfoButton.setBackground(buttonNormalColor);

        reserveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                reserveButton.setBackground(buttonHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                reserveButton.setBackground(buttonNormalColor);
            }
        });

        createHotelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                createHotelButton.setBackground(buttonHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                createHotelButton.setBackground(buttonNormalColor);
            }
        });

        addRoomButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                addRoomButton.setBackground(buttonHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addRoomButton.setBackground(buttonNormalColor);
            }
        });

        removeRoomButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                removeRoomButton.setBackground(buttonHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                removeRoomButton.setBackground(buttonNormalColor);
            }
        });

        setModifierButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setModifierButton.setBackground(buttonHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setModifierButton.setBackground(buttonNormalColor);
            }
        });
        

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);

        JLabel hotelLabel = new JLabel("Select Hotel:", hotelIcon, JLabel.LEFT);
        hotelLabel.setForeground(c1);
        hotelLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        JLabel selectRoom = new JLabel("Select Room:", roomIcon, JLabel.LEFT);
        selectRoom.setForeground(c1);
        selectRoom.setFont(new Font("Monospaced", Font.BOLD, 14));
        JLabel guestName = new JLabel("Guest Name:", guestIcon, JLabel.LEFT);
        guestName.setForeground(c1);
        guestName.setFont(new Font("Monospaced", Font.BOLD, 14));
        JLabel checkIn = new JLabel("Check-In Date:", checkinIcon, JLabel.LEFT);
        checkIn.setForeground(c1);
        checkIn.setFont(new Font("Monospaced", Font.BOLD, 14));
        JLabel checkOut = new JLabel("Check-Out Date:", checkoutIcon, JLabel.LEFT);
        checkOut.setForeground(c1);
        checkOut.setFont(new Font("Monospaced", Font.BOLD, 14));
        JLabel discountCode = new JLabel("Discount Code:", giftIcon, JLabel.LEFT);
        discountCode.setForeground(c1);
        discountCode.setFont(new Font("Monospaced", Font.BOLD, 14));

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(hotelLabel, gbc);
        gbc.gridx = 1;
        panel.add(hotelDropdown, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(new JSeparator(), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        panel.add(selectRoom, gbc);
        gbc.gridx = 1;
        panel.add(roomDropdown, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(new JSeparator(), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        panel.add(guestName, gbc);
        gbc.gridx = 1;
        panel.add(guestNameField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(new JSeparator(), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        panel.add(checkIn, gbc);
        gbc.gridx = 1;
        panel.add(checkInField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(new JSeparator(), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        panel.add(checkOut, gbc);
        gbc.gridx = 1;
        panel.add(checkOutField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(new JSeparator(), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        panel.add(discountCode, gbc);
        gbc.gridx = 1;
        panel.add(discountDropdown, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(new JSeparator(), gbc);

        gbc.gridy++;
        panel.add(reserveButton, gbc);

        gbc.gridy++;
        panel.add(createHotelButton, gbc);

        gbc.gridy++;
        panel.add(addRoomButton, gbc);

        gbc.gridy++;
        panel.add(removeRoomButton, gbc);

        gbc.gridy++;
        panel.add(setModifierButton, gbc);

        gbc.gridy++;
        panel.add(viewGuestsButton, gbc);

        gbc.gridy++;
        panel.add(cancelReservationButton, gbc);

        gbc.gridy++;
        panel.add(viewGuestInfoButton, gbc); 

        gbc.gridy++;
        panel.add(new JScrollPane(outputArea), gbc);

        add(panel);

    
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reserveRoom();
            }
        });

        createHotelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createHotel();
            }
        });

        addRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRoom();
            }
        });

        removeRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeRoom();
            }
        });

        setModifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setModifier();
            }
        });

        viewGuestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewGuests();
            }
        });

        cancelReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelReservation();
            }
        });

        viewGuestInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewGuestInfo();
            }
        });

        hotelDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRoomDropdown();
            }
        });

        populateHotelDropdown();
    }

    private void populateHotelDropdown() {
        hotelDropdown.removeAllItems();
        for (Hotel hotel : hotelSystem.getHotels()) {
            hotelDropdown.addItem(hotel.getName());
        }
    }

    private void updateRoomDropdown() {
        roomDropdown.removeAllItems();
        String selectedHotel = (String) hotelDropdown.getSelectedItem();
        Hotel hotel = hotelSystem.getHotelByName(selectedHotel);
        if (hotel != null) {
            for (Room room : hotel.getRooms()) {
                roomDropdown.addItem(room.getName());
            }
        }
    }

    private void reserveRoom() {
        String selectedHotel = (String) hotelDropdown.getSelectedItem();
        String selectedRoom = (String) roomDropdown.getSelectedItem();
        String guestName = guestNameField.getText();
        int checkIn = Integer.parseInt(checkInField.getText());
        int checkOut = Integer.parseInt(checkOutField.getText());
        String discountCode = (String) discountDropdown.getSelectedItem();

        boolean success = hotelSystem.reserveRoom(selectedHotel, selectedRoom, guestName, checkIn, checkOut, discountCode);
        if (success) {
            displayMessage("Reservation successful for " + guestName + " in " + selectedRoom);
        } else {
            displayMessage("Reservation failed for " + guestName);
        }
    }

    private void createHotel() {
        String hotelName = JOptionPane.showInputDialog(this, "Enter hotel name:");
        if (hotelName != null && !hotelName.trim().isEmpty()) {
            hotelSystem.createHotel(hotelName);
            populateHotelDropdown();
            displayMessage("Hotel " + hotelName + " created.");
        } else {
            displayMessage("Hotel creation cancelled or invalid name.");
        }
    }

    private void addRoom() {
        String selectedHotel = (String) hotelDropdown.getSelectedItem();
        if (selectedHotel == null || selectedHotel.trim().isEmpty()) {
            displayMessage("Please select a hotel first.");
            return;
        }

        String[] roomTypes = {"Standard", "Deluxe", "Executive"};
        String roomType = (String) JOptionPane.showInputDialog(this, "Select room type:", "Add Room",
                JOptionPane.QUESTION_MESSAGE, null, roomTypes, roomTypes[0]);
        if (roomType != null && !roomType.trim().isEmpty()) {
            hotelSystem.addRoomToHotel(selectedHotel, roomType);
            updateRoomDropdown();
            displayMessage(roomType + " room added to " + selectedHotel);
        } else {
            displayMessage("Room addition cancelled or invalid type.");
        }
    }

    private void removeRoom() {
        String selectedHotel = (String) hotelDropdown.getSelectedItem();
        if (selectedHotel == null || selectedHotel.trim().isEmpty()) {
            displayMessage("Please select a hotel first.");
            return;
        }

        String roomName = (String) roomDropdown.getSelectedItem();
        if (roomName == null || roomName.trim().isEmpty()) {
            displayMessage("Please select a room to remove.");
            return;
        }

        boolean success = hotelSystem.removeRoomFromHotel(selectedHotel, roomName);
        if (success) {
            updateRoomDropdown();
            displayMessage("Room " + roomName + " removed from " + selectedHotel);
        } else {
            displayMessage("Failed to remove room " + roomName);
        }
    }

    private void setModifier() {
        String selectedHotel = (String) hotelDropdown.getSelectedItem();
        if (selectedHotel == null || selectedHotel.trim().isEmpty()) {
            displayMessage("Please select a hotel first.");
            return;
        }

        String dayStr = JOptionPane.showInputDialog(this, "Enter day (1-31):");
        if (dayStr != null && !dayStr.trim().isEmpty()) {
            try {
                int day = Integer.parseInt(dayStr);
                String modifierStr = JOptionPane.showInputDialog(this, "Enter modifier (0.5 - 1.5):");
                if (modifierStr != null && !modifierStr.trim().isEmpty()) {
                    double modifier = Double.parseDouble(modifierStr);
                    hotelSystem.setModifier(selectedHotel, day, modifier);
                    displayMessage("Date modifier set for " + selectedHotel + " on day " + day);
                } else {
                    displayMessage("Invalid modifier value.");
                }
            } catch (NumberFormatException ex) {
                displayMessage("Invalid day or modifier format.");
            }
        } else {
            displayMessage("Modifier setting cancelled.");
        }
    }

    private void viewGuests() {
        String selectedHotel = (String) hotelDropdown.getSelectedItem();
        String selectedRoom = (String) roomDropdown.getSelectedItem();
        if (selectedHotel == null || selectedRoom == null || selectedHotel.trim().isEmpty() || selectedRoom.trim().isEmpty()) {
            displayMessage("Please select a hotel and room first.");
            return;
        }

        Hotel hotel = hotelSystem.getHotelByName(selectedHotel);
        if (hotel != null) {
            Room room = hotel.getRoomByName(selectedRoom);
            if (room != null) {
                List<Guest> guests = room.getGuests();
                if (guests.isEmpty()) {
                    displayMessage("No guests found in " + selectedRoom + " of " + selectedHotel);
                } else {
                    displayMessage("Guests in " + selectedRoom + " of " + selectedHotel + ":");
                    for (Guest guest : guests) {
                        displayMessage(guest.getName());
                    }
                }
            }
        }
    }

    private void cancelReservation() {
        String selectedHotel = (String) hotelDropdown.getSelectedItem();
        if (selectedHotel == null || selectedHotel.trim().isEmpty()) {
            displayMessage("Please select a hotel first.");
            return;
        }

        String guestName = JOptionPane.showInputDialog(this, "Enter guest name to cancel reservation:");
        if (guestName != null && !guestName.trim().isEmpty()) {
            boolean success = hotelSystem.cancelReservation(selectedHotel, guestName);
            if (success) {
                displayMessage("Reservation cancelled for " + guestName);
            } else {
                displayMessage("No reservation found for " + guestName);
            }
        } else {
            displayMessage("Cancellation cancelled or invalid guest name.");
        }
    }

    private void viewGuestInfo() {
        String selectedHotel = (String) hotelDropdown.getSelectedItem();
        String guestName = guestNameField.getText();
        if (selectedHotel == null || guestName.trim().isEmpty()) {
            displayMessage("Please select a hotel and enter guest name.");
            return;
        }

        Hotel hotel = hotelSystem.getHotelByName(selectedHotel);
        if (hotel != null) {
            for (Room room : hotel.getRooms()) {
                Guest guest = room.getGuestByName(guestName); // Ensure getGuestByName exists in Room
                if (guest != null) {
                    displayMessage("Guest Info for " + guestName + ":");
                    displayMessage("Check-In: " + guest.getCheckIn());
                    displayMessage("Check-Out: " + guest.getCheckOut());
                    displayMessage("Total Price: " + guest.getTotalPrice());
                    return;
                }
            }
            displayMessage("Guest " + guestName + " not found in " + selectedHotel);
        }
    }

    private ImageIcon loadResizedImageIcon(String path, int width, int height) {
        try {
            URL imageURL = getClass().getClassLoader().getResource(path);
            if (imageURL != null) {
                ImageIcon originalIcon = new ImageIcon(imageURL);
                Image originalImage = originalIcon.getImage();
                Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                return new ImageIcon(resizedImage);
            } else {
                throw new Exception("Image not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ImageIcon();
        }
    }

    public void displayMessage(String message) {
        outputArea.append(message + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HotelManagementView view = new HotelManagementView();
            view.setVisible(true);
        });
    }
}
