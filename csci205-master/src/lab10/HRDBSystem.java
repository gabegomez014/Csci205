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
 * File: HRDBSystem
 * Description: A HR database system that instantiates an employee and a manager
 *
 * *******************************
 */
package lab10;

import java.text.ParseException;
import java.util.ArrayList;
import static lab10.HRUtility.displayManager;

/**
 *
 * @author Gabe Gomez
 */
public class HRDBSystem {

    private static ArrayList<Employee> employees = new ArrayList();
    private static ArrayList<Manager> managers1 = new ArrayList();
    private static ArrayList<Manager> managers2 = new ArrayList();

    /**
     * Main method for testing Employee and Manager
     *
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException, ManagerException {
        Manager mgr1 = new Manager(0, "John", "Cena", 000000001,
                                   HRUtility.strToDate("2002-06-23"),
                                   10000000, "HR");

        Manager mgr2 = new Manager(1, "Keith", "Buffinton", 00010101,
                                   HRUtility.strToDate("2001-03-14"), 15000,
                                   "ENGINEERING");

        Employee emp1 = new Employee(1, "Gabe", "Gomez", 123456789,
                                     HRUtility.strToDate("2012-09-21"),
                                     20000);

        Employee emp2 = new Employee(2, "Goofy", "Goober", 010223214,
                                     HRUtility.strToDate("1197-04-12"),
                                     2506823);

        Employee emp3 = new Employee(201, "Ben", "John", 728394857,
                                     HRUtility.strToDate("2017-01-21"),
                                     2093785);

        Employee emp4 = new Employee(4, "Star", "Destroyer", 216253224,
                                     HRUtility.strToDate("1990-03-08"),
                                     15000);

        Employee emp5 = new Employee(0, "Obi-Wan", "Kenobi", 425486780,
                                     HRUtility.strToDate("2001-01-10"),
                                     1002937);

        Employee emp6 = new Employee(200, "Jake", "Simon", 123401929,
                                     HRUtility.strToDate("2005-04-11"),
                                     73836);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
        employees.add(emp6);

        mgr1.addEmployee(emp1);
        mgr1.addEmployee(emp2);
        mgr1.addEmployee(emp3);

        displayManager(mgr1);

        mgr2.addEmployee(emp6);
        mgr2.addEmployee(emp5);
        mgr2.addEmployee(emp4);

        displayManager(mgr2);
        //displayEmployees(employees);
    }
}
