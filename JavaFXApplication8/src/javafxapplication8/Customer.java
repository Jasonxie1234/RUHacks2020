package javafxapplication8;
//Author: Jake Apted 500881106

public class Customer
{
    private String username;
    private String password;
    protected Account account;    
    public Customer(String usernameField, String passwordField)
    {
        this.username = usernameField;
        this.password = passwordField;
        this.account = new Account();
    }
    
    public boolean login(String usernameText, String passwordText)
    {
        if ((this.username).equals(usernameText) && (this.password).equals(passwordText))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void deposit(double amount)
    {
        this.account.balance += amount;
    }
    
    public double withdraw(double amount)
    {
        this.account.balance -= amount;
        return amount;
    }
    
    public String getUsername()
    {
        String temp = this.username;
        return temp;
    }
    
    public String getPassword()
    {
        String temp = this.password;
        return temp;
    }
    
    public double getBalance()
    {
        return this.account.balance;
    }
}