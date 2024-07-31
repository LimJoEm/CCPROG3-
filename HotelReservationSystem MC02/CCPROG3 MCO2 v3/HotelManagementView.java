import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementView extends JFrame {
    private JComboBox<String> hotelDropdown;
    private JComboBox<String> roomDropdown;
    private JComboBox<String> discountDropdown;
    private JTextField guestNameField;
    private JTextField checkInField;
    private JTextField checkOutField;
    private JButton reserveButton;
    private JTextArea outputArea;

    public HotelManagementView() {
        setTitle("Hotel Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Hotel selection
        hotelDropdown = new JComboBox<>();
        roomDropdown = new JComboBox<>();
        discountDropdown = new JComboBox<>(new String[] { "None", "I_WORK_HERE", "STAY4_GET1", "PAYDAY" });

        guestNameField = new JTextField(15);
        checkInField = new JTextField(5);
        checkOutField = new JTextField(5);
        reserveButton = new JButton("Reserve Room");
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        panel.add(new JLabel("Select Hotel:"));
        panel.add(hotelDropdown);
        panel.add(new JLabel("Select Room:"));
        panel.add(roomDropdown);
        panel.add(new JLabel("Guest Name:"));
        panel.add(guestNameField);
        panel.add(new JLabel("Check-In Date:"));
        panel.add(checkInField);
        panel.add(new JLabel("Check-Out Date:"));
        panel.add(checkOutField);
        panel.add(new JLabel("Discount Code:"));
        panel.add(discountDropdown);
        panel.add(reserveButton);
        panel.add(new JScrollPane(outputArea));

        add(panel);
    }

    // Getters for components to be accessed by the controller
    public JComboBox<String> getHotelDropdown() {
        return hotelDropdown;
    }

    public JComboBox<String> getRoomDropdown() {
        return roomDropdown;
    }

    public JComboBox<String> getDiscountDropdown() {
        return discountDropdown;
    }

    public JTextField getGuestNameField() {
        return guestNameField;
    }

    public JTextField getCheckInField() {
        return checkInField;
    }

    public JTextField getCheckOutField() {
        return checkOutField;
    }

    public JButton getReserveButton() {
        return reserveButton;
    }

    public JTextArea getOutputArea() {
        return outputArea;
    }

    public void displayMessage(String message) {
        outputArea.append(message + "\n");
    }
}
