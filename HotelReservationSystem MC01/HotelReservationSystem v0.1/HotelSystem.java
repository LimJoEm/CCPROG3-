import java.util.ArrayList;

public class HotelSystem{
    private ArrayList<Hotel> hotels;
    
    public HotelSystem(){
        this.hotels= new ArrayList<Hotel>();
    }

    public boolean createNewHotel(String name){

        for(Hotel h : this.hotels){
            if(h.getHotelName().equals(name)){
                System.out.println("Duplicate Hotel Name!");
                return false;
            }
        }

        Hotel hotel = new Hotel(name);

        this.hotels.add(hotel);

        return true;
    }

    public boolean addRoom(String hotelName, int numOfRooms){
        for(Hotel h : hotels){
            if(h.getHotelName().equals(hotelName) && h.getNumOfRooms()<50){
                int count = 0;
                Room room;
                do {
                    String roomName = String.valueOf(100 + h.getNumOfRooms());
                    room = new Room(roomName);
                    count++;
                    numOfRooms--;
                } while (h.addRoom(room) && numOfRooms>0);

                System.out.println(count + "rooms added");
                return true;
            }
            else if(h.getHotelName().equals(hotelName) && h.getNumOfRooms()>=50){
                System.out.println("Cannot add anymore rooms");
                return false;
            }    
        }

        System.out.println("No such hotel as \"" + hotelName + "\" Found");
        return false;
    }

    public void changeHotelName(String hotelName, String newHotelName){
        for(Hotel h: hotels){
            if(h.getHotelName().equals(hotelName)){
                h.setHotelName(newHotelName);
            }
        }
    }



    public boolean viewHotelInfoLow(String hotelName, Date date){
        for(Hotel h : hotels){
            if(h.getHotelName().equals(hotelName)){
//                 i. Total number of available and booked rooms for a selected date
                        // ii. Information about a selected room, such as the room’s name, price per night, and
                        // availability across the entire month
                        // iii. Information about a selected reservation, such as the guest information, room
                        // information, check-in and -out dates, the total price for the booking, and the
                        // breakdown of the price per night
                return true;
            }
        }

        return false;
    }

    public boolean viewHotelInfoHigh(String hotelName, Date date){
        // High-level hotel information should include the name of the hotel, total number of rooms,
        // estimate earnings for the month (i.e. sum of total price across all reservations)
        return false;
    }

    public boolean setHotelBasePrice(String hotelName, Date date){

        return false;
    }

    public boolean removeReservation(){
        return false;
    }
}