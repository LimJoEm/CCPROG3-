public class HotelManagementController {
    private HotelSystem hotelSystem;
    private HotelManagementView view;

    public HotelManagementController(HotelSystem hotelSystem, HotelManagementView view) {
        this.hotelSystem = hotelSystem;
        this.view = view;

        // Load initial data
        loadHotels();

        // Add action listeners
        view.getHotelDropdown().addActionListener(e -> loadRooms());
        view.getReserveButton().addActionListener(e -> reserveRoom());
    }

    private void loadHotels() {
        for (Hotel hotel : hotelSystem.getHotels()) {
            view.getHotelDropdown().addItem(hotel.getName());
        }
    }

    private void loadRooms() {
        String selectedHotelName = (String) view.getHotelDropdown().getSelectedItem();
        Hotel selectedHotel = hotelSystem.getHotelByName(selectedHotelName);
        view.getRoomDropdown().removeAllItems();
        if (selectedHotel != null) {
            for (Room room : selectedHotel.getRooms()) {
                view.getRoomDropdown().addItem(room.getName());
            }
        }
    }

    private void reserveRoom() {
        String hotelName = (String) view.getHotelDropdown().getSelectedItem();
        String roomName = (String) view.getRoomDropdown().getSelectedItem();
        String guestName = view.getGuestNameField().getText();
        int checkIn = Integer.parseInt(view.getCheckInField().getText());
        int checkOut = Integer.parseInt(view.getCheckOutField().getText());
        String discountCode = (String) view.getDiscountDropdown().getSelectedItem();

        boolean success = hotelSystem.reserveRoom(hotelName, roomName, guestName, checkIn, checkOut, discountCode);
        if (success) {
            view.displayMessage("Room reserved successfully.");
        } else {
            view.displayMessage("Failed to reserve room.");
        }
    }
}
