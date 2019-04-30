/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 02/24/2017
 * Time: 1 PM
 *
 * Project: csci205
 * Package: lab12
 * File: ScanWebPageClient
 * Description: The main program for ScanWebpage
 *
 * *******************************
 */
package lab12;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Gabe Gomez
 */
public class ScanWebPageClient {

    /**
     * The main method for ScanWebPageClient to test ScanWebPage
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, IllegalArgumentException, UnknownHostException, FileNotFoundException {
        String address = findAdress();

        System.out.print("What tag would you like to scan?: ");
        Scanner tag = new Scanner(System.in);
        String tagScan = tag.nextLine();

        System.out.print(
                "What file would you like these written to? (add .txt to it): ");
        Scanner outFile = new Scanner(System.in);
        String out = outFile.nextLine();

        ScanWebPage page = new ScanWebPage(address, tagScan, out);
        page.tagCounter();

    }

    private static String findAdress() throws MalformedURLException, IOException {
        boolean valid = false;
        String address = null;
        while (!valid) {
            System.out.print("Please put in a url: ");
            Scanner url = new Scanner(System.in);
            address = url.nextLine();
            try {
                URL locator = new URL(address);
            } catch (MalformedURLException e) {
                System.out.println(
                        "Your url is either malformed or incomplete. Correct form: http://www.bucknell.edu");
                continue;
            }

            URL locator = new URL(address);

            try {
                BufferedInputStream in = new BufferedInputStream(
                        locator.openStream());

            } catch (IllegalArgumentException e) {
                System.out.println(
                        "Your URL address is incorrect. There is something wrong with the syntax.");
                continue;
            } catch (UnknownHostException e) {
                System.out.println("This host does not exist. Try again");
                continue;
            } catch (FileNotFoundException e) {
                System.out.println(
                        "This file does not exist in the specified URL");
                continue;
            }
            valid = true;
        }
        return address;
    }
}
