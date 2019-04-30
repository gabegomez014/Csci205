/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 01/20/2017
 *
 * Lab: Lab02, Exercise 2
 *
 * @author Brian King, 2017-Spring
 *
 * Description:
 * A simple program to ask the user for a temperature in F, and converts it to
 * Celsius.
 * *****************************************
 */

package lab02;
import java.util.Scanner;

public class FtoC {
    public static void main(String[] args) {
	
	String answer = "yes";
	
	do {
        // Prompt user for a Fahrenheit temp
	Scanner user = new Scanner(System.in);
	System.out.print("Enter a temperature in farenheit: ");
	int fTemp = user.nextInt();
	float cTemp = (float)5/9 * ((float)fTemp - 32);
	System.out.printf("%d F = %.1f C\n", fTemp, cTemp);

	if (cTemp <= 0) {
	System.out.println("Brr... it is FREEZING out!");
	Scanner again = new Scanner(System.in);
	System.out.print("Try again? [y | n]: ");
	answer = user.next();
}
	
	else if (cTemp > 0 && cTemp <= 15) {
	System.out.println("It's a bit cool out");
	Scanner again = new Scanner(System.in);
	System.out.print("Try again? [y | n]: ");
	answer = user.next();
}

	else if (cTemp > 15 && cTemp <= 30) {
	System.out.println("It's comfortably warm");
	Scanner again = new Scanner(System.in);
	System.out.print("Try again? [y | n]: ");
	answer = user.next();
}

	else {
	System.out.println("It's HOT! I need A/C");
	Scanner again = new Scanner(System.in);
	System.out.print("Try again? [y | n]: ");
	answer = user.next();
}


} while (answer.equals("y"));

        // Create the Scanner object, attached to console input

        // Read and store the Fahrenheit temp

        // Convert the temp to Celsius

        // Output the results with correct formatting

    }
}
