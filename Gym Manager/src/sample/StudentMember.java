package sample;

public class StudentMember extends DefaultMember {
    private String school;
    private int parent;
    private String sports;

    //setting the constructor
    public StudentMember(int membershipNo, String name, Date membershipStartDate, String type, int weight, int height, String place, String school, int parent, String sports) {
        super(membershipNo, name, membershipStartDate, weight, height, place,type);
        this.school = school;
        this.parent = parent;
        this.sports = sports;
    }



    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

}
