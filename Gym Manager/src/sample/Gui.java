package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Gui {
    public static void display(){
        Stage stage = new Stage();
        Scene scene;
        stage.setTitle("List of Members");

        //creating the Pane
        AnchorPane grid =new AnchorPane();
        TableView<DefaultMember> table = new TableView<>();
        table.setLayoutX(70);
        table.setLayoutY(70);
        table.setPrefSize(680,400);

        int count = Database.slotscount();

        //Creating A label
        Label slots = new Label("Remaining Slots : "+(100-count)+ " out of 100");
        slots.setLayoutX(220);
        slots.setLayoutY(470);
        slots.setStyle("-fx-font-weight: 200; -fx-font-size: 20;-fx-text-fill: white");

        //creating the buttons
        Button showall = new Button("Show All");
        showall.setLayoutX(600);
        showall.setLayoutY(20);
        Button search = new Button("Search");
        search.setLayoutX(400);
        search.setLayoutY(20);

        //creating the text Fields
        TextField searchtxt = new TextField();
        searchtxt.setLayoutX(70);
        searchtxt.setLayoutY(20);
        searchtxt.setPromptText("Enter your item");
        grid.getChildren().addAll(searchtxt,showall,search,table,slots);

        //columns
        TableColumn<DefaultMember,String> namecol = new TableColumn<>("Member Name");
        namecol.setMinWidth(130);
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<DefaultMember,String> membercol = new TableColumn<>("Member type");
        membercol.setMinWidth(130);
        membercol.setCellValueFactory(new PropertyValueFactory<>("type"));


        TableColumn<DefaultMember,String> idcol = new TableColumn<>("Membership Number");
        idcol.setMinWidth(80);
        idcol.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));

        TableColumn<DefaultMember,String> weightcol = new TableColumn<>("Weight");
        weightcol.setMinWidth(80);
        weightcol.setCellValueFactory(new PropertyValueFactory<>("weight"));


        TableColumn<DefaultMember,String> heightcol = new TableColumn<>("Height");
        heightcol.setMinWidth(80);
        heightcol.setCellValueFactory(new PropertyValueFactory<>("height"));


        TableColumn<DefaultMember,String> towncol = new TableColumn<>("Town");
        towncol.setMinWidth(120);
        towncol.setCellValueFactory(new PropertyValueFactory<>("place"));

        table.setItems(tabledisplay());
        table.getColumns().addAll(idcol,membercol,namecol,weightcol,heightcol,towncol);

        //calling the button
        showall.setOnAction(e->{
            table.setItems(tabledisplay());
            searchtxt.setText("");
        });
        search.setOnAction(e->{
            table.setItems(membershipNameSearch(searchtxt));
        });

        scene = new Scene(grid, 800, 500);
        scene.getStylesheets().add(Gui.class.getResource("gui.css").toExternalForm());
        stage.setScene(scene);
        stage.showAndWait();


    }
   //
    public static ObservableList<DefaultMember> tabledisplay(){
        ObservableList<DefaultMember> defaultMember = FXCollections.observableArrayList();

        ArrayList<Integer> membershipNo = Database.commonread2("_id");
        ArrayList<String> memberName = Database.commonread("name");
        ArrayList<Integer> day = Database.commonread2("membershipStartday");
        ArrayList<Integer> month = Database.commonread2("membershipStartmonth");
        ArrayList<Integer> year = Database.commonread2("membershipStartyear");
        ArrayList<String> type = Database.commonread("memberType");
        ArrayList<String> height = Database.commonread("height");
        ArrayList<String> weight = Database.commonread("weight");
        ArrayList<String> town = Database.commonread("Town");



        for(int count = 0; count<=membershipNo.size()-1;count++){
            Date date = new Date(day.get(count),month.get(count),year.get(count));
            defaultMember.add(new DefaultMember(membershipNo.get(count),memberName.get(count),date ,Integer.parseInt(weight.get(count)),Integer.parseInt(height.get(count)),town.get(count),type.get(count)));
        }
        return defaultMember;
    }
    public static ObservableList<DefaultMember> membershipNameSearch(TextField field){
        ObservableList<DefaultMember> member = FXCollections.observableArrayList();

        String input = field.getText();


        ArrayList<String> membershipNumber = Database.nameResult(Database.getByName(input),"_id");
        ArrayList<String> type = Database.nameResult(Database.getByName(input),"memberType");
        ArrayList<String> membershipName = Database.nameResult(Database.getByName(input),"name");
        ArrayList<String> weight = Database.nameResult(Database.getByName(input),"weight");
        ArrayList<String> height = Database.nameResult(Database.getByName(input),"height");
        ArrayList<String> town = Database.nameResult(Database.getByName(input),"Town");
        ArrayList<Integer> day = Database.nameResultforInt(Database.getByName(input),"membershipStartday");
        ArrayList<Integer> month = Database.nameResultforInt(Database.getByName(input),"membershipStartmonth");
        ArrayList<Integer> year = Database.nameResultforInt(Database.getByName(input),"membershipStartyear");

        for (int count=0;count<=membershipName.size()-1;count++){
            Date date = new Date(day.get(count),month.get(count),year.get(count));
            member.add(new DefaultMember(Integer.parseInt(membershipNumber.get(count)),membershipName.get(count),date ,Integer.parseInt(weight.get(count)),Integer.parseInt(height.get(count)),town.get(count),type.get(count)));
        }
        return member;
    }
}
