package javafxapplication8;
import java.io.*;
import java.nio.file.*;
//Author: Jake Apted 500881106

public class Store
{
    private String username = "admin";
    private String password = "admin";
    private static Store manager;
    
    /**
     * Effects: Adds a customer to ArrayList customerArray given a username and password
     * Modifies: customerArray located in Main class
     * Requires: usernameText and passwordText cannot be empty or null
     */
    public void addCustomer(String usernameText, String passwordText)
    {
        FXMain.customerArray.add(new Customer(usernameText, passwordText));
    }
    
     /** 
     * Effects: Deletes a customer from the ArrayList customerArray, and deletes their 
     *          corresponding client file from the customers folder directory
     * Modifies: customerArray located in Main class and file folder named "customers"
     *          located in the main path of the project.
     * Requires: Customer item must not be null
     */
    public void deleteCustomer(Customer item)
    {
        FXMain.customerArray.remove(item);
        try
        {
            Files.deleteIfExists(Paths.get(FXMain.path + item.getUsername() + ".txt"));
        } catch (IOException e) {
            System.out.println("No such file");
        }
    }
    
    /**
     * Effects: Verifies managers credentials, and returns true if credentials
     *          are indeed correct
     * Modifies: nothing
     * Requires: usernameText and passwordText must not be null
     */
    public boolean login(String usernameText, String passwordText)
    {
        if (usernameText.equals(username) && passwordText.equals(password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /** 
     * Effects: implementation of singleton design pattern, ensuring only one
     *          manager object exists at a time
     * Modifies: variable manager
     * Requires: nothing
     */
    public static Store getInstance()
    {
        if (manager == null)
        {
            manager = new Store();
        }
        return manager;
    }
    
    /**
     * Effects: Ensures that a username exists in ArrayList customerArray,
     *          if it does it returns false, if it does not it returns true
     * Modifies: nothing
     * Requires: usernameText must not be null
     */
    public boolean checkUsername(String usernameText)
    {
        for (Customer item : FXMain.customerArray)
        {
            if (item.getUsername().equals(usernameText))
                return false;
        }
        return true;
    }
    
}