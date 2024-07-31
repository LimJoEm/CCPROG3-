public class Guest {
    private final String name;
    private final int checkIn;
    private final int checkOut;
    private final double totalPrice;

    public Guest(String name, int checkIn, int checkOut, double pricePerNight) {
        this.name = name;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = (checkOut - checkIn) * pricePerNight;
    }

    public String getName() {
        return name;
    }

    public int getCheckIn() {
        return this.checkIn;
    }

    public int getCheckOut() {
        return this.checkOut;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }
}