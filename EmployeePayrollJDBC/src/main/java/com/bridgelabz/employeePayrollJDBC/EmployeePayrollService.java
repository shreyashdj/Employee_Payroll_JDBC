package com.bridgelabz.employeePayrollJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author - Shreyash Jadhav
 */
public class EmployeePayrollService {
    /**
     *  Method to get all employee payroll data
     */
    public static void readEmployeePayrollData(Connection connection) throws SQLException {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee_payroll");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("\n *********************************");
                System.out.println("\n EmployeeID   : " + resultSet.getString("EmployeeID"));
                System.out.println(" EmployeeName : " + resultSet.getString("EmployeeName"));
                System.out.println(" Address      : " + resultSet.getString("Address"));
                System.out.println(" PhoneNumber  : " + resultSet.getString("PhoneNumber"));
                System.out.println(" Department   : " + resultSet.getString("Department"));
                System.out.println(" Gender       : " + resultSet.getString("Gender"));
                System.out.println(" StartDate    : " + resultSet.getString("StartDate"));
                System.out.println(" BasicPay     : " + resultSet.getString("BasicPay"));
                System.out.println(" Deductions   : " + resultSet.getString("Deductions"));
                System.out.println(" TaxablePay   : " + resultSet.getString("TaxablePay"));
                System.out.println(" IncomeTax    : " + resultSet.getString("IncomeTax"));
                System.out.println(" NetPay       : " + resultSet.getString("NetPay"));
            }
        System.out.println("\n *********************************");
        }
}