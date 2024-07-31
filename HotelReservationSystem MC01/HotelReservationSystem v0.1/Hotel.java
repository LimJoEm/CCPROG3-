import java.util.ArrayList;

public class Hotel{
    private String hotelName;
    private ArrayList<Room> rooms;

    /*Hotel can be created with just a name provided, or an ArrayList of Rooms 
    (the arraylist will only transfer up to 50 rooms)*/
    public Hotel(String hotelName){
        this.hotelName=hotelName;
        this.rooms = new ArrayList<Room>();

        Room room = new Room("100");
        
        this.rooms.add(room);
    }

    public Hotel(String HotelName, ArrayList<Room> Rooms){
        this.hotelName=HotelName;
        
        
        
    }

    public String getHotelName(){
        return this.hotelName;
    }

    public int getNumOfRooms(){
        return this.rooms.size();
    }

    public void setHotelName(String newHotelName){
        System.out.println("Succesfully changed hotel \"" + hotelName + "\" to \"" + newHotelName + "\"");
        this.hotelName=newHotelName;
    }

    public void setBasePrice(double newPrice){//not correct yet
        for(Room r : rooms){
            r.setPrice(newPrice);
        }
    }

    public boolean addRoom(Room newRoom){
        if(rooms.size()<51){
            for(Room r : rooms){
                if(r.getName().equals(newRoom.getName())){
                    return false;
                }
            }
            rooms.add(newRoom);
            return true;
        }

        return false;
    }


    // public boolean removeRoom(String roomName){
    //     for(Room r : rooms){
    //         if(r.getName().equals(roomName)){
    //             rooms.remove(r);
    //             return true;
    //         }
    //     }

    //     return false;
    // } //still thinking if we should have this feature

    public void setDefaultPrice(double newPrice){
        for(Room r : rooms){
            r.setPrice(newPrice);
        }
    }


    public boolean isRoomReserved(String roomName, Date date){
        for(Room r : rooms ){
            if(r.getName().equals(roomName) && r.reserveStatus(date.getFormattedDate())){
                return true;
            }
        }
        
        return false;
    }

    public boolean reserveRoom(String roomName, Date date){
        for(Room r : rooms){
            if(r.getName().equals(roomName) && !(r.reserveStatus(date.getFormattedDate()))){
                r.reserve(date);
                return true;
            }
        }
        return false;
    }

    
}