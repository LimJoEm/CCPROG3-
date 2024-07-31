import java.util.Scanner;

public class HotelDriver {
    private static final Scanner scanner = new Scanner(System.in);
    private static final HotelSystem hotelSystem = new HotelSystem();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMainMenu();
            int option = getUserInput();
            exit = handleMenuOption(option);
        }
        System.out.println("Exiting Hotel Management System. Goodbye!");
    }

    private static void printMainMenu() {
        System.out.println("\nHotel Management System");
        System.out.println("1. Create Hotel");
        System.out.println("2. Add Room to Hotel");
        System.out.println("3. Remove Room from Hotel");
        System.out.println("4. Reserve Room");
        System.out.println("5. Cancel Reservation");
        System.out.println("6. Set Date Modifier");
        System.out.println("7. View Hotel Information");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return option;
    }

    private static boolean handleMenuOption(int option) {
        switch (option) {
            case 1:
                createHotel();
                break;
            case 2:
                addRoomToHotel();
                break;
            case 3:
                removeRoomFromHotel();
                break;
            case 4:
                reserveRoom();
                break;
            case 5:
                cancelReservation();
                break;
            case 6:
                setDateModifier();
                break;
            case 7:
                viewHotelInfo();
                break;
            case 8:
                return true;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
        return false;
    }

    private static void createHotel() {
        System.out.print("Enter hotel name: ");
        String hotelName = scanner.nextLine();
        hotelSystem.createHotel(hotelName);
    }

    private static void addRoomToHotel() {
        System.out.print("Enter hotel name: ");
        String hotelName = scanner.nextLine();
        System.out.print("Enter room type (Standard/Deluxe/Executive): ");
        String roomType = scanner.nextLine();
        hotelSystem.addRoomToHotel(hotelName, roomType);
    }

    private static void removeRoomFromHotel() {
        System.out.print("Enter hotel name: ");
        String hotelName = scanner.nextLine();
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine();
        hotelSystem.removeRoomFromHotel(hotelName, roomName);
    }

    private static void reserveRoom() {
        System.out.print("Enter hotel name: ");
        String hotelName = scanner.nextLine();
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine();
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter check-in date (1-31): ");
        int checkIn = getUserInput();
        System.out.print("Enter check-out date (1-31): ");
        int checkOut = getUserInput();
        System.out.print("Enter discount code (or leave empty): ");
        String discountCode = scanner.nextLine();
        if (discountCode.trim().isEmpty())
            discountCode = null;
        hotelSystem.reserveRoom(hotelName, roomName, guestName, checkIn, checkOut, discountCode);
    }

    private static void cancelReservation() {
        System.out.print("Enter hotel name: ");
        String hotelName = scanner.nextLine();
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();
        hotelSystem.cancelReservation(hotelName, guestName);
    }

    private static void setDateModifier() {
        System.out.print("Enter hotel name: ");
        String hotelName = scanner.nextLine();
        System.out.print("Enter date (1-31): ");
        int day = getUserInput();
        System.out.print("Enter modifier (0.5 - 1.5): ");
        double modifier = scanner.nextDouble();
        hotelSystem.setModifier(hotelName, day, modifier);
    }

    private static void viewHotelInfo() {
        System.out.print("Enter hotel name: ");
        String hotelName = scanner.nextLine();
        hotelSystem.printHotelInfo(hotelName);
    }
}
