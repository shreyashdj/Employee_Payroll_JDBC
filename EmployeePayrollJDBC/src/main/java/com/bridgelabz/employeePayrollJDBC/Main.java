package com.bridgelabz.employeePayrollJDBC;

import java.sql.SQLException;

/**
 * @author - Shreyash Jadhav
 */
public class Main {
    public static void main(String[] args) {
        DatabaseConnection.connectToDatabase();
        DatabaseConnection.driversList();
        try {
            EmployeePayrollService employeePayrollService = new EmployeePayrollService();
            employeePayrollService.readEmployeePayrollData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}