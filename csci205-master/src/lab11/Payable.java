/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 02/23/17
 * Time: 1 PM
 *
 * Project: csci205
 * Package: lab11
 * File: Payable
 * Description: An interface to be used by the employee and children class.
 *
 * *******************************
 */
package lab11;

/**
 *
 * @author Gabe Gomez
 */
public interface Payable {

    double calculatePay(double numHrs);

    String getPayTo();

    String getPayMemo();
}
