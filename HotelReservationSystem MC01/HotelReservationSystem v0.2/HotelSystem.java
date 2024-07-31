import java.util.ArrayList;

public class HotelSystem {
    private ArrayList<Hotel> hotels;

    public HotelSystem() {
        this.hotels = new ArrayList<>();
    }

    public boolean createHotel(String hotelName) {
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(hotelName)) {
                System.out.println("Hotel " + hotelName + " already exists.");
                return false;
            }
        }
        hotels.add(new Hotel(hotelName));
        System.out.println("Hotel " + hotelName + " created.");
        return true;
    }

    public boolean createHotel(String hotelName, ArrayList<Room> rooms) {
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(hotelName)) {
                System.out.println("Hotel " + hotelName + " already exists.");
                return false;
            }
        }
        hotels.add(new Hotel(hotelName, rooms));
        System.out.println("Hotel " + hotelName + " created with specified rooms.");
        return true;
    }

    public void viewHotel(String hotelName) {
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(hotelName)) {
                System.out.println(hotel.getHighLevelInfo());
                return;
            }
        }
        System.out.println("Hotel " + hotelName + " not found.");
    }

    public void manageHotel(String hotelName) {//do this luis
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(hotelName)) {
                // Add management functionalities here, e.g., changing name, adding/removing rooms
                return;
            }
        }
        System.out.println("Hotel " + hotelName + " not found.");
    }

    public void simulateBooking(String hotelName, String guestName, String roomName, int checkIn, int checkOut) {//need to display which dates
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(hotelName)) {
                if (hotel.addReservation(guestName, roomName, checkIn, checkOut)) {
                    System.out.println("Booking successful for guest " + guestName);
                } else {
                    System.out.println("Booking failed for guest " + guestName);
                }
                return;
            }
        }
        System.out.println("Hotel " + hotelName + " not found.");
    }

    public void addRoom(String hotelName, Room newRoom) {
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(hotelName)) {
                if (hotel.addRoom(newRoom)) {
                    System.out.println("Room " + newRoom.getRoomName() + " added to hotel " + hotelName);
                } else {
                    System.out.println("Failed to add room " + newRoom.getRoomName() + " to hotel " + hotelName);
                }
                return;
            }
        }
        System.out.println("Hotel " + hotelName + " not found.");
    }

    public void removeRoom(String hotelName, String roomName) {
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(hotelName)) {
                if (hotel.removeRoom(roomName)) {
                    System.out.println("Room " + roomName + " removed from hotel " + hotelName);
                } else {
                    System.out.println("Failed to remove room " + roomName + " from hotel " + hotelName);
                }
                return;
            }
        }
        System.out.println("Hotel " + hotelName + " not found.");
    }
}
