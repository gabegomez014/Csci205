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

* Description: Gaussian test file

*

* *****************************************/

package lab04;
import java.lang.Math;
import java.util.stream.*;
import java.util.Random;

public class TestGaussian {

	static final int MAX_NUMS = 5000000;
	
   /**
    * A function that returns the standard deviation of a set using the regular
    * Standard deviation formula
    * 
    * @param double nums[] which is the set of doubles to calculated
    * @return the standard deviation
	*/
	public static double calcStDev(double nums[]) {
	
		int length = nums.length;
		double mean = 0;
		
		for (int i = 0; i <= length - 1; i++) {
			mean += nums[i];
		}
		
		mean = mean / length;
		
		double s = 0;
		
		for (int i = 0; i <= length - 1; i++) {
			s += Math.pow((nums[i]-mean), 2);
		}
		
		s = Math.sqrt(s / length);
		return s;
	}
	
	/**
    * A function that returns the standard deviation of a set using the alternate
    * Standard deviation formula
    * 
    * @param double nums[] which is the set of doubles to calculated
    * @return the standard deviation
	*/
	public static double calcAltStDev(double nums[]) {
	
		double result = 0;
		double result_squared = 0;
		int length = nums.length;
		
		for (int i = 0; i <= length -1; i++) {
			result += nums[i];
			result_squared += Math.pow(nums[i], 2);
		}
		
		double mean = result / length;
		double s = result_squared / length - Math.pow(mean, 2);
		return Math.sqrt(s);
	}


	public static void main (String[] args) {
		
		Random rand = new Random();
		double[] nums = new double[MAX_NUMS];
		
		for (int i = 0; i < MAX_NUMS; i++) {
			nums[i] = rand.nextGaussian();
		}
		
		System.out.println("Generating 5,000,000 numbers...");
		long start = System.nanoTime();
		System.out.printf("sd: %f\n", calcStDev(nums));
		long end = System.nanoTime();
		double difference = (end - start)/ 0.001;
		System.out.printf("TIME: %.3f usec\n", difference);
		
		start = System.nanoTime();
		System.out.printf("alt_sd: %.3f\n", calcAltStDev(nums));
		end = System.nanoTime();
		double altDifference = (end - start)/ 0.001;
		System.out.printf("TIME: %.3f usec\n", difference);
		
		double percentage = ((altDifference / difference) * 100);
		System.out.printf("alt_sd computed in %.2f%% of the time of sd\n", 			percentage);
	}
}


