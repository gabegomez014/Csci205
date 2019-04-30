/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 02/20/2017
 * Time: 1 PM
 *
 * Project: csci205
 * Package: lab11
 * File: HRDBSystem
 * Description: A HR database system that instantiates an employee and a manager
 *
 * *******************************
 */
package lab11;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import static lab11.HRUtility.displayManager;

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
    public static void main(String[] args) throws ParseException, ManagerException, InsufficientFundsException {
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

        Contractor cont1 = new Contractor(73, "Joe", "Chillin", 182736478, 30.00);
        Contractor cont2 = new Contractor(21, "Tron", "Doober", 482432481, 40.00);
        //System.out.println(cont1);
        //System.out.println(cont2);
        emp1.raiseSalary(5000);
        emp1.changeName("Gomez", "Gabe");
        System.out.println(emp1);

        Account act = new Account(2000.0);
        System.out.println(act);
        try {
            System.out.println(
                    "TEST: Printing a check to employee id: " + employees.get(0).getEmpID());
            act.processCheck(employees.get(0), 30);
            System.out.println(
                    "TEST: Printing a check to contractor id: " + cont1.getID());
            act.processCheck(cont1, 35);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(act.getBalance());

        System.out.println("*** Employees BEFORE SORT ***");
        HRUtility.displayEmployees(employees);

        System.out.println("*** Employees AFTER SORT_BY_LASTNAME ***");
        Employee.setSortType(SortType.SORT_BY_LASTNAME);
        Collections.sort(employees);
        HRUtility.displayEmployees(employees);

        System.out.println("*** Employees AFTER_SORT_BY_ID");
        Employee.setSortType(SortType.SORT_BY_ID);
        Collections.sort(employees);
        HRUtility.displayEmployees(employees);

    }
}
