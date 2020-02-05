/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package DataBase;
package DataBaseConnect;

import java.util.Vector;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class CompanyGUI extends Application {
    
    private Label msgLabel;
    private TextField idField,fNameField,mNameField,
            lNameField,emailField,phoneField;
    private Button createButton,updateButton,deleteButton,
            firstButton,previousButton,nextButton,lastButton;
    //User-companyGUI
    Vector<User> allUsers=User.selectAll();
    int count=0;
            
    @Override
    public void init(){
        msgLabel = new Label("Person Details");
        //field
        initFieldPane();
        //buttons
        initBtnPane();
        show(0);
        
    }
    @Override
    public void start(Stage primaryStage) {
        
         //fieldsPane Creation
        GridPane fieldsPane = new GridPane();
        createFieldPane(fieldsPane);
        //btnsPane Creation
        HBox btnsPane = new HBox();
        createBtnPane(btnsPane);
        //MainPane
        BorderPane rootPane = new BorderPane();
        rootPane.setCenter(fieldsPane);
        rootPane.setBottom(btnsPane);
        rootPane.setTop(msgLabel);
      
        Scene primaryScene = new Scene(rootPane, 600, 300);
        primaryStage.setTitle("ay 7aga");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public static void main(String[] args){
        Application.launch();
    }
    public void initFieldPane(){
        idField = new TextField();
        fNameField = new TextField();
        mNameField = new TextField();
        lNameField = new TextField();
        emailField = new TextField();
        phoneField = new TextField();
    };
    public void createFieldPane(GridPane fieldsPane){
        fieldsPane.setMinSize(400, 200);
        fieldsPane.setAlignment(Pos.CENTER);
        fieldsPane.setPadding(new Insets(30, 30, 30, 30));
        fieldsPane.setMaxSize(300, 300);
        fieldsPane.setHgap(20);
        fieldsPane.setVgap(2);
        fieldsPane.add(new Label("ID"), 1, 0);
        fieldsPane.add(idField, 2, 0);
        //idField.setEditable(false);
        fieldsPane.add(new Label("First Name"), 1, 1);
        fieldsPane.add(fNameField, 2, 1);
        fieldsPane.add(new Label("Middle Name"), 1, 2);
        fieldsPane.add(mNameField, 2, 2);
        fieldsPane.add(new Label("Last Name"), 1, 3);
        fieldsPane.add(lNameField, 2, 3);
        fieldsPane.add(new Label("Email"), 1, 4);
        fieldsPane.add(emailField, 2, 4);
        fieldsPane.add(new Label("Password"), 1, 5);
        fieldsPane.add(phoneField, 2, 5);
    };
    public void initBtnPane(){
        createButton = new Button("New");
        updateButton = new Button("Update");
        deleteButton = new Button("Delete");
        firstButton = new Button("First");
        previousButton = new Button("Previous");
        nextButton = new Button("Next");
        lastButton = new Button("Last");
    };
    public void createBtnPane(HBox btnsPane){
        btnsPane.getChildren().addAll(createButton, updateButton, deleteButton,
                 firstButton, previousButton, nextButton, lastButton);         
        btnsPane.setAlignment(Pos.CENTER);
        btnsPane.setPadding(new Insets(20, 20, 20, 20));      
        btnsPane.setSpacing(5);
    };
    public void show(int count){
        idField = new TextField(Integer.toString(allUsers.get(count).id));
        fNameField = new TextField(allUsers.get(count).firstName);
        mNameField = new TextField(allUsers.get(count).middleName);
        lNameField = new TextField(allUsers.get(count).lastName);
        emailField = new TextField(allUsers.get(count).email);
        phoneField = new TextField(allUsers.get(count).phone);


    };
}

