/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 03/01/2017
 * Time: 1 PM
 *
 * Project: csci205
 * Package: lab12
 * File: $ScanWebPageClientTest
 * Description: A test for all the exceptions that must be handled when handling websites
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
import junit.framework.TestCase;

/**
 *
 * @author gag014
 */
public class ScanWebPageClientTest extends TestCase {

    public ScanWebPageClientTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     *
     * @throws MalformedURLException
     */
    public void testMalformedURLException() throws MalformedURLException {
        System.out.println("MalformedURLException");
        String address = "www.bucknell.edu";
        try {
            URL locator = new URL(address);
            fail("Malformed address has passed");
        } catch (MalformedURLException e) {

        }
    }

    /**
     *
     * @throws MalformedURLException
     * @throws IOException
     */
    public void testIllegalArgumentException() throws MalformedURLException, IOException {
        System.out.println("IllegalArgumentException");
        String address = "http:\\www.bucknell.edu";
        URL locator = new URL(address);
        try {
            BufferedInputStream in = new BufferedInputStream(
                    locator.openStream());
            fail("Address with wrong syntax has passed");
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     *
     * @throws IOException
     */
    public void testUnknownHostException() throws IOException {
        System.out.println("UnknownHostException");
        String address = "http://www.bucknell.ed";
        URL locator = new URL(address);
        try {
            BufferedInputStream in = new BufferedInputStream(
                    locator.openStream());
            fail("Unknown host address has passed");
        } catch (UnknownHostException e) {

        }
    }

    /**
     *
     * @throws IOException
     */
    public void testFileNotFoundException() throws IOException {
        System.out.println("FileNotFoundException");
        String address = "http://www.bucknell.edu/blah.html";
        URL locator = new URL(address);
        try {
            BufferedInputStream in = new BufferedInputStream(
                    locator.openStream());
            fail("file within address has been found and passed");
        } catch (FileNotFoundException e) {

        }
    }

}
