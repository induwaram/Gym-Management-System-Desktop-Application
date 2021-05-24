package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Application  {


    public static void main(String[] args)  throws IOException {
        //creating the scanner
        Scanner sc = new Scanner(System.in);
        MyGymManager myGymManager = new MyGymManager();

        //creating a while loop for the main menu
        try {
            while (true) {
                System.out.println("\n--------------------------------------------------------------");
                System.out.println("-----------------------Gym Management System------------------");
                System.out.println("--------------------------------------------------------------");
                System.out.println(
                        "Press 1 : to Add a new Member\n" +
                                "press 2 : To delete a member\n" +
                                "press 3 : To print the list of Members\n" +
                                "press 4 : to sort the Item and display In Ascending Order\n" +
                                "press 5 : To Write/Save in a file\n" +
                                "press 6 : To Open a Graphical User Interface\n" +
                                "press 7 : To Exit the Programme\n"

                );

                System.out.print("Enter your Choice : ");
                int choice = sc.nextInt();


                switch (choice) {
                    case 1:
                        myGymManager.addMember();
                        break;
                    case 2:
                        myGymManager.deleteMember();
                        break;
                    case 3:
                        myGymManager.printListofMembers();
                        break;
                    case 4:
                        myGymManager.sort();
                        break;
                    case 5:
                        myGymManager.save();
                        break;
                    case 6:
                        Application.launch();
                        System.exit(0);
                        break;
                    case 7:
                        System.exit(0);
                        break;
                }
            }
            }catch(InputMismatchException e){
                System.out.println("Please enter a Valid Input");

            }


        }




    @Override
    public void start(Stage primaryStage) throws Exception {
        Gui.display();

    }
}
