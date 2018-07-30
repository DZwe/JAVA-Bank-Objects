// ****************************************************************
//   TestConsolidation.java
//
//   Zwe Phone Shein & Tyler Riedal ~ Nov 21, 2014
//
//   Prompts for and reads in three names and creates an account with an 
//   initial balance of $100 for each.     
// ****************************************************************

import java.util.Scanner;
import java.util.Random;

public class TestConsolidation 
{
    public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		// Create an array
		Account[ ] acctArray = new Account[3];
		
		// Prompt the user to enter names for the accounts
		for (int i = 0; i < acctArray.length; i++) 
		{
			System.out.print("Enter account name: ");
			String name = scan.next();
			
			Random r = new Random();
			int Low = 1000;
			int High = 10000;
			int R = r.nextInt(High-Low) + Low;
			
		    acctArray[i] = new Account(100, name, R);
		}
		
		// Prints the information of the accounts
		for (int i = 0; i < acctArray.length; i++) 
		{
			System.out.println(acctArray[i].toString());
		}
		
		// Close the first account
		acctArray[0].close();
		
		// Consolidate the second and third account if their names are the same
		Account acct4 = Account.consolidate(acctArray[1], acctArray[2]);
		
		if (acct4 != null) 
		{
			System.out.println(acct4.toString());
		}
		
		// Print out the new information of the accounts
		for (int i = 0; i < acctArray.length; i++) 
		{
			System.out.println(acctArray[i]);
		}
		
		scan.close();
	}
}
