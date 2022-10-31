package com.bridgelabz.employeePayrollJDBC;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author - Shreyash Jadhav
 */
public class EmployeePayrollService {
    /**
     *  Method to get all employee payroll data
     */
    public int readEmployeePayrollData() throws SQLException {
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        String query = "select * from employee_payroll";
        PreparedStatement preparedStatement = DatabaseConnection.connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int employeeId = resultSet.getInt("EmployeeID");
            String name = resultSet.getString("EmployeeName");
            int salary = resultSet.getInt("BasicPay");
            Date startDate = resultSet.getDate("StartDate");
            employeePayrollDataList.add(new EmployeePayrollData(employeeId, name, salary, startDate));
        }
        System.out.println("\n ****** Data of All Employees from employee_payroll table ***** \n");
        employeePayrollDataList.forEach(System.out::println);
        return employeePayrollDataList.size();
    }
    public String readAnyColumnDataByEmployeeName(String empName, String columnName) throws SQLException {
        String query = "select " + columnName + " from employee_payroll where EmployeeName = ?";
        PreparedStatement preparedStatement = DatabaseConnection.connection.prepareStatement(query);
        preparedStatement.setString(1, empName);
        ResultSet resultSet = preparedStatement.executeQuery();
        String result = null;
        if (resultSet.next()) {
            result = resultSet.getString(columnName);
        }
        return result;
    }
    /**
     *  Method to update base salary of employee
     */
    public void updateBaseSalary(String name, double salary) throws SQLException {
        String query = "update employee_payroll set BasicPay = ? where EmployeeName = ?";
        PreparedStatement preparedStatement = DatabaseConnection.connection.prepareStatement(query);
        preparedStatement.setDouble(1, salary);
        preparedStatement.setString(2, name);
        preparedStatement.executeUpdate();
    }
}