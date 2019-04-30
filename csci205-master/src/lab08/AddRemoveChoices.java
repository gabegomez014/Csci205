/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 02/09/2017
 * Time: 1 PM
 *
 * Project: AddRempveChioces.java
 * Package: lab08
 * File: AddRemoveChoices.java
 * Description: An enum class for the coin collection client for choices
 *
 * *******************************
 */
package lab08;

/**
 *
 * @author gag014
 */
public enum AddRemoveChoices {
    DONE("Done"), REMOVE("Remove Coins"), ADD("Add coins");

    private String label;

    AddRemoveChoices(String s) {
        this.label = s;
    }

    @Override
    public String toString() {
        return label;
    }
}
