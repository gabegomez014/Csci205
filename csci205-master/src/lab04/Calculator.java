/* *****************************************

* CSCI205 - Software Engineering and Design

* Spring 2017

* Instructor: Professor Dancy

* Section: 1 PM

*

* Name: Gabe Gomez

* Date: 01/30/2017

*

* Lab / Assignment: Lab 4

*

* Description: Switch calculator file

*

* *****************************************/
package lab04;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Calculator {

	/**
    * This method is used to re-run the calculator program when needed
    * 
    * @param no parameters
    * @return 0
	*/

	public static int reset () {
	
		Scanner input = new Scanner(System.in);
		boolean again = true;
		double num1 = 0;
		double num2 = 0;
		double result = 0;
		char operator = ' ';
		boolean error = true;
		
		
	while (again == true) {
		while (error == true || again == true) {
		error = false;
		again = false;
		System.out.print("Enter a simple arithmetic expression with spacing: ");
		
		if (input.hasNextDouble() == true) {
			num1 = input.nextDouble();
		}
		
		else {
			System.out.println("ERROR: cannot parse operand 1");
			error = true;
			return reset();
		}
		
		operator = input.next().charAt(0);
		if ((operator == '+' || operator == '-' || operator == '/' || operator == 				'*' || operator == '%' || operator == '^')) {
		
			operator = operator;
		}
		
		else if ( error != true){
			System.out.printf("ERROR: %c is not a valid operator\n", operator);
			error = true;
			return reset();
		}
		
		if (input.hasNextDouble() == true && error == false) {
			num2 = input.nextDouble();
		}
		
		else if (error != true){
			System.out.println("ERROR: cannot parse operand 2");
			error = true;
			return reset();
		}	
		}
		switch(operator) {
			case '+': result = num1 + num2;
					System.out.printf("The sum is %.2f\n", result);
					System.out.print("Try again? [y|n]: ");
					if (input.next().charAt(0) == 'y') {
						return reset();
					}
			
					else {
						break;
					}
			
			case '-': result = num1 - num2;
					System.out.printf("The difference is %.2f\n", result);
					System.out.print("Try again? [y|n]: ");
					if (input.next().charAt(0) == 'y') {
						return reset();
					}
			
					else {
						break;
					}
					
			case '*': result = num1 * num2;
					System.out.printf("The result is %.2f\n", result);
					System.out.print("Try again? [y|n]: ");
					if (input.next().charAt(0) == 'y') {
						return reset();
					}
			
					else {
						break;
					}
					
			case '/': result = num1 / num2;
					System.out.printf("The result is %.2f\n", result);
					System.out.print("Try again? [y|n]: ");
					if (input.next().charAt(0) == 'y') {
						return reset();
					}
			
					else {
						break;
					}
					
			case '^': result = Math.pow(num1, num2);
					System.out.printf("The result is %.2f\n", result);
					System.out.print("Try again? [y|n]: ");
					if (input.next().charAt(0) == 'y') {
						reset();
					}
			
					else {
						break;
					}
					
			case '%': result = num1 % num2;
					System.out.printf("The modulus is %.2f\n", result);
					System.out.print("Try again? [y|n]: ");
					if (input.next().charAt(0) == 'y') {
						return reset();
					}
			
					else {
						break;
					}
		}
	return 0;
	}
	return 0;
	}

   /**
    * This is the main method of the calculator class
    * 
    * @param array of strings
    * @return nothing
	*/
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		boolean again = true;
		double num1 = 0;
		double num2 = 0;
		double result = 0;
		char operator = ' ';
		boolean error = true;
		
		System.out.println("Welcome to the Calculator");
		System.out.println("Enter expressions with two numeric operands");
		System.out.println("and a single operator from +, -, *, /, % or ^");
		reset();
	}		
}
