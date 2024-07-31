public class Guest {
    final String name;
    private int checkIn, checkOut;
    private double totalPrice;

    // does not guard
    public Guest(String name, int checkIn, int checkOut, double basePrice) {
        this.name = name;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = (checkOut - checkIn) * basePrice;
    }

    public String getGuestName() {
        return this.name;
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