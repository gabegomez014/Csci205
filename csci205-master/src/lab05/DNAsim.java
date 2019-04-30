/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 02/01/2017
 * Time: $1
 *
 * Project: DNAsim.Gabe
 * Package: lab05
 * File: DNAsim
 * Description: A program that asks the user for a length of a DNA sequence, and
 * the GC% that they want. These will be randomly generated values that lie
 * within the GC%.
 *
 * *******************************
 */
package lab05;

import java.util.Random;
import java.util.Scanner;

/**
 * Description: A program that takes in a user length and GC% (in a number that
 * represents a percentage) and gives longest nucleotide repeated and longest
 * repeated GC nucleotide.
 *
 * @author Gabe Gomez
 * @version 0.1
 */
public class DNAsim {

    /**
     * Description: A function that creates an array of the letters "A", "T",
     * "C" or "G" with fairly close correct percentages.
     *
     * @param length length of DNA sequence.
     * @param gcContentPct how GC percentage there is.
     * @return array of character.
     */
    public static char[] generateDNA(int length, double gcContentPct) {
        Random rand = new Random();
        char[] DNAsequence = new char[length];

        for (int i = 0; i < length; i++) {
            int possibility = rand.nextInt(101);

            if (possibility < (100 - gcContentPct)) {
                String AT = "AT";
                DNAsequence[i] = AT.charAt(rand.nextInt(2));
            }

            else {
                String GC = "GC";
                DNAsequence[i] = GC.charAt(rand.nextInt(2));
            }
        }

        return DNAsequence;
    }

    /**
     * Description: A function that prints out the DNA stats from the array.
     *
     * @param dna array with DNA sequence.
     */
    public static void printDNAStats(char[] dna) {
        double aCount;
        double tCount;
        double gCount;
        double cCount;
        double DNAlength = dna.length;

        aCount = letterCount(dna, 'A');
        tCount = letterCount(dna, 'T');
        gCount = letterCount(dna, 'G');
        cCount = letterCount(dna, 'C');

        double aPercent = (aCount / DNAlength) * 100;
        double tPercent = (tCount / DNAlength) * 100;
        double gPercent = (gCount / DNAlength) * 100;
        double cPercent = (cCount / DNAlength) * 100;

        System.out.println("Actual content of DNA sequence:");

        System.out.printf("A:  %.0f  (%.1f%%)\n", aCount, aPercent);
        System.out.printf("T:  %.0f  (%.1f%%)\n", tCount, tPercent);
        System.out.printf("G:  %.0f  (%.1f%%)\n", gCount, gPercent);
        System.out.printf("C:  %.0f  (%.1f)%%\n", cCount, cPercent);

    }

    /**
     * Description: A helper function to printDNAStats to help count letters in
     * array.
     *
     * @param dna array of DNA sequence.
     * @param letter letter that is being counted in array.
     * @return the counted letters.
     */
    public static double letterCount(char[] dna, char letter) {
        double letterCount = 0;
        int DNAlength;
        DNAlength = dna.length;

        // Checks to see if the char at i of dna equals the letter in quesiton
        for (int i = 0; i < DNAlength; i++) {
            if (dna[i] == letter) {
                letterCount++;
            }
        }

        return letterCount;
    }

    /**
     * Description: a function that prints the longest repeating nucleotide
     *
     * @param dna array of nucleotides
     */
    public static void printLongestRepeat(char[] dna) {
        char nucleotide;
        int aCount, tCount, gCount, cCount;
        int aIndex, tIndex, gIndex, cIndex;

        aCount = longestRepeat(dna, 'A')[0];
        aIndex = longestRepeat(dna, 'A')[1];

        gCount = longestRepeat(dna, 'G')[0];
        gIndex = longestRepeat(dna, 'G')[1];

        cCount = longestRepeat(dna, 'C')[0];
        cIndex = longestRepeat(dna, 'C')[1];

        tCount = longestRepeat(dna, 'T')[0];
        tIndex = longestRepeat(dna, 'T')[1];

        int longest;
        // Gets the number of repeats of the nucleotide with the greatest repeats.
        longest = Math.max(aCount, Math.max(gCount, Math.max(cCount, tCount)));

        // To properly print out nucleotide, repitions and index
        if (longest == aCount) {
            nucleotide = 'A';
            System.out.printf(
                    "Longest repeated nucleotide: %d %c's [index: %d]\n",
                    longest, nucleotide, aIndex);
        }

        else if (longest == gCount) {
            nucleotide = 'G';
            System.out.printf(
                    "Longest repeated nucleotide: %d %c's [index: %d]\n",
                    longest, nucleotide, gIndex);
        }

        else if (longest == tCount) {
            nucleotide = 'T';
            System.out.printf(
                    "Longest repeated nucleotide: %d %c's [index: %d]\n",
                    longest, nucleotide, tIndex);
        }

        else {
            nucleotide = 'C';
            System.out.printf(
                    "Longest repeated nucleotide: %d %c's [index: %d]\n",
                    longest, nucleotide, cIndex);
        }

    }

    /**
     * Description: A function that returns an int array of size 2 that has the
     * nucleotide count for input letter in the 0 index, and its corresponding
     * index at index 1
     *
     * @param dna array of nucleotides
     * @param letter nucleotide being checked and counted
     * @return int array with nucleotide count 0 index, and its corresponding
     * index start at index 1
     */
    public static int[] longestRepeat(char[] dna, char letter) {
        int nucleotideCount = 0;
        int tempNucleotideCount = 0;
        int index = 0;
        int tempIndex;
        tempIndex = 0;
        int DNAlength = dna.length;
        boolean countReset = true;
        int[] array = new int[2]; // size 2 because in index 0 will be the nuleotide count, and index 1 will have the index

        for (int i = 0; i < DNAlength; i++) {
            if (dna[i] == letter) {
                tempNucleotideCount++;
                if (countReset == true) {
                    tempIndex = i;
                    countReset = false;
                }
            }

            else if (tempNucleotideCount > nucleotideCount) {
                nucleotideCount = tempNucleotideCount;
                index = tempIndex;
                countReset = true;
                tempNucleotideCount = 0;
            }
        }

        array[0] = nucleotideCount;
        array[1] = index;
        return array;
    }

    /**
     * Description: Main function for the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int DNAlength;
        double GCpercent;

        System.out.println("Hello. Welcome to the DNA simulator.");
        System.out.print("How long? ");
        DNAlength = Integer.parseInt(input.next());

        System.out.print("What GC%%-content (put in without percent sign)? ");
        GCpercent = Double.parseDouble(input.next());

        char[] DNAsequence;
        System.out.println("Generating...");
        DNAsequence = generateDNA(DNAlength, GCpercent);
        System.out.println("Complete!");

        printDNAStats(DNAsequence);
        printLongestRepeat(DNAsequence);

    }

}
