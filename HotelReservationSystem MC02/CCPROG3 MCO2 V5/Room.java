import java.util.ArrayList;

public class Room {
    protected String name;
    protected double basePrice;
    protected int[] reservedDates;
    protected ArrayList<Guest> guests;

    public Room(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice >= 100 ? basePrice : 1299.0;
        this.reservedDates = new int[31];
        this.guests = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public boolean isAvailable(int checkIn, int checkOut) {
        for (int i = checkIn; i < checkOut; i++) {
            if (reservedDates[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public double getRoomProfits() {
        double total = 0;

        for (Guest guest : guests) {
            total += guest.getTotalPrice();
        }

        return total;
    }

    public boolean reserveRoom(String guestName, int checkIn, int checkOut, double finalPrice) {
        if (isAvailable(checkIn, checkOut)) {
            for (int i = checkIn; i < checkOut; i++) {
                reservedDates[i] = 1;
            }
            guests.add(new Guest(guestName, checkIn, checkOut, finalPrice));
            return true;
        }
        System.out.println("Room is unavailable for the specified dates");
        return false;
    }

    public boolean cancelReservation(String guestName) {
        Guest toRemove = null;
        for (Guest guest : guests) {
            if (guest.getName().equals(guestName)) {
                for (int i = guest.getCheckIn(); i < guest.getCheckOut(); i++) {
                    reservedDates[i] = 0;
                }
                toRemove = guest;
                break;
            }
        }
        if (toRemove != null) {
            guests.remove(toRemove);
            return true;
        }
        System.out.println("No reservation found for guest : " + guestName);
        return false;
    }

    public ArrayList<Guest> getGuests() {
        return this.guests;
    }

    public String getGuestInfo(String guestName) {
        for (Guest guest : guests) {
            if (guest.getName().equals(guestName)) {
                return "Guest: " + guest.getCheckIn() +
                        "\nCheck-In:" + guest.getCheckIn() +
                        "\nCheck-Out: " + guest.getCheckOut() +
                        "\nTotal  Price:" + guest.getTotalPrice();
            }
        }
        return "Guest Not Found";
    }

    public String getRoomInfo() {
        return "Room: " + name + ", Base Price: " + basePrice;
    }

    public Guest getGuestByName(String guestName) {
        for (Guest guest : guests) {
            if (guest.getName().equalsIgnoreCase(guestName)) {
                return guest;
            }
        }
        return null;
    }

}