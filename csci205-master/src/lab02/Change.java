/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 01/23/2017
 *
 * Lab: Lab02, Exercise 4
 *
 * Description:
 * This is a simple program to compute a proper amount of change given some
 * number of pennies.
 *
 * @author BRK 2012-fall, with slight modifications in 2015
 */

package lab02;

import java.util.Scanner;

public class Change {

    final static int PENNIES_PER_QUARTER = 25;
    final static int PENNIES_PER_DOLLAR = 100;
    final static int PENNIES_PER_DIME = 10;
    final static int PENNIES_PER_NICKEL = 5;


    public static void main(String[] args) {
	
	String answer = "y";
	do {	
	
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of pennies: ");

        int pennies = in.nextInt();
	System.out.printf("%d pennies breaks down to: \n", pennies);

	//Compute number of dollars
	int dollars = pennies / PENNIES_PER_DOLLAR;

	// Compute number of pennies leftover
        pennies %= PENNIES_PER_DOLLAR;

        // Compute number of quarters
        int quarters = pennies / PENNIES_PER_QUARTER;

        // Compute number of pennies leftover
        pennies %= PENNIES_PER_QUARTER;

	//Compute number of dimes
	int dimes = pennies / PENNIES_PER_DIME;

	// Compute number of pennies leftover
        pennies %= PENNIES_PER_DIME;

	//compute number of nickles
	int nickels = pennies / PENNIES_PER_NICKEL;

	// Compute number of pennies leftover
        pennies %= PENNIES_PER_NICKEL;


        // Output the results
        /*System.out.format(
                "%d quarters yielding $%.2f with %d pennies left%n",
                quarters, quarters * PENNIES_PER_QUARTER / 100.0, pennies);*/

	System.out.format("%d dollars = $%.2f \n", dollars, (float)dollars);
	System.out.format("%d quarter = $%.2f \n", quarters, (float)quarters * PENNIES_PER_QUARTER / 100.0);
	System.out.format("%d dimes = $%.2f \n", dimes, (float)dimes * PENNIES_PER_DIME / 100.0);
	System.out.format("%d nickels = $%.2f \n", nickels, (float)nickels * PENNIES_PER_NICKEL / 100.0);
	System.out.format("%d pennies = $%.2f \n", pennies, pennies/100.0);
	
	Scanner user = new Scanner(System.in);
	System.out.print("Try again? [y | n]: ");
	answer = user.next();	
	} while(answer.equals("y"));
	System.out.println("Goodbye!");
	
    }
}
