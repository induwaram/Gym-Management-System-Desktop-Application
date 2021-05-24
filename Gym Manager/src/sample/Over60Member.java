package sample;

public class Over60Member extends DefaultMember {
    private int age;
    private String medical;
    private int emergency;


    //setting the constructor
    public Over60Member(int membershipNo, String name, Date membershipStartDate, String type, int weight, int height, String place, int age, String medical, int emergency) {
        super(membershipNo, name, membershipStartDate, weight, height, place,type);
        setAge(age);
        this.medical = medical;
        this.emergency = emergency;
    }


    public int getAge() {
        return age;
    }

    public String getMedical() {
        return medical;
    }

    public int getEmergency() {
        return emergency;
    }

    //validating the age
    public void setAge(int age) {
        if(age>60){
            this.age=age;
        }else {
            System.out.println("\nOnly above 60 Members!");
        }
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public void setEmergency(int emergency) {
        this.emergency = emergency;
    }


}
