/* *****************************************

* CSCI205 - Software Engineering and Design

* Spring 2017

* Instructor: Professor Dancy

* Section: 1 PM

*

* Name: Gabe Gomez

* Date: 01/25/2017

*

* Lab / Assignment: Lab 03, Fibonacci sequence

*

* Description: Making a recursive function, and non-recursve function, for fibonacci sequence

*

* *****************************************/
package lab03;

import java.util.Scanner;
import java.lang.*;

/**
 * A simple class designed to give the user an opportunity to test a recursive
 * and non-recursive version of fibonacci
 *
 * Date: 2015-fall
 * @author BRK
 */
public class Fibonacci {

    /**
     * Compute the nth fibonacci number recursively
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int recFib(int n) {
        // TODO - Complete this method
	if (n == 0) {
		return 0;
	}
	else if (n == 1 || n == 2) {
		return 1;
	}

        return recFib(n-1) + recFib(n -2);
    }

    /**
     * Compute the nth fibonacci number non-recursively, using a while loop.
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int nonRecFib(int n) {
        // TODO - Complete this method
	if (n == 0) {
		return 0;
	}
	else if (n == 1 || n == 2) {
		return 1;
	}

	int previousNum = 1;
	int curNum = 1;
	int result = 1;
	while (n >= 3) {
		result = previousNum + curNum;
		previousNum = curNum;
		curNum = result;
		n--;
	}
        return result;
    }

    /**
     * Main program to test both fibonacci methods
     */
    public static void main(String[] args) {
        System.out.println("What fibonacci number do you want?");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
	
	long recTimeStart = System.nanoTime();
        System.out.println("Recursive fib: " + recFib(n));
	long recTimeEnd = System.nanoTime();
	double recDifference = recTimeEnd - recTimeEnd/1e6;

	long nonRecTimeStart = System.nanoTime();
        System.out.println("Non-recursive fib: " + nonRecFib(n));
	long nonRecTimeEnd = System.nanoTime();
	double nonRecDifference = (nonRecTimeEnd - nonRecTimeStart)/1e6;
	System.out.printf("Recusive Fibonacci took: %.6f ms%n", recDifference);
	System.out.printf("Non-recursive Fibonacci took: %f ms%n", nonRecDifference);
    }

}
