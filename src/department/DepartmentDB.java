/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package department;

import model.*;

/**
 *
 * @author nattanon
 */
public class DepartmentDB {
    public static void main(String[] args) {
        Department IT = new Department(1,"IT");
        Department HR = new Department(2,"HR");
        
        DepartmentTable.insertDepartment(IT);
        DepartmentTable.insertDepartment(HR);
        
        Employee emp1 = new Employee(1,"John","Network Admin",56789,IT);
        Employee emp2 = new Employee(2,"Mary","HR manager",56789,HR);
        Employee emp3 = new Employee(3,"Henry","Programmer",56789,IT);
        Employee emp4 = new Employee(4,"Clack","HR recruiter",56789,HR);
        
        EmployeeTable.insertEmployee(emp1);
        EmployeeTable.insertEmployee(emp2);
        EmployeeTable.insertEmployee(emp3);
        EmployeeTable.insertEmployee(emp4);
        
        
    }
}
