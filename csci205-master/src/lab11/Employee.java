/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2016
 *
 * Name: Gabe Gomez
 * Date: 02/20/2017
 * Time: 1 PM
 *
 * Project: csci205
 * Package: lab11
 * File: Employee
 * Description:
 * A very basic abstraction for an employee in a simple HR system
 * ****************************************
 */
package lab11;

/**
 * A basic representation for an Employee.
 *
 * @author Gabe Gomez
 */
import java.util.Date;
import java.util.HashSet;

/**
 * Employee - represents an employee in the database system
 *
 * @author brk009
 */
enum SortType {
    SORT_BY_LASTNAME,
    SORT_BY_ID;
}

public class Employee implements Payable, Comparable<Employee> {

    private static HashSet<Integer> setOfIDs = new HashSet<Integer>();
    private static SortType sortType = SortType.SORT_BY_ID;

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

    public static void setSortType(SortType type) {
        sortType = type;
    }

    private int empID;
    private String firstName;
    private String lastName;
    private int ssNum;
    private Date hireDate;
    private double salary;

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

    /**
     * A method that calculates the pay of an employee by their hours for that
     * current week.
     *
     * @param numHrs
     * @return double representing gross pay of employee
     */
    @Override
    public double calculatePay(double numHrs) {
        double workWk = 40;            //The hours expected to work in a week
        double weeksInYear = 52;        //The amount of weeks in a year

        double hrsPerYear = workWk * weeksInYear;           //This is how many hours worked in a yaer if on a 40 hour work week
        double hrlyRate = this.getSalary() / hrsPerYear;    //Salary is the amount paid in a year based off a 40 hour work week for all weeks of the year

        if (numHrs > workWk) {
            double difference = numHrs - workWk;
            while (difference != 0) {
                hrlyRate *= 1.5;
                difference--;
            }
        }

        double pay = hrlyRate * numHrs;
        return pay;
    }

    /**
     * A method that gets the name of the person being paid
     *
     * @return String with first and last name of employee
     */
    @Override
    public String getPayTo() {
        return String.format("%s %s", this.getFirstName(), this.getLastName());
    }

    /**
     * Gives memo of employee being paid
     *
     * @return String of information
     */
    @Override
    public String getPayMemo() {
        Date today = new Date();
        return String.format(" Employee ID: %d, Pay Date: %s\n",
                             this.getEmpID(), HRUtility.dateToStr(today));
    }

    @Override
    public int compareTo(Employee emp) {
        if (sortType == SortType.SORT_BY_LASTNAME) {
            return this.getLastName().compareTo(emp.getLastName());
        }

        else {
            return Integer.compare(this.getEmpID(), emp.getEmpID());
        }
    }

}
