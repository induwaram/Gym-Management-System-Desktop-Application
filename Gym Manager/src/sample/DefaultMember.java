package sample;

public class DefaultMember {
    private int membershipNumber;
    private String name;
    private Date startDate;
    private int weight;
    private int height;
    private String place;
    private static int counter;
    private  String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static int getCounter() {

        return counter;
    }

    public static void setCounter(int counter) {
        DefaultMember.counter = counter;
    }

    //setting the constructor
    public DefaultMember(int membershipNumber, String name, Date startDate, int weight, int height, String place, String type) {
        setMembershipNumber(membershipNumber);
        this.name = name;
        this.startDate = startDate;
        this.weight = weight;
        this.height = height;
        this.place = place;
        this.type = type;
    }


    public void setMembershipNumber(int membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getMembershipNumber() {
        return membershipNumber;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getPlace() {
        return place;
    }



}
