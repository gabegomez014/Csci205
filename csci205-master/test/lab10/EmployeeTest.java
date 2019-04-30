/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: -2/19/2017
 * Time: 1 PM
 *
 * Project: csci205
 * Package: lab10
 * File: Employeetest
 * Description: A test JUnit framwork for Employee class
 *
 * *******************************
 */
package lab10;

import java.text.ParseException;
import junit.framework.TestCase;

/**
 *
 * @author gag014
 */
public class EmployeeTest extends TestCase {

    private static Employee emp;

    public EmployeeTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        emp = new Employee(1, "Gabe", "Gomez", 123456789,
                           HRUtility.strToDate("2012-09-21"),
                           20000);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        emp = null;
    }

    /**
     * Test of changeName method, of class Employee.
     *
     * @throws java.text.ParseException
     */
    public void testChangeName() throws ParseException {
        System.out.println("changeName");
        String first = "Gomez";
        String last = "Gabe";
        Employee instance = new Employee(1, first, last, 123456789,
                                         HRUtility.strToDate("2012-09-21"),
                                         20000);

        //Test that the initial is the same
        assertEquals(instance, emp);

        //Test with a few declarations
        emp.changeName("John", "Bayern");
        instance.changeName("John", "Bayern");
        assertEquals(instance, emp);
    }

    /**
     * Test of raiseSalary method, of class Employee.
     *
     * @throws java.text.ParseException
     */
    public void testRaiseSalary() throws ParseException {
        System.out.println("raiseSalary");
        double salaryAdj = 0.0;
        Employee instance = new Employee(1, "Gabe", "Gomez", 123456789,
                                         HRUtility.strToDate("2012-09-21"),
                                         20000);

        //Test initial condition
        double expResult = 20000;
        double result = instance.raiseSalary(salaryAdj);
        assertEquals(expResult, result, 0.0);

        //Now, test after a few declarations
        salaryAdj = 5000;
        expResult = 25000;
        result = instance.raiseSalary(salaryAdj);
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Employee.
     *
     * @throws java.text.ParseException
     */
    public void testEquals() throws ParseException {
        System.out.println("equals");
        Employee instance = new Employee(1, "Gabe", "Gomez", 123456789,
                                         HRUtility.strToDate("2012-09-21"),
                                         20000);;
        boolean expResult = false;

        //Test initial condition
        assertEquals(emp, instance);

        //Test after few declarations with instance to ensure not equal
        instance.raiseSalary(5000);
        instance.changeName("John", "Bayern");

        expResult = instance.equals(emp);

        if (expResult == true) {
            assertEquals(instance, emp);
        }

        //Giving same declarations to emp
        emp.raiseSalary(5000);
        instance.changeName("John", "Bayern");
        assertEquals(emp, instance);
    }

}
