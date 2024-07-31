import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Room> rooms;
    private double basePrice;
    private double[] modifiers;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.basePrice = 1299.0;
        this.modifiers = new double[31];

        for (int i = 0; i < 31; i++) {
            modifiers[i] = 1.0;// default
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public boolean addRoom(String type) {
        if (rooms.size() >= 50) {
            return false;
        }

        Room room;
        String roomName = "Room" + (rooms.size() + 1);

        switch (type.toLowerCase()) {
            case "standard":
                room = new StandardRoom(roomName, basePrice);
                break;

            case "deluxe":
                room = new DeluxeRoom(roomName, basePrice);
                break;

            case "executive":
                room = new ExecutiveRoom(roomName, basePrice);
                break;

            default:
                return false;
        }

        rooms.add(room);
        return true;
    }

    public boolean removeRoom(String roomName) {
        for (Room room : rooms) {
            if (room.getName().equals(roomName) && room.getGuests().isEmpty()) {
                rooms.remove(room);
                return true;
            }
        }
        return false;
    }

    public boolean reserveRoom(String roomName, String guestName, int checkIn, int checkOut, String discountCode) {
        Room room = getRoomByName(roomName);
        if (room == null || !room.isAvailable(checkIn, checkOut)) {
            return false;
        }

        double priceModifier = 0.0;// will probably need to modify
        for (int i = checkIn; i < checkOut; i++) {
            priceModifier += modifiers[i];// thinking of removing this entirely and just using the modifier on the date
                                          // of checkIn
        }

        double finalPrice = room.getBasePrice() * priceModifier;

        if (discountCode != null) {
            switch (discountCode) {
                case "I_WORK_HERE":
                    finalPrice *= 0.90;
                    break;
                case "STAY4_GET1":
                    if (checkOut - checkIn >= 5) {
                        finalPrice -= room.getBasePrice();
                    }
                    break;
                case "PAYDAY":
                    if (checkIn <= 15 && checkOut > 15 || checkIn <= 30 && checkOut > 30) {
                        finalPrice *= 0.93;
                    }
                    break;
                default:
                    System.out.println("Invalid discount code");
                    return false;
            }
        }

        room.reserveRoom(guestName, checkIn, checkOut, finalPrice);
        System.out.println(
                "Reservation made for" + guestName + " in " + roomName + " from " + checkIn + " to " + checkOut);
        return true;
    }

    public boolean cancelReservation(String guestName) {
        for (Room room : rooms) {
            if (room.cancelReservation(guestName)) {
                System.out.println("Reservation cancelled for" + guestName);
                return true;
            }
        }
        return false;
    }

    public void setModifier(int day, double modifier) {
        if (day < 1 || day > 31 || modifier < 0.5 || modifier > 1.5) {
            throw new IllegalArgumentException("Invalid day or modifier");
        }
        modifiers[day - 1] = modifier;
    }

    private Room getRoomByName(String roomName) {
        for (Room room : rooms) {
            if (room.getName().equals(roomName)) {
                return room;
            }
        }
        return null;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Room room : rooms) {
            total += room.getRoomProfits();
        }
        return total;
    }

    public void printHotelInfo() {
        System.out.println("Hotel Name: " + name);
        System.out.println("Base Price: " + basePrice);
        System.out.println("Total Profits: " + getTotalProfits());
        System.out.println("Rooms: ");
        for (Room room : rooms) {
            System.out.println(room.getRoomInfo());
        }
    }

    public double getTotalProfits() {
        double total = 0;
        for (Room room : rooms) {
            total += room.getRoomProfits();
        }
        return total;
    }
}