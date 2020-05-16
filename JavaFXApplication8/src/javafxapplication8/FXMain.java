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
        
        //Inital Login scene
        window.setTitle("Co-Appointment");
        Label alerts1 = new Label("");
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
        Label role0 = new Label("Business Login");
        Label usernameLabel = new Label("Username");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
        Button businessLogin = new Button("Submit");
        Button setHours = new Button("Set Hours");
        Button setCustMax = new Button("Set Max Simultaneous Customers");
        Button displaySchedule = new Button("Display Schedule");
        Button back0 = new Button("Back");
        GridPane gridPane1 = new GridPane();
        gridPane1.add(role0, 0, 0);
        gridPane1.add(usernameLabel, 0, 1);
        gridPane1.add(usernameField, 0, 2);
        gridPane1.add(passwordLabel, 0, 3);
        gridPane1.add(passwordField, 0, 4);
        gridPane1.add(businessLogin, 0, 5);
        gridPane1.add(setHours, 1, 1);
        gridPane1.add(setCustMax, 1, 2);
        gridPane1.add(displaySchedule, 1, 3);
        gridPane1.add(back0, 1, 5);
        gridPane1.setHgap(40);
        gridPane1.setVgap(5);
        Scene businessLoginScene = new Scene(gridPane1, 500, 500);
        
        //Business logged in scene
        Label role1 = new Label("Business Logged In");
        Label alerts2 = new Label("");
        Button display = new Button("Display Appointments");
        Button setHoursButton = new Button("Set Hours");
        Button setMaxCust = new Button("Set max simultaneous visits");
        Button logout1 = new Button("Logout");
        GridPane gridPane2 = new GridPane();
        gridPane2.add(role1, 0, 0);
        gridPane2.add(display, 0, 1);
        gridPane2.add(setHoursButton, 0, 2);
        gridPane2.add(setMaxCust, 0, 3);
        gridPane2.add(logout1, 2, 4);
        gridPane2.add(alerts2, 0, 5);
        gridPane2.setHgap(60);
        gridPane2.setVgap(10);
        Scene businessLoggedInScene = new Scene(gridPane2, 600, 250);
        
        //Customer login scene
        
        
        //Customer logged in scene
        Label role2 = new Label("");
        Label alerts3 = new Label();
        StringProperty usernameBind = new SimpleStringProperty();
        role2.textProperty().bind(usernameBind);
        Label depositLabel = new Label("Deposit:");
        TextField depositField = new TextField("");
        Button depositButton = new Button("Deposit");
        Label withdrawLabel = new Label("Withdraw:");
        TextField withdrawField = new TextField("");
        Button withdrawButton = new Button("Withdraw");
        Label balanceLabel = new Label("Balance:");
        Label balanceField = new Label("");
        Button balanceButton = new Button("Get Balance");
        Label OPLabel = new Label("Online Purchase:");
        TextField OPField = new TextField("");
        Button OPButton = new Button("Purchase");
        Button logout2 = new Button("Logout");
        GridPane gridPane3 = new GridPane();
        gridPane3.add(role2, 0, 0);
        gridPane3.add(depositLabel, 0, 1);
        gridPane3.add(depositField, 0, 2);
        gridPane3.add(depositButton, 0, 3);
        gridPane3.add(withdrawLabel, 1, 1);
        gridPane3.add(withdrawField, 1, 2);
        gridPane3.add(withdrawButton, 1, 3);
        gridPane3.add(OPLabel, 2, 1);
        gridPane3.add(OPField, 2, 2);
        gridPane3.add(OPButton, 2, 3);
        gridPane3.add(balanceLabel, 3, 1);
        gridPane3.add(balanceField, 3, 2);
        gridPane3.add(balanceButton, 3, 3);
        gridPane3.add(logout2, 3, 5);
        gridPane3.add(alerts3, 0, 4, 3, 3);
        gridPane3.setHgap(25);
        gridPane3.setVgap(10);
        Scene customerLoggedInScene = new Scene(gridPane3, 750, 250);
        
        window.setScene(loginScene);
        window.show();
        
//Login Scene
        customer.setOnAction(event ->
        {        
            window.setTitle("JA Bank : Manager Profile");
            window.setScene(customerLoggedInScene);
            window.show();
        });
        
        business.setOnAction(event ->
        {
            window.setTitle("Business Login");
            window.setScene(businessLoginScene);
            window.show();
        });
        
        exit.setOnAction(event ->
        {
            for (Customer item : customerArray)
            {
                try{
                    PrintWriter pw = new PrintWriter(path+item.getUsername()+".txt");
                        pw.println(item.getUsername());
                        pw.println(item.getPassword());
                        pw.print(String.valueOf(item.getBalance()));
                        pw.close();
                } catch (IOException e) {
                    alerts1.setText("Error initializing stream");
                }
            }
            System.exit(0);
        });
        
//Store Scene
        logout1.setOnAction(event ->
        {
           window.setTitle("Co-Appointment");
           window.setScene(loginScene);
        });
        
//Customer Scene
        depositButton.setOnAction(event ->
        {
            for (Customer item : customerArray)
            {   
                if (role2.getText().equals(item.getUsername()))
                {
                    if (Double.parseDouble(depositField.getText()) > 0)
                    {
                        item.deposit(Double.parseDouble(depositField.getText()));
                        alerts3.setText("Deposited: " + depositField.getText());
                    }
                    else
                        alerts3.setText("Value must be positive");
                }
            }
        });

        withdrawButton.setOnAction(event ->
        {
            for (Customer item : customerArray)
            {   
                if (role2.getText().equals(item.getUsername()))
                {
                    if (Double.parseDouble(withdrawField.getText()) <= item.account.balance)
                    {
                        item.withdraw(Double.parseDouble(withdrawField.getText()));
                        alerts3.setText("Withdrew: " + withdrawField.getText());
                    }
                    else
                        alerts3.setText("Value cannot be larger than balance");
                }
            }
        });

        balanceButton.setOnAction(event ->
        {
            for (Customer item : customerArray)
            {   
                if (role2.getText().equals(item.getUsername()))
                    balanceField.setText("" + item.getBalance());
            }
        });

        OPButton.setOnAction(event ->
        {
            for (Customer item : customerArray)
            {   
                if ((role2.getText().equals(item.getUsername()) && (Double.parseDouble(OPField.getText()) >= 50) && (Double.parseDouble(withdrawField.getText()) <= item.account.balance)))
                {
                    alerts3.setText("Purchased");
                }
                else
                    alerts3.setText("Online purchase must be greater than $50, or funds unavailable");
            }
        });

        logout2.setOnAction(event ->
        {
           depositField.setText("enter $ amount");
           withdrawField.setText("enter $ amount");
           OPField.setText("enter $ amount");
           balanceField.setText("");
           alerts3.setText("");
           window.setTitle("JA Bank : Login");
           window.setScene(loginScene);
        });
    }

    public static void main(String[] args) {
        
      try {
            path = (new File(".").getCanonicalPath())+"\\customers\\";
            File dir = new File(path);
      
            for (File file : dir.listFiles())
            {
                List<String> allLines = Files.readAllLines(Paths.get(path + file.getName()));
                String oldUsername = allLines.get(0);
                String oldPassword = allLines.get(1);
                double oldBalance = Double.parseDouble(allLines.get(2));
                customerArray.add(new Customer(oldUsername, oldPassword));
                for (Customer item : customerArray)
                {
                    if (item.getUsername().equals(oldUsername))
                        item.account.balance = oldBalance;
                }
            }
        } catch (EOFException e) {
            System.out.println("End of file");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO error");
            e.printStackTrace();
        } 
        Application.launch(args);
    }
}
