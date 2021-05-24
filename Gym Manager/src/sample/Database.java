package sample;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.ArrayList;

public class Database {

    //connecting the conection
    public static DB startconnection() {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB database = mongoClient.getDB("local");
            return database;
        } catch (UnknownHostException e) {

            e.printStackTrace();
        }
        return null;
    }

    //Setting the template for the database
    public static DBObject defaultMember(DefaultMember user) {
        BasicDBObjectBuilder documentbuilder = BasicDBObjectBuilder.start();

        documentbuilder.append("_id", user.getMembershipNumber());
        documentbuilder.append("memberType", "Default Member");
        documentbuilder.append("name", user.getName());
        documentbuilder.append("membershipStartyear", user.getStartDate().getYear());
        documentbuilder.append("membershipStartmonth", user.getStartDate().getMonth());
        documentbuilder.append("membershipStartday", user.getStartDate().getDay());
        documentbuilder.append("height", user.getHeight());
        documentbuilder.append("weight", user.getWeight());
        documentbuilder.append("Town", user.getPlace());
        return documentbuilder.get();
    }

    public static DBObject studentMember(StudentMember user) {
        BasicDBObjectBuilder documentbuilder = BasicDBObjectBuilder.start();

        documentbuilder.append("_id", user.getMembershipNumber());
        documentbuilder.append("memberType", "StudentMember");
        documentbuilder.append("name", user.getName());
        documentbuilder.append("membershipStartyear", user.getStartDate().getYear());
        documentbuilder.append("membershipStartmonth", user.getStartDate().getMonth());
        documentbuilder.append("membershipStartday", user.getStartDate().getDay());
        documentbuilder.append("height", user.getHeight());
        documentbuilder.append("weight", user.getWeight());
        documentbuilder.append("Town", user.getPlace());
        documentbuilder.append("school", user.getSchool());
        documentbuilder.append("parentName", user.getParent());
        documentbuilder.append("sports", user.getSports());
        return documentbuilder.get();
    }

    public static DBObject over60Member(Over60Member user) {
        BasicDBObjectBuilder documentbuilder = BasicDBObjectBuilder.start();

        documentbuilder.append("_id", user.getMembershipNumber());
        documentbuilder.append("memberType", "Over 60 Member");
        documentbuilder.append("name", user.getName());
        documentbuilder.append("membershipStartyear", user.getStartDate().getYear());
        documentbuilder.append("membershipStartmonth", user.getStartDate().getMonth());
        documentbuilder.append("membershipStartday", user.getStartDate().getDay());
        documentbuilder.append("height", user.getHeight());
        documentbuilder.append("weight", user.getWeight());
        documentbuilder.append("Town", user.getPlace());
        documentbuilder.append("age", user.getAge());
        documentbuilder.append("medicalCondition", user.getMedical());
        documentbuilder.append("EmergencyContact", user.getEmergency());
        return documentbuilder.get();
    }


    //Creating the collection by user inputs
    public static DBCollection setupdefault(int membershipNo, String name, Date membershipStartDate, int weight, int height, String place) {
        DefaultMember defaultMember = new DefaultMember(membershipNo, name, membershipStartDate, weight, height, place,"Default Member");
        DBObject document = defaultMember(defaultMember);
        DB database = startconnection();
        DBCollection collection = database.getCollection("Gym Management Database");
        collection.insert(document);
        return collection;
    }

    public static DBCollection setupstudent(int membershipNo, String name, Date membershipStartDate, int weight, int height, String place, String school, int parent, String sports) {
        StudentMember studentMember = new StudentMember(membershipNo, name, membershipStartDate,"Default Member", weight, height, place, school, parent, sports);
        DBObject document = studentMember(studentMember);
        DB database = startconnection();
        DBCollection collection = database.getCollection("Gym Management Database");
        collection.insert(document);
        return collection;
    }

    public static DBCollection setupover60member(int membershipNo, String name, Date membershipStartDate, int weight, int height, String place, int age, String medical, int emergency) {
        Over60Member over60Member = new Over60Member(membershipNo, name, membershipStartDate,"Default Member", weight, height, place, age, medical, emergency);
        DBObject document = over60Member(over60Member);
        DB db = startconnection();
        DBCollection collection = db.getCollection("Gym Management Database");
        collection.insert(document);
        return collection;
    }

    //Getting the total count of the inputs
    public static int slotscount() {
        DB db = startconnection();
        DBCollection collection = db.getCollection("Gym Management Database");
        int count = (int) collection.count();
        return count;
    }

    //Sorting the list by ID
    public static void sortingListByID(String object, int number) {
        DB database = Database.startconnection();
        DBCollection collection = database.getCollection("Gym Management Database");
        DBCursor csr1=collection.find().sort(new BasicDBObject(object, number));
        DBCursor csr2=collection.find().sort(new BasicDBObject(object, number));
        DBCursor csr3=collection.find().sort(new BasicDBObject(object, number));
        DBCursor csr4=collection.find().sort(new BasicDBObject(object, number));
        DBCursor csr5=collection.find().sort(new BasicDBObject(object, number));
        DBCursor csr6=collection.find().sort(new BasicDBObject(object, number));
        DBCursor csr7=collection.find().sort(new BasicDBObject(object, number));
//        DBCursor csr8=collection.find().sort(new BasicDBObject(object, number));
//        DBCursor csr9=collection.find().sort(new BasicDBObject(object, number));
//        DBCursor csr10=collection.find().sort(new BasicDBObject(object, number));
//        DBCursor csr11=collection.find().sort(new BasicDBObject(object, number));
//        DBCursor csr12=collection.find().sort(new BasicDBObject(object, number));
//        DBCursor csr13=collection.find().sort(new BasicDBObject(object, number));
        DBCursor csr14=collection.find().sort(new BasicDBObject(object, number));;;
        DBCursor csr15=collection.find().sort(new BasicDBObject(object, number));

        System.out.println("                                             Sorted  Member's List By Membership Number");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-15s %-20s %-25s %-25s %-10s %-10s %n","Membership No","Membership Type","Membership Start Date","Member's Name","Weight","Height","Town","School","Parents Contact","Sports","Age","Medical Issues","Emergency Contact");
        while (csr1.hasNext() && csr2.hasNext()) {
            Object membershipNo = csr1.next().get("_id");
            Object type = csr2.next().get("memberType");
            Object name = csr3.next().get("name");
            Object day = csr4.next().get("membershipStartday");
            Object month = csr15.next().get("membershipStartmonth");
            Object year = csr14.next().get("membershipStartyear");
            Object weight = csr5.next().get("weight");
            Object height = csr6.next().get("height");
            Object town = csr7.next().get("Town");
//               Object school = csr8.next().get("school");
//               Object parents = csr9.next().get("parentName");
//               Object sports = csr10.next().get("sports");
//               Object age = csr11.next().get("age");
//               Object medical = csr12.next().get("medicalCondition");
//               Object emergency = csr13.next().get("EmergencyContact");
            String date = day.toString()+"/"+month.toString()+"/"+year.toString();
            System.out.format("%-15s %-20s %-25s %-25s %-10s %-10s %n",membershipNo.toString(),type.toString(),date,name.toString(),weight.toString(),height.toString(),town.toString()/*school.toString(),parents.toString(),sports.toString(),age.toString(),medical.toString(),emergency.toString()*/);

        }
    }

    //sorting the list by Name
    public static void sortingListByName(String object, int number) {
        DB database = Database.startconnection();
        DBCollection collection = database.getCollection("Gym Management Database");
        DBCursor csr1=collection.find().sort(new BasicDBObject(object, number));
        DBCursor csr2=collection.find().sort(new BasicDBObject(object, number));
        DBCursor csr3=collection.find().sort(new BasicDBObject(object, number));
        DBCursor csr4=collection.find().sort(new BasicDBObject(object, number));
        DBCursor csr5=collection.find().sort(new BasicDBObject(object, number));
        DBCursor csr6=collection.find().sort(new BasicDBObject(object, number));
        DBCursor csr7=collection.find().sort(new BasicDBObject(object, number));
//        DBCursor csr8=collection.find().sort(new BasicDBObject(object, number));
//        DBCursor csr9=collection.find().sort(new BasicDBObject(object, number));
//        DBCursor csr10=collection.find().sort(new BasicDBObject(object, number));
//        DBCursor csr11=collection.find().sort(new BasicDBObject(object, number));
//        DBCursor csr12=collection.find().sort(new BasicDBObject(object, number));
//        DBCursor csr13=collection.find().sort(new BasicDBObject(object, number));
        DBCursor csr14=collection.find().sort(new BasicDBObject(object, number));;;
        DBCursor csr15=collection.find().sort(new BasicDBObject(object, number));

        System.out.println("                                                   Sorted  Member's List by Name ");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-15s %-20s %-25s %-25s %-10s %-10s %n","Membership No","Membership Type","Membership Start Date","Member's Name","Weight","Height","Town","School","Parents Contact","Sports","Age","Medical Issues","Emergency Contact");
        while (csr1.hasNext() && csr2.hasNext()) {
            Object membershipNo = csr1.next().get("_id");
            Object type = csr2.next().get("memberType");
            Object name = csr3.next().get("name");
            Object day = csr4.next().get("membershipStartday");
            Object month = csr15.next().get("membershipStartmonth");
            Object year = csr14.next().get("membershipStartyear");
            Object weight = csr5.next().get("weight");
            Object height = csr6.next().get("height");
            Object town = csr7.next().get("Town");
//               Object school = csr8.next().get("school");
//               Object parents = csr9.next().get("parentName");
//               Object sports = csr10.next().get("sports");
//               Object age = csr11.next().get("age");
//               Object medical = csr12.next().get("medicalCondition");
//               Object emergency = csr13.next().get("EmergencyContact");
            String date = day.toString()+"/"+month.toString()+"/"+year.toString();
            System.out.format("%-15s %-20s %-25s %-25s %-10s %-10s %n",membershipNo.toString(),type.toString(),date,name.toString(),weight.toString(),height.toString(),town.toString()/*school.toString(),parents.toString(),sports.toString(),age.toString(),medical.toString(),emergency.toString()*/);

        }
    }

    //reading the array for the table
    public static ArrayList<String> commonread (String word){
        DB database = Database.startconnection();
        DBCollection collection = database.getCollection("Gym Management Database");
        DBCursor csr =collection.find();
        ArrayList<String> name = new ArrayList<>();
        while (csr.hasNext()){
            name.add(csr.next().get(word).toString());
        }
        return name;
    }



    //reading the array for the table integer
    public static ArrayList<Integer> commonread2 (String word){
        DB database = Database.startconnection();
        DBCollection collection = database.getCollection("Gym Management Database");
        DBCursor csr =collection.find();
        ArrayList<Integer> name = new ArrayList<>();
        while (csr.hasNext()){
            name.add(Integer.parseInt(csr.next().get(word).toString()));

        }
        return name;
    }

    public static DBObject getByName(String name){
        DB database = Database.startconnection();
        DBCollection collection = database.getCollection("Gym Management Database");
        DBObject object = new BasicDBObject("name", name).append("name", new BasicDBObject("$regex", String.valueOf(name)));
        return object;
    }

    public static ArrayList<String> nameResult (DBObject object,String word){
        DB database = Database.startconnection();
        DBCollection collection = database.getCollection("Gym Management Database");
        ArrayList<String> resultsArray = new ArrayList<>();
        DBCursor csr = collection.find(object);
        while (csr.hasNext()){
            String results = csr.next().get(word).toString();
            resultsArray.add(results);
        }
        return resultsArray;
    }
    public static ArrayList<Integer> nameResultforInt(DBObject object,String word){
        DB database = Database.startconnection();
        DBCollection collection = database.getCollection("Gym Management Database");
        ArrayList<Integer> resultsArray = new ArrayList<>();
        DBCursor csr = collection.find(object);
        while (csr.hasNext()){
            resultsArray.add(Integer.parseInt(csr.next().get(word).toString()));
        }
        return resultsArray;
    }
}