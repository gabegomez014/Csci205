/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2016
 *
 * Name: Gabe Gomez
 * Date: 02/19/2017
 * Time: 1 PM
 *
 * Project: csci205
 * Package: lab10
 * File: Employee
 * Description:
 * A very basic abstraction for an employee in a simple HR system
 * ****************************************
 */
package lab10;

/**
 * A basic representation for an Employee.
 *
 * @author Gabe Gomez
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/**
 * Employee - represents an employee in the database system
 *
 * @author brk009
 */
public class Employee {


    private int empID;
    private String firstName;
    private String lastName;
    private int ssNum;
    private Date hireDate;
    private double salary;
    private static HashSet<Integer> setOfIDs = new HashSet<Integer>();

    private static Integer generateID() {
        int id = 1;

        if (!setOfIDs.contains(id)) {
            return id;
        }

        while (setOfIDs.contains(id)) {
            id++;
        }

        return id;
    }

    /**
     * Explicit construct to create new employee
     *
     * @param empID
     * @param firstName
     * @param lastName
     * @param ssNum
     * @param hireDate
     * @param salary
     */
    public Employee(int empID, String firstName, String lastName, int ssNum,
                    Date hireDate, double salary) {
        this.empID = empID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssNum = ssNum;
        this.hireDate = hireDate;
        this.salary = salary;

        if (setOfIDs.contains(this.empID) || this.empID <= 0) {
            this.empID = generateID();
        }
        setOfIDs.add(this.empID);
    }

    public int getEmpID() {
        return empID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSsNum() {
        return ssNum;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public double getSalary() {
        return salary;
    }

    /**
     * Change the name of the employee
     *
     * @param first - New first name
     * @param last - New last name
     */
    public void changeName(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    /**
     * Raise the salary by <code>salaryAdj</code> dollars.
     *
     * @param salaryAdj - amount to add to the current salary
     * @return the new salary
     */
    public double raiseSalary(double salaryAdj) {
        this.salary += salaryAdj;
        return this.salary;
    }


    /**
     * Return a string representation of the Employee
     *
     * @return the String of comma delimited values
     */
    @Override
    public String toString() {
        String s = this.empID + "," + this.lastName + "," + this.firstName;
        s += String.format(",%09d", this.ssNum);
        s += "," + HRUtility.dateToStr(this.hireDate);
        s += String.format(",%.2f", this.salary);
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.ssNum != other.ssNum) {
            return false;
        }
        return true;
    }

}
