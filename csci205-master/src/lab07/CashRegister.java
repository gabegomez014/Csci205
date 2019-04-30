/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 02/06/2017
 * Time: 1 PM
 *
 * Project: CashRegister.Gabe
 * Package: lab07
 * File: CashRegister.java
 * Description: An OOD on a cash register
 *
 * *******************************
 */
package lab07;

import java.util.ArrayList;

/**
 * Description: A class that emulates the functionality of a cash register
 *
 * @author gag014
 * @version 0.01
 */
public class CashRegister {

    /**
     * The name of the cash drawer
     */
    private String sName;

    /**
     * The amount of cash in the drawer
     */
    private double cashAmount;

    /**
     * Are we currently in a transaction?
     */
    private boolean isInTransaction;

    /**
     * The total amount of the transaction
     */
    private double transTotal;

    /**
     * The total number of items purchased in this transaction so far
     */
    private int items = 0;

    /**
     * The total amount of money collected toward the transaction
     */
    private double amountPaid;

    /**
     * The array list of double that stores every item purchased during the day
     */
    private ArrayList<Double> itemList = new ArrayList<>();

    /**
     * A count for the total amount of successful transactions
     */
    private int transactions;

    /**
     * Initializes a default, empty cash register
     */
    public CashRegister() {
        this.cashAmount = 0;
        this.isInTransaction = false;
        this.transTotal = 0;
        this.items = 0;
        this.amountPaid = 0;
        this.sName = "Default";
        this.itemList = new ArrayList<>();
        this.transactions = 0;
    }

    /**
     * Initializes an empty cash register with a specified name
     *
     * @param sName - the name of the register
     */
    public CashRegister(String sName) {
        this();
        this.sName = sName;
    }

    /**
     * Initializes cash at beginning of the day in register
     *
     * @param initCash
     */
    public void startDay(double initCash) {
        this.cashAmount = initCash;
        this.itemList = new ArrayList<>();
        this.transactions = 0;
    }

    /**
     * Sets cash in register to 0 and returns cash from the day
     *
     * @return cash gained in the day
     */
    public double finishDay() {
        double temp;
        temp = this.cashAmount;
        this.cashAmount = 0;
        return temp;
    }

    /**
     * Allows for transactions to start
     *
     * @return boolean
     */
    public boolean startTransaction() {
        if (this.cashAmount > 0 && isInTransaction == false) {
            this.isInTransaction = true;
            return true;
        }
        return false;
    }

    /**
     * Allows for the end of a transaction
     *
     * @return boolean
     */
    public boolean finishTransaction() {
        if (isInTransaction == true && transTotal <= this.amountPaid) {
            if (this.amountPaid > this.transTotal) {
                double temp = this.amountPaid - this.transTotal;
                this.cashAmount = this.cashAmount - temp;
                this.amountPaid = this.transTotal;
            }
            this.isInTransaction = false;
            this.items = 0;
            this.amountPaid = 0;
            this.transTotal = 0;
            this.transactions++;
            return true;
        }
        return false;
    }

    /**
     * Adds item price to transaction total and increases item count by 1
     *
     * @param itemPrice - price of item
     */
    public void scanItem(double itemPrice) {
        this.transTotal += itemPrice;
        this.items++;
        this.itemList.add(itemPrice);
    }

    /**
     * Gets the number of items sold today
     *
     * @return The amount of items that were sold today
     */
    public int getNumItemsToday() {
        return this.itemList.size();
    }

    /**
     * Gets transaction total
     *
     * @return transaction total
     */
    public double getTransactionTotal() {
        return this.transTotal;
    }

    /**
     * A function that returns the average price of items purchased
     *
     * @return a double representing the average price of all items
     */
    public double getAveItemPurchasedToday() {
        double totalPrice = 0;

        for (double price : this.itemList) {
            totalPrice += price;
        }

        double averagePrice = totalPrice / (this.itemList.size());
        return (averagePrice);
    }

    /**
     * Returns the amount of items in transaction
     *
     * @return items
     */
    public int getNumItemsInTrans() {
        return this.items;
    }

    /**
     * Gets amount paid so far
     *
     * @return money given so far
     */
    public double getAmountPaid() {
        return this.amountPaid;
    }

    private String getName() {
        return this.sName;
    }

    /**
     * checks to see if currently in a transaction
     *
     * @return boolean
     */
    public boolean isInTransaction() {
        return this.isInTransaction;
    }

    /**
     * Returns the amount that is owed
     *
     * @return
     */
    public double getAmountOwed() {
        return -1 * (this.transTotal - this.amountPaid);
    }

    /**
     * sets a name to register
     *
     * @param name - new register name
     */
    public void setName(String name) {
        this.sName = name;
    }

    /**
     * To balance transaction amount
     *
     * @param pay - how much money is given at once
     * @return the difference
     */
    public double collectPayment(double pay) {
        this.cashAmount += pay;
        this.amountPaid += pay;

        return (-1 * (this.transTotal - this.amountPaid));
    }

    /**
     * A function to display the price of items purchased today
     */
    public void displayItemList() {
        System.out.printf("Item Log: %d items purchased today\n",
                          this.itemList.size());
        for (double itemPrice : this.itemList) {
            System.out.printf("$%.2f\n", itemPrice);
        }
    }

    /**
     * A function that returns the amount of successful transactions in the day
     *
     * @return integer amount of transactions
     */
    public int getNumTransToday() {
        return this.transactions;
    }

    /**
     * A function that returns the average price for each transaction
     *
     * @return double representing average price in each transaction
     */
    public double getAveTransToday() {
        double total = 0;
        for (double itemPrice : this.itemList) {
            total += itemPrice;
        }

        double average = total / this.transactions;
        return average;
    }

    @Override
    public String toString() {
        if (this.amountPaid > this.transTotal) {
            double temp = this.amountPaid - this.transTotal;
            this.cashAmount = this.cashAmount - temp;
            this.amountPaid = this.transTotal;
        }

        if (this.isInTransaction) {
            return this.sName + " drawer: $" + this.cashAmount + " CURRENT TRANS: items: " + this.items + ", total sale: " + this.transTotal + ", amount paid: " + this.amountPaid + "\n TODAY: #items: " + getNumItemsToday() + ", #trans: " + this.transactions;
        }

        else {
            return this.sName + ": " + "drawer: $" + this.cashAmount + " NOT IN TRANSACTION\n TODAY: #items: " + getNumItemsToday() + ", #trans: " + this.transactions;
        }
    }
}
