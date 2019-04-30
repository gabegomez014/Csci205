/* *****************************************

* CSCI205 - Software Engineering and Design

* Spring 2017

* Instructor: Professor Dancy

* Section: 1 PM

*

* Name: Gabe Gomez

* Date: 01/25/2017

*

* Lab / Assignment: Lab 3, Exercise 6

*

* Description: String challenge; Exercise 6 for lab 3

*

* *****************************************/


package lab03;

/**
 * The StringChallenge class is used to evaluate several different string
 * exercises from lab03.
 *
 * @author brk009
 */
public class StringChallenge {

    /**
     * Count the number of vowels in a string.
     *
     * @param s The string to test
     * @return The number of vowels in <code>s</code>
     */
    public static int countVowels(String s) {
        // TODO - Finish this method!
	int vowelCount = 0;
	for (int i = 0; i < s.length(); i++) {
		if ((s.charAt(i) == 'a') || (s.charAt(i) == 'A') ||
		    (s.charAt(i) == 'e') || (s.charAt(i) == 'E') ||
	  	    (s.charAt(i) == 'i') || (s.charAt(i) == 'I') ||
	            (s.charAt(i) == 'o') || (s.charAt(i) == 'O') ||
		    (s.charAt(i) == 'u') || (s.charAt(i) == 'U')) {
		  	vowelCount++;
		}
	}
        return vowelCount;
    }

    /**
     * Count the number of vowels in a string. This method uses recursion
     *
     * @param s The string to test
     * @return The number of vowels in <code>s</code>
     */
    public static int countVowelsRec(String s) {
        // TODO - Finish this method!
	if (s.length() == 0) {
		return 0;
	}
	
	else if ((s.substring(0,1) == "a") || (s.substring(0,1) == "A")) {
		return 1 + countVowelsRec(s);
	}

	else if ((s.substring(0,1) == "e") || (s.substring(0,1) == "E")) {
		return 1 + countVowelsRec(s);
	}

	else if ((s.substring(0,1) == "i") || (s.substring(0,1) == "I")) {
		return 1 + countVowelsRec(s);
	}

	else if ((s.substring(0,1) == "o") || (s.substring(0,1) == "O")) {
		return 1 + countVowelsRec(s);
	}

	else if ((s.substring(0,1) == "u") || (s.substring(0,1) == "U")) {
		return 1 + countVowelsRec(s);
	}
        return countVowels(s.substring(1));
    }

  /**
   * Testing to see if the string that has been put in is a palindrome.
   * Done recursively
   *
   * @param s is the string that is being tested.
   * @return bool (true or false) for if s is a palindrome
   */

   public static boolean isPalindrome(String s) {
	
	
	if (s.length() == 0 || s.length() == 1) {
	   return true;
	}
	
	else if (s.charAt(0) == s.charAt(s.length() -1)) {
	   return isPalindrome(s.substring(1, s.length() -1));
	}
	return false;
}

    /**
     * Swaps the first and last letter of input string if, and only if,
     * the first and last character are letters.
     *
     * @param s is the string being altered
     * @return the swapped characters
     */
    public static String swapFirstAndLastLetter (String s) {

	int length = s.length();	
	
	if (Character.isDigit(s.charAt(0)) == true || Character.isDigit(s.charAt(length -1)) == true) {
	   return s;
	}
	
	else if (Character.isUpperCase(s.charAt(0)) == true && Character.isUpperCase(s.charAt(length -1)) == true) {
	   return Character.toUpperCase(s.charAt(length -1)) + s.substring(1, length -1) + s.charAt(0);
	}
	
	else if (Character.isUpperCase(s.charAt(0)) == false && Character.isUpperCase(s.charAt(length -1)) == false) {
		return s.charAt(length -1) + s.substring(1, length -1) + Character.toUpperCase(s.charAt(0));
	}

	else if (Character.isUpperCase(s.charAt(0)) == true && Character.isUpperCase(s.charAt(length -1)) == false) {
		return Character.toUpperCase(s.charAt(length -1)) + s.substring(1, length -1) + Character.toLowerCase(s.charAt(0));
	}

	else {
	   return Character.toLowerCase(s.charAt(length-1)) + s.substring(1, length -1) + Character.toUpperCase(s.charAt(0));
	}
}

   /**
    * A function that removes certain letters/words from an input string, depending on what is wished to be removed
    *
    * @param s which is the original word, sRemove which is the things that wished to be taken out from s
    * @return s with the removed letters/words
    */
    public static String withoutString(String s, String sRemove) {

	return s.replaceAll(sRemove, ""); 
}

   /**
    * A function that counts the sum of numbers in a string
    * if there is a sequence of digits, they are extracted and turned into an integer, and that is added to the number
    *
    * @param s the string being passed through
    * @return the total that the numbers in the string create
    */
    public static int sumNumbersInString(String s) {
	int length = s.length();
	String numString = "";
	int sum = 0;
	
	for (int i = 0; i <= length -1; i++) {
	   if (Character.isDigit(s.charAt(i)) == true) {
		numString += s.charAt(i);
		continue;
	   }
	   else if (numString != ""){
		sum += Integer.parseInt(numString);
		numString = "";
		}
	   else {
		continue;
	   }   
	}
	sum += Integer.parseInt(numString);
	return sum;
}
    /**
     * Main program to test out each String processing method
     */
    public static void main(String[] args) {
        String sTest = "Mississippi River";
       System.out.printf("countVowels(\"%s\") = %d\n", sTest, countVowels(sTest));
       System.out.printf("countVowelsRec(\"%s\") = %d\n", sTest, countVowelsRec(sTest));
//
        System.out.printf("isPalindrome(\"%s\") = %b\n", sTest, isPalindrome(sTest));
        sTest = "amanapanama";
        System.out.printf("isPalindrome(\"%s\") = %b\n", sTest, isPalindrome(sTest));
//
        sTest = "Testing";
        System.out.printf("swapFirstAndLastLetter(\"%s\") = \"%s\"\n", sTest, swapFirstAndLastLetter(sTest));
        sTest = "Testing123";
        System.out.printf("swapFirstAndLastLetter(\"%s\") = \"%s\"\n", sTest, swapFirstAndLastLetter(sTest));
//
       sTest = "Testing Running Walking Jumping";
        System.out.printf("withoutString(\"%s\",\"%s\") = \"%s\"\n", sTest, "ing", withoutString(sTest, "ing"));
        System.out.printf("withoutString(\"%s\",\"%s\") = \"%s\"\n", sTest, "Sleep", withoutString(sTest, "Sleep"));
//
        sTest = "a1b2c3";
        System.out.printf("sumNumbersInString(\"%s\") = %d\n", sTest, sumNumbersInString(sTest));
        sTest = "aa12bb34cc56dd78";
        System.out.printf("sumNumbersInString(\"%s\") = %d\n", sTest, sumNumbersInString(sTest));
    }
}
