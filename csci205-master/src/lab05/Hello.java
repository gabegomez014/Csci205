/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 02/01/2017
 * Time: 1 PM
 *
 * Project: First NetBeans Hello
 * Package: lab05
 * File: Hello.java
 * Description: First program created within NetBeans
 *
 * *******************************
 */
package lab05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Description: A simple program to aid in understanding NetBeans
 *
 * @author Gabe Gomez
 * @version 0.1
 */
public class Hello {

    private static final int NUM_INTS = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        greetUser();

        int[] x = getArrayOfRandomNums();
        System.out.println(Arrays.toString(x));
    }

    private static int[] getArrayOfRandomNums() {
        // Some simple code to test the debugger
        Random rand = new Random();
        int[] x = new int[NUM_INTS];
        for (int i = 0; i < NUM_INTS; i++) {
            x[i] = rand.nextInt(100);
        }
        return x;
    }

    private static void greetUser() {
        Scanner input = new Scanner(System.in);
        String name;
        System.out.print("Hello. What is your name? ");
        name = input.next();
        System.out.printf("%s, becoming a good programmer takes practice.\n",
                          name);
    }

}
