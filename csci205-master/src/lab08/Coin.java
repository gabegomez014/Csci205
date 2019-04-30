/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 02/09/2017
 * Time: 1 PM
 *
 * Project: Coin.Gabe
 * Package: lab08
 * File: Coin.java
 * Description: An enum of Coins
 *
 * *******************************
 */
package lab08;

/**
 * Coin - A simple enumerated type to represent the different types of coins
 *
 * @author gag014
 */
public enum Coin {
    PENNY(0.01),
    NICKEL(0.05),
    DIME(0.10),
    QUARTER(0.25),
    DOLLAR(1.00);

    private double value;

    Coin(double value) {
        this.value = value;
    }

    double getValue() {
        return this.value;
    }
}
