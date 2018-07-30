//*******************************************************
// Account.java
//
// Zwe Phone Shein & Tyler Riedal ~ Nov 21, 2014
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, charge a fee to, and print a summary of the account.
//*******************************************************

import java.util.Random;

public class Account
{
    private double balance;
    private String name;
    private long acctNum;
    private static int numAccounts;

    //----------------------------------------------
    //Constructor -- initializes balance, owner, and account number
    //----------------------------------------------
    public Account(double initBal, String owner, long number)
    {
        balance = initBal;
        name = owner;
        acctNum = number;
        numAccounts++;
    }

    //----------------------------------------------
    // Checks to see if balance is sufficient for withdrawal.
    // If so, decrements balance by amount; if not, prints message.
    //----------------------------------------------
    public void withdraw(double amount)
    {
        if (balance >= amount)
            balance -= amount;
        else
            System.out.println("Insufficient funds");
    }

    //----------------------------------------------
    // Adds deposit amount to balance.
    //----------------------------------------------
    public void deposit(double amount)
    {
        balance += amount;
    }

    //----------------------------------------------
    // Returns balance.
    //----------------------------------------------
    public double getBalance()
    {
        return balance;
    }

    //----------------------------------------------
    // Returns a string containing the name, account number, and balance.
    //----------------------------------------------
    public String toString()
    {
        String string = "\nName: " + name + "\nAccount #: " + acctNum + "\nBalance: " + balance;
        return string;
    }

    //----------------------------------------------
    // Deducts $10 service fee
    //----------------------------------------------
    public double chargeFee()
    {
        balance -= 10;
        return balance;
    }

    //----------------------------------------------
    // Changes the name on the account 
    //----------------------------------------------
    public void changeName(String newName)
    {
        name = newName;
    }
  
    public static int getNumAccounts()
    {
        return numAccounts;
    }
  
    public void close()
    {
        name += " CLOSED";
        balance = 0;
        numAccounts -= 1;
    }
  
    public static Account consolidate(Account acct1, Account acct2)
    {
        Long tempAcct1 = new Long(acct1.acctNum);
        Long tempAcct2 = new Long(acct2.acctNum);
        if (!tempAcct1.equals(tempAcct2))
        {
            if (acct1.name.equals(acct2.name))
            {
                double balance = acct1.balance + acct2.balance;
                String name = acct1.name;
  			
                Random r = new Random();
                long Low = 1000;
  			    long High = 10000;
  			    long R = r.nextInt((int) (High-Low)) + Low;
  			
  			    long acctNum = R;
  			    Account acctMerge = new Account(balance, name, acctNum);
  			    acct1.close();
  			    acct2.close();
  			
  			return acctMerge;
            }
  		}
        System.out.println("Unable to merge accounts. Sorry.");
		return null;
    }
}
