/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 02/19/2017
 * Time: 1 PM
 *
 * Project: csci205
 * Package: lab10
 * File: HRUtility
 * Description: A series of methods that is useful in many classes
 *
 * *******************************
 */
package lab10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gabe Gomez
 */
public final class HRUtility {

    private static SimpleDateFormat empDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd");

    /**
     * Prints status of employee entered
     *
     * @param emp
     */
    public static void displayEmployee(Employee emp) {

        if (emp instanceof Manager) {
            System.out.println(
                    emp.getEmpID() + ": " + emp.getFirstName() + " " + emp.getLastName() + "[MANAGER]\n");
            return;
        }

        System.out.println(
                emp.getEmpID() + ": " + emp.getFirstName() + " " + emp.getLastName() + "\n");
    }

    /**
     * Prints a list of the employees
     *
     * @param listOfEmployees
     */
    public static void displayEmployees(List<Employee> listOfEmployees) {
        int i;

        for (i = 0; i < listOfEmployees.size(); i++) {
            displayEmployee(listOfEmployees.get(i));
        }
    }

    /**
     * Helper method to parse a date string into a date object. This is really
     * here just to show how to deal with an exception that may be thrown in a
     * method.
     *
     * @param sDate - a date string
     * @return a <code>Date</code> object
     * @throws ParseException if the string cannot be parse correctly.
     */
    public static Date strToDate(String sDate) throws ParseException {
        return empDateFormat.parse(sDate);
    }

    /**
     *
     * @param date the value of date
     * @return The date in specified format
     */
    public static String dateToStr(Date date) {
        return empDateFormat.format(date);
    }

    public static void displayManager(Manager mgr) {
        String manager = String.format("Manager: %s %s\n", mgr.getFirstName(),
                                       mgr.getLastName());

        manager += String.format("Department : %s\n", mgr.getDeptName());
        manager += String.format("# Employees : %d\n", mgr.getEmpList().size());

        System.out.println(manager);

        displayEmployees(mgr.getEmpList());

    }

}
