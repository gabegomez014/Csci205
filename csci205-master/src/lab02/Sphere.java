/* *****************************************

* CSCI205 - Software Engineering and Design

* Spring 2017

* Instructor: Professor dancy

* Section: 1 PM 
*

* Name: Gabe Gomez

* Date: 01/19/2017

*

* Lab / Assignment: Lab 02, Exercise 5

*

* Description: A program that takes in the radius of a sphere, and outputs its volume, and that same volume with its rounded value. 

*

* *****************************************/

package lab02;

import java.util.Scanner;
import java.lang.Math;

public class Sphere {

	final static double pi = Math.PI;

	public static void main(String[] args) {
	Scanner user = new Scanner(System.in);
	System.out.print("Enter the radius of a sphere: ");
	int radius = user.nextInt();
	double volume = (4 * pi * Math.pow(radius, 3))/3;
	System.out.printf("Volume is %.2f\n", volume);
	long rounded = Math.round(volume);
	System.out.printf("Round to the nearest integer: %d\n", rounded);

}
}
