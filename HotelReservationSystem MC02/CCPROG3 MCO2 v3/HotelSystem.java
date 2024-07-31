import java.util.ArrayList;

public class HotelSystem {
    private ArrayList<Hotel> hotels;

    public HotelSystem() {
        this.hotels = new ArrayList<>();
    }

    public void createHotel(String name) {
        if (getHotelByName(name) == null) {
            hotels.add(new Hotel(name));
            System.out.println("Hotel " + name + " created.");
        } else {
            System.out.println("Hotel " + name + " already exists.");
        }
    }

    public boolean addRoomToHotel(String hotelName, String roomType) {
        Hotel hotel = getHotelByName(hotelName);

        if (hotel != null) {
            if (hotel.addRoom(roomType)) {
                System.out.println(roomType + " room added to " + hotelName);
                return true;
            } else {
                System.out.println("Cannot add more rooms to " + hotelName);
            }
        } else {
            System.out.println("Hotel " + hotelName + " not found");
        }

        return false;
    }

    public boolean removeRoomFromHotel(String hotelName, String roomName) {
        Hotel hotel = getHotelByName(hotelName);

        if (hotel != null) {
            if (hotel.removeRoom(roomName)) {
                System.out.println("Room " + roomName + "removed from" + hotelName);
                return true;
            } else {
                System.out.println("Cannot remove room" + roomName + " from " + hotelName);
                return false;
            }
        } else {
            System.out.println("Hotel " + hotelName + "not found.");
        }

        return false;
    }

    public boolean reserveRoom(String hotelName, String roomName, String guestName, int checkIn, int checkOut,
            String discountCode) {
        Hotel hotel = getHotelByName(hotelName);
        if (hotel != null) {
            return hotel.reserveRoom(roomName, guestName, checkIn, checkOut, discountCode);
        } else {
            System.out.println("Hotel " + hotelName + "not found");
            return false;
        }
    }

    public boolean cancelReservation(String hotelName, String guestName) {
        Hotel hotel = getHotelByName(hotelName);

        if (hotel != null) {
            return hotel.cancelReservation(guestName);
        } else {
            System.out.println("Hotel " + hotelName + " not found");
            return false;
        }
    }

    public void setModifier(String hotelName, int day, double modifier) {
        Hotel hotel = getHotelByName(hotelName);

        if (hotel != null) {
            hotel.setModifier(day, modifier);
            System.out.println("Date modifier set for" + hotelName + " on day " + day);
        } else {
            System.out.println("Hotel " + hotelName + " not found");
        }
    }

    public void printHotelInfo(String hotelName) {
        Hotel hotel = getHotelByName(hotelName);

        if (hotel != null) {
            hotel.printHotelInfo();
        } else {
            System.out.println("Hotel " + hotelName + "not found.");
        }
    }

    public Hotel getHotelByName(String name) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        return null;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }
}