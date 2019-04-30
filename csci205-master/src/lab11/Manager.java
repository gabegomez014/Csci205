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
 * File: Manager
 * Description: A class for a manager that inherits from Employee
 *
 * *******************************
 */
package lab11;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum DeptType {
    ENGINEERING("ENGINEERING"),
    HR("HR"),
    ADMIN("ADMIN"),
    STAFF("STAFF"),
    OTHER("OTHER");

    private String dept;

    DeptType(String dept) {
        this.dept = dept;
    }

    public DeptType getDept() {
        return DeptType.valueOf(this.dept);
    }

    public void setDept(DeptType deptName) {
        this.dept = deptName.toString();
    }

}

public class Manager extends Employee {

    private DeptType dept;
    private List<Employee> employees;

    /**
     * Constructor of the Manager class
     *
     * @param empID
     * @param firstName
     * @param lastName
     * @param ssNum
     * @param hireDate
     * @param salary
     * @param dept
     */
    public Manager(int empID, String firstName, String lastName, int ssNum,
                   Date hireDate, double salary, String dept) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.dept = DeptType.valueOf(dept);
        this.employees = new ArrayList<Employee>();
    }

    /**
     * Constructor of manager class with DeptType as identifier for dept
     *
     * @param empID
     * @param firstName
     * @param lastName
     * @param ssNum
     * @param hireDate
     * @param salary
     * @param dept
     */
    Manager(int empID, String firstName, String lastName, int ssNum,
            Date hireDate, double salary, DeptType dept) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.dept = dept;
        this.employees = new ArrayList<Employee>();
    }

    /**
     * Get the value of dept
     *
     * @return the value of dept
     */
    public String getDeptName() {
        return this.dept.toString();
    }

    /**
     * Set the value of dept
     *
     * @param deptName new value of dept
     * @return
     */
    public void setDeptName(String deptName) {

        this.dept = DeptType.valueOf(deptName);
    }

    /**
     * Adds employees of the manager class to managers list
     *
     * @param emp
     * @throws ManagerException
     */
    public void addEmployee(Employee emp) throws ManagerException {

        if (employees.contains(emp)) {
            throw new ManagerException("Already in the list of employees");
        }

        else {
            employees.add(emp);
        }

    }

    /**
     * Lists all employees within the list
     *
     * @return list of employees
     */
    public List<Employee> getEmpList() {
        return this.employees;
    }

    /**
     * Removes employee that is within parameter if they are in the list
     *
     * @param emp
     * @throws ManagerException
     */
    public void removeEmployee(Employee emp) throws ManagerException {
        if (!(employees.contains(emp))) {
            throw new ManagerException("Not within employees");
        }

        else {
            employees.remove(emp);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ",MANAGER," + this.getDeptName();
    }

}
