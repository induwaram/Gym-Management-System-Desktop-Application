package sample;

public class Date {
    private int day;
    private int month;
    private int year;
    MyGymManager myGymManager = new MyGymManager();



    public int getDay() {
        return day;
    }

    public void setDay(int day) {

            if (day<31){
                this.day = day;
            }else {
                 System.out.println("Enter a valid date");
                 myGymManager.addMember();

        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {

            if (month < 13) {
                this.month = month;

            } else {
                throw new IllegalArgumentException("Enter a valid Month");
            }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //setting the constructor
    public Date(int day, int month, int year) {
        super();
        setDay(day);
        setMonth(month);
        this.year = year;
    }
}
