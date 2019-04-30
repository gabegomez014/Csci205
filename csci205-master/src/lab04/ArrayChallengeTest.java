/* *****************************************

* CSCI205 - Software Engineering and Design

* Spring 2017

* Instructor: Professor Dancy

* Section: 1 PM

*

* Name: Gabe Gomez

* Date: 01/27/2017

*

* Lab / Assignment: Lab 4

*

* Description: Array challenge file

*

* *****************************************/
package lab04;

import java.util.*;

public class ArrayChallengeTest {

    /**
     * Takes into two arrays of doubles and returns a single array that is a
     * concatenation of arrays entered
     *
     * @param a1 and a2 which are each arrays of double
     * @return single array that is the two arrays together
     */
    public static double[] concat(double[] a1, double[] a2) {
        double[] array = ArrayUtils.addAll(a1, a2);
        return array;
    }

    /**
     * A method that will give the reverse of the array that is put in
     *
     * @param array a
     * @return the reverse of input array a
     */
    public static double[] reverse(double[] a) {
        double[] answer;
        return answer;
    }

    /**
     * Computes alternating sums of all elements within array
     *
     * @param array a
     * @return The alternating sum of all elements in a
     */
    public static double altSum(double[] a) {
        double answer = 0;
        return answer;
    }

    /**
     * A method that will return a bool (true or false) if elements in array are
     * in increasing order, and false otherwise
     *
     * @param array a
     * @return true or false
     */
    public static boolean isSorted(double[] a) {
        boolean answer = true;
        return answer;
    }

    public static void main(String[] args) {
        double[] array1 = {2, 3, 5, 7, 11};
        double[] array2 = {1, 4, 6, 8, 0};

        System.out.printf("array1: %s\n", Arrays.toString(array1));
        System.out.printf("array2: %s\n", Arrays.toString(array2));
        System.out.printf("concat test: %s\n", Arrays.toString(concat(array1,
                                                                      array2)));
        System.out.printf("reverse test: %.1f\n", Arrays.toString(
                          reverse(array1)));
        System.out.printf("altSum test: %s\n", altSum(concat(array1, array2)));
        System.out.printf("sorted test 1: %b\n", isSorted(array1));
        System.out.printf("sorted test 2: %b\n", isSorted(array2));

    }
}
