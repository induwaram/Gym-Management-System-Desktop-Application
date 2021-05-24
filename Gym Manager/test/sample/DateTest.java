package sample;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    int memno=0;
    String name="" ;
    int weight=0;
    int height=0;
    String place="";
    int day=0;
    int month=0;
    int year=0;
    String type= "";
    Date date = new Date(day,month,year);

    @org.junit.jupiter.api.Test
    void validationofMonth() {
        DefaultMember dmember= new DefaultMember(memno,name,date,weight,height,place,type);


    }
}