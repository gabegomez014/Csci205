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
 * File: Contractor
 * Description: A contractor class
 *
 * *******************************
 */
package lab11;

import java.util.Date;

/**
 *
 * @author Gabe Gomez
 */
public class Contractor implements Payable {

    private int id;
    private String firstName;
    private String lastName;
    private int ssNum;
    private double hourlyRate;

    /**
     * Constructor of the Contractor class that implements Payable
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param ssNum
     * @param hourlyRate
     */
    public Contractor(int id, String firstName, String lastName, int ssNum,
                      double hourlyRate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssNum = ssNum;
        this.hourlyRate = hourlyRate;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSsNum() {
        return ssNum;
    }

    public void setSsNum(int ssNum) {
        this.ssNum = ssNum;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return String.format("Contractor: %d,%s,%s,%d,$%.2f", this.getID(),
                             this.getLastName(), this.getFirstName(),
                             this.getSsNum(), this.getHourlyRate());
    }

    /**
     * A method that calculates the pay for the contractor
     *
     * @param numHrs
     * @return double of pay
     */
    @Override
    public double calculatePay(double numHrs) {
        double pay = this.getHourlyRate() * numHrs;
        return pay;
    }

    /**
     * Get first and last name of contractor being paid
     *
     * @return String of first and last name
     */
    @Override
    public String getPayTo() {
        return String.format("%s %s", this.getFirstName(), this.getLastName());
    }

    /**
     * Gets Memo of the contractor being paid
     *
     * @return String of information
     */
    @Override
    public String getPayMemo() {
        Date today = new Date();
        return String.format("Contractor ID: %d, Pay Date: %s\n",
                             this.getID(), HRUtility.dateToStr(today));
    }

}
