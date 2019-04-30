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
 * File: WordCount
 * Description: A program that counts the words of a file
 *
 * *******************************
 */
package lab12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabe Gomez
 */
public class WordCount {

    private File fileIn;
    private String fileName;
    private int charsCount;
    private int lineCount;
    private int wordCount;

    /**
     * Constructor of WordCount with File object
     *
     * @param file
     */
    public WordCount(File file) {
        this.fileIn = file;
        this.charsCount = 0;
        this.lineCount = 0;
        this.wordCount = 0;
    }

    /**
     * Constructor of WordCount with string name of file
     *
     * @param name
     */
    public WordCount(String name) {
        this.fileName = name;
        this.charsCount = 0;
        this.lineCount = 0;
        this.wordCount = 0;
    }

    /**
     * The method that calculates line number, character number and word number
     *
     * @throws FileNotFoundException
     */
    public void doIt() throws FileNotFoundException {
        Scanner in;
        boolean redo = true;

        while (redo) {
            try {
                in = new Scanner(this.fileIn);
                redo = false;
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null,
                                              "I am sorry, but the file could not be found. Try again");
                continue;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                                              "There has been an IOException Error. The program must terminate",
                                              "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        in = new Scanner(this.fileIn);

        while (in.hasNext()) {
            String tempStr = in.nextLine();
            if (!tempStr.equalsIgnoreCase("")) {
                this.wordCount += tempStr.split(" ").length;
            }

            this.charsCount += tempStr.length();
            this.lineCount++;
        }
    }

    public void setFileIn(File fileIn) {
        this.fileIn = fileIn;
    }

    @Override
    public String toString() {
        return String.format("%d %d %d %s", this.lineCount, this.wordCount,
                             this.charsCount, this.fileIn.getName());
    }
}
