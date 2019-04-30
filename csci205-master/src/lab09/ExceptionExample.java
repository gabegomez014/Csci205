/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 92/15/2017
 * Time: 1 PM
 *
 * Project: ExceptionExample.Gabe
 * Package: lab09
 * File: ExceptionExample.java
 * Description: An example of exception handling.
 *
 * *******************************
 */
package lab09;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author gag014
 */
public class ExceptionExample {

    public static final int SIZE = 10;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] x = new int[SIZE];
        int i = 0;

        do {
            try {
                System.out.print(
                        "Enter an index to fill, or " + SIZE + " to finish: ");
                i = in.nextInt();
                if (i != SIZE) {
                    x[i] = i;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(i + " is out of range! Try again!");
                continue;
            } catch (InputMismatchException e) {
                System.out.println("please enter integers! Try Again!");
                in.nextLine();
                continue;
            }
        } while (i != SIZE);
    }
}
