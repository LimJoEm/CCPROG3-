import java.util.ArrayList;

public class HotelDriver {

    public static void main(String[] args) {
        HotelSystem hotelSystem = new HotelSystem();

        // Creating some rooms for hotels
        Room room1 = new Room("101", 150.0);
        Room room2 = new Room("102", 180.0);
        Room room3 = new Room("103", 200.0);

        // Creating a hotel with predefined rooms
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        hotelSystem.createHotel("Grand Hotel", rooms);

        // Creating another hotel
        hotelSystem.createHotel("Comfort Inn");

        // Simulating bookings
        hotelSystem.simulateBooking("Grand Hotel", "Alice", "101", 1, 5);
        hotelSystem.simulateBooking("Grand Hotel", "Bob", "102", 3, 7);
        hotelSystem.simulateBooking("Comfort Inn", "Charlie", "Standard Room", 2, 4);

        // Viewing hotel information
        hotelSystem.viewHotel("Grand Hotel");

        // Managing hotel (e.g., changing hotel name)
        hotelSystem.manageHotel("Comfort Inn");
        hotelSystem.manageHotel("Unknown Hotel");

        // Adding new rooms to existing hotels
        Room newRoom = new Room("104", 160.0);
        hotelSystem.addRoom("Grand Hotel", newRoom);

        // Removing a room
        hotelSystem.removeRoom("Grand Hotel", "103");

        // Viewing updated hotel information
        hotelSystem.viewHotel("Grand Hotel");
    }
}
