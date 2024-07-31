import java.util.ArrayList;


public class Room{
    final  String roomName;
    private double price;
    private ArrayList<Date> reservedDates;

    public Room(String roomName){
        this.roomName=roomName;
        this.price=1299.0;
        reservedDates = new ArrayList<Date>();
    }

    public void setPrice(double price){
        this.price=price;
    }

    public String getName(){
        return this.roomName;
    }

    public double getPrice(){
        return this.price;
    }

    public boolean reserve(Date date){
        for(Date d : this.reservedDates){
            if(d.getFormattedDate().equals(date.getFormattedDate())){
                return false;
            }
        }
        this.reservedDates.add(date);
        return true;
    }

    public boolean reserveStatus(String date){
        for(Date d : this.reservedDates){
            if(d.getFormattedDate().equals(date)){
                return true;
            }
        }
        return false;
    }
}