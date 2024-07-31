public class Date{
    final int year;
    final int month;
    final int day;

    public Date(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }

    public int getYear(){
        return this.year;
    }
    
    public int getMonth(){
        return this.month;
    }

    public int getDay(){
        return this.day;
    }

    public String getFormattedDate(){
        return String.valueOf(day) + String.valueOf(month) + String.valueOf(year);
    }

}