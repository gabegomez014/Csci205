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
 * File: ScanWebPage
 * Description: A program that reads all of the tags from a website
 *
 * *******************************
 */
package lab12;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 *
 * @author Gabe Gomez
 */
public class ScanWebPage {

    private URL site;
    private String tag;
    private PrintWriter out;
    private BufferedInputStream in;
    private Scanner scanner;
    private int count;
    private String file;

    /**
     * The constructor for ScanWebPage
     *
     * @param site
     * @param tag
     * @param file
     * @throws MalformedURLException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public ScanWebPage(String site, String tag, String file) throws MalformedURLException, FileNotFoundException, IOException {
        this.site = new URL(site);
        this.tag = tag;
        this.file = file;
        this.out = new PrintWriter(file);
        this.in = new BufferedInputStream(this.site.openStream());
        this.scanner = new Scanner(this.in);
        this.count = 0;
    }

    /**
     * Counts the tags that the user asked for
     */
    public void tagCounter() {
        Pattern pattern = Pattern.compile("<" + this.tag + "\\b[^>]*>(.*?)");
        String sMatch;
        while ((sMatch = this.scanner.findWithinHorizon(pattern, 0)) != null) {
            this.out.println("Found: " + sMatch);
            MatchResult match = scanner.match();
            this.count++;
        }
        this.out.printf("Wrote %d <%s> tags to %s", this.count,
                        this.tag, this.file);
        System.out.println(String.format("Wrote %d <%s> tags to %s", this.count,
                                         this.tag, this.file));

        this.out.close();
    }
}
