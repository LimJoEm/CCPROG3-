public class Date{
    final String date;
    final int year, month, day;

    //does not guard! ensure correct data;
    public Date(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
        this.date=String.valueOf(year + month + day);
    }

    public String getStringDate(){
        return this.date;
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
}