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
 * File: WordCountClient
 * Description: A main program for the WordCount program
 *
 * *******************************
 */
package lab12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabe Gomez
 */
public class WordCountClient {

    /**
     * The main program for the WordCountClient
     *
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        JFileChooser chooser = new JFileChooser();
        File file = null;
        int choice = 0;
        while (choice == 0) {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
            }
            WordCount counter = new WordCount(file);
            counter.doIt();

            choice = JOptionPane.showConfirmDialog(null, String.format(
                                                   "%s\nTry again?", counter),
                                                   "WordCount Results",
                                                   JOptionPane.YES_NO_OPTION);

        }
        JOptionPane.showMessageDialog(null, "Goodbye!");
    }
}
