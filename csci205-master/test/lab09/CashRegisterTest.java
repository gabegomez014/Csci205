/* ******************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Gabe Gomez
 * Date: 02/17/2017
 * Time: 1 PM
 *
 * Project: CashRegisterTest.Gabe
 * Package: lab09
 * File: CashRegisterTest.java
 * Description: A JUnit framework test for CashRegister
 *
 * *******************************
 */
package lab09;

import java.util.LinkedList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author gag014
 */
public class CashRegisterTest extends TestCase {

    static final double EPSILON = 1.0E-12;

    private CashRegister instance;

    public CashRegisterTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        instance = new CashRegister();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        instance = null;
    }

    /**
     * Test of getPurchaseCount method, of class CashRegister.
     */
    public void testGetPurchaseCount() {
        System.out.println("getPurchaseCount");

        // Test the initial state. It should have NO items
        assertEquals(0, instance.getPurchaseCount());

        //Now, set up a test of 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        int expResult = 2;
        int result = instance.getPurchaseCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListOfPurchases method, of class CashRegister.
     */
    public void testGetListOfPurchases() {
        System.out.println("getListOfPurchases");
        LinkedList<Double> expList;
        expList = new LinkedList<Double>();
        List<Double> result = instance.getListOfPurchases();

        // Test inital state
        assertEquals(expList, result);

        // Now, test with 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        expList.add(0.55);
        expList.add(1.27);
        assertEquals(expList, result);
    }

    /**
     * Test of getTransactionTotal method, of class CashRegister.
     */
    public void testGetTransactionTotal() {
        System.out.println("getTransactionTotal");
        assertEquals(0, instance.getTransactionTotal(), EPSILON);

        // Now, set up a test of 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        double expResult = 1.82;
        double result = instance.getTransactionTotal();
        assertEquals(expResult, result, EPSILON);
    }

    /**
     * Test of getPaymentCollected method, of class CashRegister.
     */
    public void testGetPaymentCollected() {
        System.out.println("getPaymentCollected");
        double expResult = 0.0;
        double result = instance.getPaymentCollected();
        assertEquals(expResult, result, 0.0);

        // Now, test with 3 items
        instance.collectPayment(Money.DOLLAR, 1);
        instance.collectPayment(Money.QUARTER, 3);
        instance.collectPayment(Money.NICKEL, 2);
        expResult = 1.85;
        result = instance.getPaymentCollected();
        assertEquals(expResult, result, EPSILON);
    }

    /**
     * Test of giveChange method, of class CashRegister.
     *
     * @throws java.lang.Exception
     */
    public void testGiveChange() throws Exception {
        System.out.println("giveChange");
        double expResult = 0.0;
        double result = instance.giveChange();
        assertEquals(expResult, result, 0.0);

        // Now, test with a few items
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        instance.collectPayment(Money.DOLLAR, 1);
        instance.collectPayment(Money.QUARTER, 3);
        instance.collectPayment(Money.NICKEL, 2);
        result = instance.giveChange();
        expResult = 0.03;
        assertEquals(expResult, result, EPSILON);
    }

    /**
     * Test for seeing if exceptions are handled correctly.
     */
    public void testScanItemIllegalArgumentException() {
        boolean wasThrown = false;
        try {
            instance.scanItem(-0.5);
            fail("Improper checking for low scanItem()");
        } catch (IllegalArgumentException expected) {
        }
        try {
            // Now, let's scan for a large value
            instance.scanItem(1.0E6);
            fail("Improper checking for high scanItem()");
        } catch (IllegalArgumentException expected) {
        }
    }

    /**
     * A test for checking if the Exception in collect payment works correctly
     */
    public void testCollectPaymentException() {
        boolean wasThrown = false;

        try {
            instance.collectPayment(Money.TWENTY, -1);
            fail("Improper checking for negative unitCount");
        } catch (IllegalArgumentException expected) {
        }
    }

    public void testGiveChangeException() {
        // Now, test with a few items
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        instance.collectPayment(Money.DOLLAR, 1);
        instance.collectPayment(Money.QUARTER, 3);

        try {
            instance.giveChange();
            fail("Improper check for having collected less than transaction total");

        } catch (ChangeException changeException) {
        }
    }

    public void testEquals() {
        CashRegister test;
        test = new CashRegister();
        boolean bool = true;

        // Test that the initital is the same
        assertEquals(instance, test);

        // Now, test if the same
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        instance.collectPayment(Money.DOLLAR, 1);
        instance.collectPayment(Money.QUARTER, 3);
        instance.collectPayment(Money.NICKEL, 2);

        // To see if the instances are the same
        bool = instance.equals(test);

        if (bool == true) {
            assertEquals(instance, test);
        }

        // Adding to the test instance
        test.scanItem(0.55);
        test.scanItem(1.27);
        test.collectPayment(Money.DOLLAR, 1);
        test.collectPayment(Money.QUARTER, 3);
        test.collectPayment(Money.NICKEL, 2);

        assertEquals(instance, test);
    }
}
