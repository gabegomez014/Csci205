/* *****************************************

* CSCI205 - Software Engineering and Design

* Spring 2017

* Instructor: Professor Dancy

* Section: 1-2 PM

*

* Name: Gabe Gomez

* Date: 01/19/2017

*

* Lab / Assignment: Lab01

*

* Description: Creating "Hello, World!" projcet on java.

*

* *****************************************/

package lab01;

public class Hello
{
	public static void main( String[] args ) {
		float startTime = System.nanoTime();
		System.out.println("Programming is not a spectator sport!");
		long endTime = System.nanoTime();
		//long elapsedTime = (endTime - startTime)/1000000;
		System.out.print("Execution time: ");
		System.out.print(endTime - startTime/1000000);
		System.out.println(" ms");
	}
}
