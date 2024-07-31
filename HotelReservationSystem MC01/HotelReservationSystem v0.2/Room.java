import java.util.ArrayList;

public class Room {
    private String roomName;
    private double basePrice;
    private int[] reservedDates;
    private ArrayList<Guest> guestList;

    public Room(String roomName, double basePrice) {
        this.roomName = roomName;
        if (basePrice < 100.0) {
            this.basePrice = 1299;
        } else {
            this.basePrice = basePrice;
        }

        this.reservedDates = new int[31];
        for (int i = 0; i < 31; i++) {
            this.reservedDates[i] = 0;
        }
        guestList = new ArrayList<Guest>();
    }

    public void setRoomName(String name) {
        this.roomName = name;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public double getRoomProfits() {
        double count = 0;

        for (Guest g : guestList) {
            count += g.getTotalPrice();
        }

        return count;
    }

    public boolean setBasePrice(double newBasePrice) {// does not guard
        if (newBasePrice >= 100) {
            this.basePrice = newBasePrice;
            return true;
        }
        System.out.println("Invalid base price!");
        return false;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public String getGuestInfo(String guestName) {
        for (Guest g : guestList) {
            if (g.getGuestName().equals(guestName)) {
                return "\nGuest Name    :" + g.getGuestName() +
                        "\nCheck In Date :" + g.getCheckIn() +
                        "\nCheck Out Date:" + g.getCheckOut() +
                        "\nTotal Price   :" + g.getTotalPrice();
            }
        }

        return "No such guest as" + guestName;
    }

    public boolean reserveRoom(String name, int checkIn, int checkOut) {
        if (checkIn < checkOut && checkIn>=1 && checkOut <=31) {

            for (int i = checkIn; i <= checkOut; i++) {
                if (reservedDates[i] != 0) {
                    System.out.println("unable to reserve, room is unavailable on specified dates");
                    return false;
                }
            }

            for (int i = checkIn; i <= checkOut; i++) {
                reservedDates[i] = 1;
            }
            Guest newGuest = new Guest(name, checkIn, checkOut, basePrice);
            guestList.add(newGuest);
            return true;
        }
        System.out.println("Invalid checkIn and checkOut dates");
        return false;
    }

    public boolean removeReservation(String name) {
        for (Guest g : guestList) {
            if (g.getGuestName().equals(name)) {
                for (int i = g.getCheckIn(); i <= g.getCheckOut(); i++) {
                    reservedDates[i] = 0;
                }
                guestList.remove(g);
                return true;
            }
        }

        System.out.println("No such guest as " + name);
        return false;
    }

    public ArrayList<Guest> getGuestList() {
        return this.guestList;
    }

}