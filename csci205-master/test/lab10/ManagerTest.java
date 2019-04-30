/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: $(date)
 * Time: $(time)
 *
 * Project: $(project.name)
 * Package: $(package)
 * File: $(name)
 * Description:
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
public class ManagerTest extends TestCase {

    private static Manager mgr;
    private static Employee emp;
    private static Manager test;

    public ManagerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mgr = new Manager(0, "John", "Cena", 000000001,
                          HRUtility.strToDate("2002-06-23"),
                          10000000, "HR");

        emp = new Employee(1, "Gabe", "Gomez", 123456789,
                           HRUtility.strToDate("2012-09-21"),
                           20000);

        test = new Manager(0, "John", "Cena", 000000001,
                           HRUtility.strToDate("2002-06-23"),
                           10000000, "HR");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        mgr = null;
        emp = null;
    }

    /**
     * Test of addEmployee method, of class Manager.
     *
     * @throws java.lang.Exception
     */
    public void testAddEmployee() throws Exception {
        System.out.println("addEmployee");

        //test intial start
        assertEquals(mgr, test);

        //Test after a few declarations
        mgr.addEmployee(emp);
        assertEquals(mgr, test);

    }

    /**
     * Test of getEmpList method, of class Manager.
     *
     * @throws java.text.ParseException
     */
    public void testGetEmpList() throws ParseException, ManagerException {
        System.out.println("getEmpList");
        Employee emp2 = new Employee(2, "Goofy", "Goober", 010223214,
                                     HRUtility.strToDate("1197-04-12"),
                                     2506823);

        //Test initial
        assertEquals(test, mgr);

        //Test after a few declarations
        mgr.addEmployee(emp);
        test.addEmployee(emp2);
        assertEquals(mgr, test);
    }

    /**
     * Test of removeEmployee method, of class Manager.
     *
     * @throws java.lang.Exception
     */
    public void testRemoveEmployee() throws Exception {
        System.out.println("removeEmployee");

        //Test initial
        assertEquals(test, mgr);

        //Test after a few declarations
        mgr.addEmployee(emp);
        test.removeEmployee(emp);
        assertEquals(test, mgr);
    }

    public void testAddEmpoloyeeException() throws ManagerException {
        System.out.println("addEmployeeException");

        //Test initial
        assertEquals(test, mgr);

        //test after a few declarations
        mgr.addEmployee(emp);

        try {
            mgr.addEmployee(emp);
            fail("Added an employee who is there");
        } catch (ManagerException e) {
        }
    }

    public void testRemoveEmployeeException() throws ManagerException {
        System.out.println("removeEmployeeException");

        //Test Initial
        assertEquals(test, mgr);

        //Test after a few declarations
        mgr.addEmployee(emp);
        test.removeEmployee(emp);

        try {
            test.removeEmployee(emp);
            fail("Removing someone not there");
        } catch (ManagerException e) {
        }
    }
}
