/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 02/09/2017
 * Time: 1 PM
 *
 * Project: CoinCollectionClient.Gabe
 * Package: lab08
 * File: CoinCollectionClient.java
 * Description: A GUI for the coin collection program
 *
 * *******************************
 */
package lab08;

import javax.swing.*;

/**
 *
 * @author gag014
 */
public class CoinCollectionClient {

    private final String options[];

    /**
     * A constructor for the Coin collection client
     */
    public CoinCollectionClient() {
        this.options = new String[AddRemoveChoices.values().length];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean done = false;
        CoinCollection myCoins = new CoinCollection();
        myCoins.addCoins(Coin.NICKEL, 5);
        myCoins.addCoins(Coin.DIME, 3);
        myCoins.addCoins(Coin.QUARTER, 7);
        myCoins.addCoins(Coin.DOLLAR, 1);
        OUTER:
        while (!done) {

            int choice;
            choice = JOptionPane.showOptionDialog(null,
                                                  myCoins + "\nSelect your action:",
                                                  "Add or Remove?",
                                                  0,
                                                  JOptionPane.INFORMATION_MESSAGE,
                                                  null,
                                                  AddRemoveChoices.values(),
                                                  0);
            //myCoins.addCoins(Coin.PENNY, 10); For some reason, methods in CoinCollection stop working after this point. Need explanation.
            switch (choice) {
                case 2: {
                    Object coinType;
                    coinType = JOptionPane.showInputDialog(null,
                                                           "Select coin type",
                                                           "Coin Slection",
                                                           JOptionPane.INFORMATION_MESSAGE,
                                                           null,
                                                           Coin.values(),
                                                           0);
                    if (coinType == null) {
                        JOptionPane.showMessageDialog(null,
                                                      "You have:\n" + myCoins + "\nGoodybe!",
                                                      "Goodbye!",
                                                      JOptionPane.INFORMATION_MESSAGE);
                        break OUTER;
                    }
                    String coinSelected;
                    coinSelected = coinType.toString();
                    String addString;
                    addString = JOptionPane.showInputDialog(null,
                                                            "How many do you want to add?",
                                                            "Add Coins",
                                                            JOptionPane.INFORMATION_MESSAGE);
                    if (addString == null) {
                        JOptionPane.showMessageDialog(null,
                                                      "You have:\n" + myCoins + "\nGoodybe!",
                                                      "Goodbye!",
                                                      JOptionPane.INFORMATION_MESSAGE);
                        break OUTER;
                    }
                    int addInt;
                    addInt = Integer.parseInt(addString);
                    System.out.println(Coin.valueOf(coinSelected));
                    System.out.println(addInt);
                    myCoins.addCoins(Coin.valueOf(coinSelected.toUpperCase()),
                                     addInt);
                    System.out.println(myCoins);
                    break;
                }
                case 1: {
                    Object coinType;
                    coinType = JOptionPane.showInputDialog(null,
                                                           "Select coin type",
                                                           "Coin Slection",
                                                           JOptionPane.INFORMATION_MESSAGE,
                                                           null,
                                                           Coin.values(),
                                                           0);
                    if (coinType == null) {
                        JOptionPane.showMessageDialog(null,
                                                      "You have:\n" + myCoins + "\nGoodybe!",
                                                      "Goodbye!",
                                                      JOptionPane.INFORMATION_MESSAGE);
                        break OUTER;
                    }
                    String coinSelected;
                    coinSelected = coinType.toString();
                    String removeString;
                    removeString = JOptionPane.showInputDialog(null,
                                                               "How many do you want to remove? Max: " + myCoins.getCount(
                                                                       Coin.valueOf(
                                                                               coinSelected)),
                                                               "Remove Coins",
                                                               JOptionPane.INFORMATION_MESSAGE);
                    if (removeString == null) {
                        JOptionPane.showMessageDialog(null,
                                                      "You have:\n" + myCoins + "\nGoodybe!",
                                                      "Goodbye!",
                                                      JOptionPane.INFORMATION_MESSAGE);
                        break OUTER;
                    }
                    int removeInt;
                    removeInt = Integer.parseInt(removeString);
                    myCoins.removeCoins(Coin.valueOf(coinSelected.toUpperCase()),
                                        removeInt);
                    break;
                }
                default:
                    done = true;
                    JOptionPane.showMessageDialog(null,
                                                  "You have:\n" + myCoins + "\nGoodybe!",
                                                  "Goodbye!",
                                                  JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }
    }

}
