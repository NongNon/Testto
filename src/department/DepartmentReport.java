/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package department;

import model.*;
import java.util.*;

/**
 *
 * @author nattanon
 */
public class DepartmentReport {
    public static void main(String[] args) {

        //print all employees
        System.out.println("All employee (by ID)");
        for (Employee employee : EmployeeTable.findAllEmployee()) {
            System.out.println("---------------------");
            System.out.println(employee);
            System.out.println("---------------------");
        }


        //print all employees in each department
        System.out.println("All employee (by Department)");
        for (Department department : DepartmentTable.findAllDepartment()) {
            System.out.println("---------------------");
            System.out.println(department);
            for (Employee employee : department.getEmployeeCollection()) {
                System.out.println("---------------------");
                System.out.println(employee);
                System.out.println("---------------------");
            }
        }

    }
}
