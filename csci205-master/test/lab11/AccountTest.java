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
package lab11;

import junit.framework.TestCase;

/**
 *
 * @author gag014
 */
public class AccountTest extends TestCase {

    private Employee emp;
    private Employee empInstance;
    private Account act;
    private Account actInstance;

    public AccountTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        act = new Account(50000);
        emp = new Employee(1, "Gabe", "Gomez", 123456789,
                           HRUtility.strToDate("2012-09-21"),
                           20000);
        empInstance = new Employee(1, "Gabe", "Gomez", 123456789,
                                   HRUtility.strToDate("2012-09-21"),
                                   20000);
        actInstance = new Account(50000);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        act = null;
        emp = null;
    }

    /**
     * Test of credit method, of class Account.
     */
    public void testCredit() {
        System.out.println("credit");

        act.credit(100);
        actInstance.credit(100);
        assertEquals(act.getBalance(), actInstance.getBalance());
    }

    /**
     * Test of debit method, of class Account.
     */
    public void testDebit() throws Exception {
        System.out.println("debit");

        act.debit(5213);
        actInstance.debit(5213);
        assertEquals(actInstance.getBalance(), act.getBalance());
    }

    /**
     * Test of processCheck method, of class Account.
     */
    public void testProcessCheck() throws Exception {
        System.out.println("processCheck");
        Payable payee = emp;
        double hoursBilled = 40;

        actInstance.processCheck(payee, hoursBilled);
        act.processCheck(payee, hoursBilled);

        assertEquals(act.getBalance(), act.getBalance());
    }

    public void testProcessCheckInsufficientFundsException() throws Exception {
        try {
            act.debit(6000000);
            fail("Taking out more than you actually can");
        } catch (InsufficientFundsException e) {
        }
    }

}
