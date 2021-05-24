package sample;


import com.mongodb.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MyGymManager implements GymManager {


    @Override
    public void addMember() {
        Scanner sc = new Scanner(System.in);
        int count = Database.slotscount();
        if (count <= 100) {


            try {
                //creating the Console UI
                System.out.println("--------------------------------------------------------------");
                System.out.println("-----------------------Add a new Member-----------------------");
                System.out.println("--------------------------------------------------------------");
                System.out.println("Press 1 : Default Member\n" +
                        "Press 2 : Student Member\n" +
                        "Press 3 : Over 60 Member\n"+
                        "else    : To Go Back\n"
                );
                System.out.print("Enter You Choice : ");

                Scanner sc1 = new Scanner(System.in);
                Scanner sc2 = new Scanner(System.in);
                Scanner sc3 = new Scanner(System.in);
                Scanner sc4 = new Scanner(System.in);
                Scanner sc5 = new Scanner(System.in);
                Scanner sc6 = new Scanner(System.in);
                Scanner sc7 = new Scanner(System.in);
                Scanner sc8 = new Scanner(System.in);
                Scanner sc9 = new Scanner(System.in);
                Scanner sc10 = new Scanner(System.in);
                Scanner sc11 = new Scanner(System.in);

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("\nDefault Member Registration");
                        System.out.println("-------------------------------");

                        System.out.print("Enter the Membership Number : ");
                        int membershipNumber = sc1.nextInt();
                        System.out.print("Enter the Name : ");
                        String name = sc2.nextLine();
                        System.out.print("Enter the Membership Start year : ");
                        int year = sc3.nextInt();
                        System.out.print("Enter the Membership Start Month : ");
                        int month = sc10.nextInt();
                        System.out.print("Enter the Membership Start day : ");
                        int day = sc11.nextInt();
                        Date date = new Date(day, month, year);
                        System.out.print("Enter the Weight : ");
                        int weight = sc4.nextInt();
                        System.out.print("Enter the Height : ");
                        int height = sc5.nextInt();
                        System.out.print("Enter the Place you live : ");
                        String town = sc6.nextLine();

                        try {
                            Database.setupdefault(membershipNumber, name, date, weight, height, town);
                        }catch(Exception e){
                            System.out.println("\nThis member is already added!");
                            break;
                        }
                        count = Database.slotscount();
                        System.out.println("\nData Added Successfully!");
                        System.out.println("Remaining Member slots No : " + (100 - count));
                        break;
                    case 2:
                        System.out.println("\nStudentMember Member Registration");
                        System.out.println("-------------------------------");

                        System.out.print("Enter the Membership Number : ");
                        membershipNumber = sc1.nextInt();
                        System.out.print("Enter the Name : ");
                        name = sc2.nextLine();
                        System.out.print("Enter the Membership Start year : ");
                        year = sc3.nextInt();
                        System.out.print("Enter the Membership Start Month : ");
                        month = sc10.nextInt();
                        System.out.print("Enter the Membership Start day : ");
                        day = sc11.nextInt();
                        date = new Date(day, month, year);
                        System.out.print("Enter the Weight : ");
                        weight = sc4.nextInt();
                        System.out.print("Enter the Height : ");
                        height = sc5.nextInt();
                        System.out.print("Enter the Place you live : ");
                        town = sc6.nextLine();
                        System.out.print("Enter the school : ");
                        String school = sc7.nextLine();
                        System.out.print("Enter your Parents Contact Number: ");
                        int parent = sc8.nextInt();
                        System.out.print("Enter the Sports you play : ");
                        String sport = sc9.nextLine();


                        try {
                            Database.setupstudent(membershipNumber, name, date, weight, height, town, school, parent, sport);
                        }catch(Exception b){
                            System.out.println("\nThis member is already added!");
                            break;
                        }
                        System.out.println("\nData Added Successfully!");
                        count = Database.slotscount();
                        System.out.println("Remaining Member slots No : " + (100 - count));

                        break;
                    case 3:
                        System.out.println("\nOver 60 Member Registration");
                        System.out.println("-------------------------------");

                        System.out.print("Enter the Membership Number : ");
                        membershipNumber = sc1.nextInt();
                        System.out.print("Enter the Name : ");
                        name = sc2.nextLine();
                        System.out.print("Enter the Membership Start year : ");
                        year = sc3.nextInt();
                        System.out.print("Enter the Membership Start Month : ");
                        month = sc10.nextInt();
                        System.out.print("Enter the Membership Start day : ");
                        day = sc11.nextInt();
                        date = new Date(day, month, year);
                        System.out.print("Enter the Weight : ");
                        weight = sc4.nextInt();
                        System.out.print("Enter the Height : ");
                        height = sc5.nextInt();
                        System.out.print("Enter the Place you live : ");
                        town = sc6.nextLine();
                        System.out.print("Enter the Age : ");
                        int age = sc7.nextInt();
                        System.out.print("Enter any medical Conditions: ");
                        String medical = sc8.nextLine();
                        System.out.print("Enter the Emergency Contact Number : ");
                        int emergency = sc9.nextInt();


                        try {
                            Database.setupover60member(membershipNumber, name, date, weight, height, town, age, medical, emergency);
                        }catch(Exception c){
                            System.out.println("\nThis member is already added!");
                            break;
                        }
                        System.out.println("\nData Added Successfully!");
                        count = Database.slotscount();
                        System.out.println("Remaining Member slots No : " + (100 - count));
                        break;

                }

            } catch (InputMismatchException e) {
                System.out.println("\nPlease Enter Valid Information!");

            }


        } else {
            System.out.println("Member Amount Exceeded!");
        }
    }



    @Override
    public void deleteMember() {
        Scanner sc =new Scanner(System.in);
        Scanner sc1 =new Scanner(System.in);
        System.out.println("--------------------------------------------------------------");
        System.out.println("-----------------------Delete a Member------------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.print("Press 1 :Delete by the Membership No\n"+
                "Press 2 :Delete by the Name\n"+
                "else    :To go back\n"+
                "Enter Your choice :");
        int choice = sc.nextInt();
        if (choice==1 || choice==2) {

            DB database = Database.startconnection();
            DBCollection collection = database.getCollection("Gym Management Database");

            switch (choice) {
                case 1:
                    System.out.print("Enter the Membership No :");
                    int noInput = sc.nextInt();
                    int count = Database.slotscount();
                    DBCursor cursor = collection.find();
                    String type = cursor.next().get("memberType").toString();
                    collection.remove(new BasicDBObject().append("_id", noInput));
                    System.out.println("Membership No : " + noInput + " Record deleted Successfully! ");
                    System.out.println("Membership Type : " + type);
                    System.out.println("Remaining Member slots No : " + (100 - count));

                    break;

                case 2:
                    System.out.print("Enter the Name of the Member :");
                    String nameIn = sc1.nextLine();
                    count = Database.slotscount();
                    cursor = collection.find();
                    type = cursor.next().get("memberType").toString();
                    collection.remove(new BasicDBObject().append("name", nameIn));
                    System.out.println("Name : " + nameIn + " Record deleted Successfully!");
                    System.out.println("Membership Type : " + type);
                    System.out.println("Remaining Member slots No : " + (100 - count));


            }
        }else {
            System.out.println("Enter a Valid Input");
        }
    }

    @Override
    public void printListofMembers() {
        DB database = Database.startconnection();
        DBCollection collection = database.getCollection("Gym Management Database");
        DBCursor csr1=collection.find();
        DBCursor csr2=collection.find();
        DBCursor csr3=collection.find();
        DBCursor csr4=collection.find();
        DBCursor csr5=collection.find();
        DBCursor csr6=collection.find();
        DBCursor csr7=collection.find();
        DBCursor csr8=collection.find();
        DBCursor csr9=collection.find();
        DBCursor csr10=collection.find();
        DBCursor csr11=collection.find();
        DBCursor csr12=collection.find();
        DBCursor csr13=collection.find();
        DBCursor csr14=collection.find();
        DBCursor csr15=collection.find();

        System.out.println("                                                     Member's List");
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

    @Override
    public void sort() {
        DB database = Database.startconnection();
        DBCollection collection = database.getCollection("Gym Management Database");
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------");
        System.out.println("-----------------------Sort the List--------------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Press 1                : To Sort by Membership Number");
        System.out.println("Press 2                : To Sort by Membership Name");
        System.out.println("Press any other number : To Go back to the Main Menu");
        System.out.print("\nEnter your Choice      : ");
        int choice = input.nextInt();

        try{
            switch (choice){
                case 1:

                    Database.sortingListByID("_id",1);
                    break;
                case 2:

                    Database.sortingListByName("name",1);
                    break;

            }

        }catch (InputMismatchException e){
            System.out.println("Enter a Valid Input!");

        }
    }

    @Override
    public void save() throws IOException {
        File file = new File("datafile.txt");
        PrintWriter writer = new PrintWriter("datafile.txt");
        StringBuilder toString = new StringBuilder();
        DB database = Database.startconnection();
        DBCollection collection = database.getCollection("Gym Management Database");
        DBCursor csr1=collection.find();
        DBCursor csr2=collection.find();
        DBCursor csr3=collection.find();
        DBCursor csr4=collection.find();
        DBCursor csr5=collection.find();
        DBCursor csr6=collection.find();
        DBCursor csr7=collection.find();
//        DBCursor csr8=collection.find();
//        DBCursor csr9=collection.find();
//        DBCursor csr10=collection.find();
//        DBCursor csr11=collection.find();
//        DBCursor csr12=collection.find();
//        DBCursor csr13=collection.find();
        DBCursor csr14=collection.find();
        DBCursor csr15=collection.find();


        String last =String.format("%-15s %-20s %-25s %-25s %-10s %-10s %n","Membership No","Membership Type","Membership Start Date","Member's Name","Weight","Height","Town","School","Parents Contact","Sports","Age","Medical Issues","Emergency Contact\n");
        while (csr1.hasNext() || csr2.hasNext()||csr3.hasNext()||csr4.hasNext()||csr5.hasNext()||csr6.hasNext()) {
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
            toString.append(String.format("%-15s %-20s %-25s %-25s %-10s %-10s %n",membershipNo,type,date,name,weight,height,town/*school.toString(),parents.toString(),sports.toString(),age.toString(),medical.toString(),emergency.toString()*/));

        }

        writer.write("                                                     Member's List\n"+
                "---------------------------------------------------------------------------------------------------------------------------------\n"+
                last+"\n"+toString);

        writer.close();
        System.out.println("File Writed Successfully!");

    }


}
