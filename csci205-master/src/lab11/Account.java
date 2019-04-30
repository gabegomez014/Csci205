/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 02/23/2017
 * Time: 1 PM
 *
 * Project: csci205
 * Package: lab11
 * File: Account
 * Description: A test file for Payable interface
 *
 * *******************************
 */
package lab11;

/**
 *
 * @author Gabe Gomez
 */
class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class Account {

    private double balance;

    /**
     * Constructor for the Account class
     *
     * @param initBalance
     */
    public Account(double initBalance) {
        this.balance = initBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Adds the amount to the balance
     *
     * @param amount
     */
    public void credit(double amount) {
        this.balance += amount;
    }

    /**
     * Takes the amount out of the balance
     *
     * @param amount
     * @throws InsufficientFundsException
     */
    public void debit(double amount) throws InsufficientFundsException {
        if (this.getBalance() < amount) {
            throw new InsufficientFundsException(
                    "Sorry, but you do not have sufficient funds for the amount you asked for.");
        }

        this.balance -= amount;
    }

    /**
     * Creates a proper check for payee
     *
     * @param payee
     * @param hoursBilled
     * @throws InsufficientFundsException
     */
    public void processCheck(Payable payee, double hoursBilled) throws InsufficientFundsException {
        String str = String.format("Check made out to %s\nAmount: %.2f\n%s",
                                   payee.getPayTo(), payee.calculatePay(
                                   hoursBilled), payee.getPayMemo());

        this.debit(payee.calculatePay(hoursBilled));
        System.out.println(str);
    }

    @Override
    public String toString() {
        return String.format("Account: %.2f\n", this.getBalance());
    }

}
