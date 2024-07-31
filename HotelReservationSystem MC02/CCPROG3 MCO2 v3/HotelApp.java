import javax.swing.SwingUtilities;

public class HotelApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // HotelSystem hotelSystem = new HotelSystem();
            HotelManagementView view = new HotelManagementView();
            new HotelManagementController(hotelSystem, view);
            view.setVisible(true);
        });
    }
}
