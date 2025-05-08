import java.time.Year;

public class ArrivalAndDeparture {
    private int month;
    private int day;
    private int hour;
    private int minute;

    public ArrivalAndDeparture(int month, int day, int hour, int minute) {
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
    public String generateArrDipa(){
        Year year = Year.now();
        return day + "-" + month + "-" + year + "-" + hour + ":" + minute + ":00";
    }

}
