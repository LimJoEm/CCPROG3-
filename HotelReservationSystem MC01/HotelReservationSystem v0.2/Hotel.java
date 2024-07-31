import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private ArrayList<Room> rooms;
    private ArrayList<Guest> reservations;

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public Hotel(String hotelName, ArrayList<Room> rooms) {
        this.hotelName = hotelName;
        this.rooms = new ArrayList<>(rooms.subList(0, Math.min(rooms.size(), 50)));// only adds up to 50 rooms to guard
        this.reservations = new ArrayList<>();
    }

    public String getHotelName() {
        return this.hotelName;
    }

    public int getNumOfRooms() {
        return this.rooms.size();
    }

    public void setHotelName(String newHotelName) {
        System.out.println("Successfully changed hotel \"" + hotelName + "\" to \"" + newHotelName + "\"");
        this.hotelName = newHotelName;
    }

    public boolean setBasePrice(double newPrice) {
        if (reservations.isEmpty()) {
            for (Room r : rooms) {
                r.setBasePrice(newPrice);
            }
            return true;
        } else {
            System.out.println("Cannot update base price as there are active reservations.");
            return false;
        }
    }

    public boolean addRoom(Room newRoom) {
        if (rooms.size() < 50) {
            for (Room r : rooms) {
                if (r.getRoomName().equals(newRoom.getRoomName())) {
                    System.out.println("Room name already exists.");
                    return false;
                }
            }
            rooms.add(newRoom);
            return true;
        }
        System.out.println("Cannot add more rooms, limit reached.");
        return false;
    }

    public boolean removeRoom(String roomName) {
        for (Room r : rooms) {
            if (r.getRoomName().equals(roomName)) {
                if (r.getGuestList().isEmpty()) {
                    rooms.remove(r);
                    System.out.println("Room :" + roomName + " removed.");
                    return true;
                } else {
                    System.out.println("Cannot remove room with active reservations.");
                    return false;
                }
            }
        }
        System.out.println("Room " + roomName + " not found.");
        return false;
    }

    public boolean addReservation(String guestName, String roomName, int checkIn, int checkOut) {
        for (Room r : rooms) {
            if (r.getRoomName().equals(roomName)) {
                if (r.reserveRoom(guestName, checkIn, checkOut)) {
                    reservations.add(new Guest(guestName, checkIn, checkOut, r.getBasePrice()));
                    return true;
                }
                return false;
            }
        }
        System.out.println("Room " + roomName + " not found.");
        return false;
    }

    public boolean removeReservation(String guestName) {
        for (Guest reservation : reservations) {
            if (reservation.getGuestName().equals(guestName)) {
                for (Room room : rooms) {
                    if (room.removeReservation(guestName)) {
                        reservations.remove(reservation);
                        System.out.println("Reservation for " + guestName + " removed.");
                        return true;
                    }
                }
            }
        }
        System.out.println("No reservation found for " + guestName);
        return false;
    }

    public String getHighLevelInfo() {
        double estimatedEarnings = 0;
        for (Room room : rooms) {
            estimatedEarnings += room.getRoomProfits();
        }
        return "Hotel Name: " + hotelName + "\nTotal Number of Rooms: " + rooms.size() + "\nEstimated Earnings: "
                + estimatedEarnings;
    }

    public String getLowLevelInfo(String infoType, String identifier) {//still need to update probs leave it to luis
        switch (infoType) {
            case "room":
                for (Room room : rooms) {
                    if (room.getRoomName().equals(identifier)) {
                        return "Room Name: " + room.getRoomName() + "\nPrice per Night: " + room.getBasePrice()
                                + "\nProfits: " + room.getRoomProfits();
                    }
                }
                break;
            case "reservation":
                for (Guest g : reservations) {
                    if (g.getGuestName().equals(identifier)) {
                        return g.getGuestName();
                    }
                }
                break;
        }
        return "No information found for the given identifier.";
    }
}