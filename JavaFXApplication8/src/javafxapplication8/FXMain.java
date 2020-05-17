package javafxapplication8;
//Author: Jake Apted 500881106

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.beans.property.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;


public class FXMain extends Application
{
    static Stage window;
    static ArrayList<Customer> customerArray = new ArrayList(); 
    static String path;
    
    public ArrayList<Customer> getCustomerArray()
    {
        return customerArray;
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        
//Login scene
        window.setTitle("Co-Appointment");
        Label login = new Label("Login");
        Button customer = new Button("Customer Login");
        Button business = new Button("Business Login");
        Button claim = new Button("Claim Business");
        Button create = new Button("Create Customer Account");
        Button exit = new Button("Exit Program");
        GridPane gridPane0 = new GridPane();
        gridPane0.add(login, 0, 0);
        gridPane0.add(customer, 0, 1);
        gridPane0.add(business, 0, 2);
        gridPane0.add(exit, 1, 3);
        gridPane0.add(claim, 1, 1);
        gridPane0.add(create, 1, 2);
        gridPane0.setHgap(40);
        gridPane0.setVgap(20);
        
        Scene loginScene = new Scene(gridPane0, 400, 200);
        
//Business login scene
        Label role1 = new Label("Business Login");
        Label username0 = new Label("Username:");
        TextField usernameField0 = new TextField();
        Label password0 = new Label("Password:");
        PasswordField passwordField0 = new PasswordField();
        Button businessLogin = new Button("Submit");
        Button back1 = new Button("Back");
        GridPane gridPane1 = new GridPane();
        gridPane1.add(role1, 0, 0);
        gridPane1.add(username0, 0, 1);
        gridPane1.add(usernameField0, 0, 2);
        gridPane1.add(password0, 0, 3);
        gridPane1.add(passwordField0, 0, 4);
        gridPane1.add(businessLogin, 0, 5);
        gridPane1.add(back1, 1, 5);
        
        Scene businessLoginScene = new Scene(gridPane1, 500, 500);
        
//Business logged in scene
        Label role2 = new Label("Business Logged In");
        Button display = new Button("Display Appointments");
        Button setHoursButton = new Button("Set Hours");
        Button setMaxCust = new Button("Set max simultaneous visits");
        Button logout2 = new Button("Logout");
        GridPane gridPane2 = new GridPane();
        gridPane2.add(role2, 0, 0);
        gridPane2.add(display, 0, 1);
        gridPane2.add(setHoursButton, 0, 2);
        gridPane2.add(setMaxCust, 0, 3);
        gridPane2.add(logout2, 2, 4);
        
        Scene businessLoggedInScene = new Scene(gridPane2, 600, 250);
        
//Customer login scene
        Label role3 = new Label("Customer Login");
        Label username1 = new Label("Username:");
        TextField usernameField1 = new TextField();
        Label password1 = new Label("Password:");
        PasswordField passwordField1 = new PasswordField();
        Button submit3 = new Button("Submit");
        Button back3 = new Button("Back");
        GridPane gridPane3 = new GridPane();
        gridPane3.add(role3, 0, 0);
        gridPane3.add(username1, 0, 1);
        gridPane3.add(usernameField1, 0, 2);
        gridPane3.add(password1, 0, 3);
        gridPane3.add(passwordField1, 0, 4);
        gridPane3.add(submit3, 0, 5);
        gridPane3.add(back3, 1, 5);
        
        Scene customerLoginScene = new Scene(gridPane3, 500, 500);
        
        
//Customer logged in scene
        Label role4 = new Label("Logged In");
        TextField searchField = new TextField("Search for Business");
        Button search = new Button("Search");
        Button settings = new Button("User Settings");
        Button logout4 = new Button("Logout");
        GridPane gridPane4 = new GridPane();
        gridPane4.add(role4, 0, 0);
        gridPane4.add(searchField, 0, 1);
        gridPane4.add(search, 0, 2);
        gridPane4.add(settings, 1, 2);
        gridPane4.add(logout4, 1, 3);
        
        Scene customerLoggedInScene = new Scene(gridPane4, 500, 500);
       
        
        window.setScene(loginScene);
        window.show();       
        
        
//Login Scene Actions
        customer.setOnAction(event ->
        {        
            window.setScene(customerLoginScene);
        });
        
        business.setOnAction(event ->
        {
            window.setScene(businessLoginScene);
        });
        
        claim.setOnAction(event ->
        {
            //direct to verify phone
        });
        
        create.setOnAction(event ->
        {
            //create customer account
        });
        
        exit.setOnAction(event ->
        {
            System.exit(0);
        });
        
//Business Login Scene Actions
        businessLogin.setOnAction(event ->
        {
            //check account info and sign in
            //iff account info is good,
            usernameField0.setText("");
            passwordField0.setText("");
            window.setScene(businessLoggedInScene);
        });
        
        back1.setOnAction(event ->
        {
            window.setScene(loginScene);
        });
        
        
//Business Logged In Scene Actions
        logout2.setOnAction(event ->
        {
           window.setScene(loginScene);
        });
        
//Customer Login Scene Actions
        submit3.setOnAction(event ->
        {
            //check if account info is good
            //iff account info is good
            usernameField1.setText("");
            passwordField1.setText("");
            window.setScene(customerLoggedInScene);
        });
        
        back3.setOnAction(event ->
        {
            window.setScene(loginScene);
        });


//Customer Logged In Scene Actions
        search.setOnAction(event ->
        {
            //use google places API to search places
        });
        
        settings.setOnAction(event ->
        {
            //open user settings scene
        });
        
        logout4.setOnAction(event ->
        {
            window.setScene(loginScene);
        });
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
