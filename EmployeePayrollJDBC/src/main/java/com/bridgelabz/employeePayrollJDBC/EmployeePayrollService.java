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
        /*
         *  created employeePayrollDataList (ArrayList)
         *  query to get all data employee_payroll table
         *  created preparedStatement by passing query
         *  created resultSet which store data after executeQuery
         *  using while loop iterate resultSet to get data and add it to employeePayrollDataList
         *  printing employeePayrollDataList and return size of employeePayrollDataList
         */
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
    /**
     *  Method to read any Column Data By EmployeeName
     */
    public String readAnyColumnDataByEmployeeName(String empName, String columnName) throws SQLException {
        /*
         *  passing parameters (String empName, String columnName)
         *  query to get data of any column by employee name
         *  created preparedStatement by passing query
         *  created resultSet which store data after executeQuery
         *  if resultSet contains any data, store it in result and return result
         */
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
     *  Method to update base salary of employee by name
     */
    public void updateBaseSalary(String empName, double salary) throws SQLException {
        /*
         *  passing parameters (String empName, double salary)
         *  query to update basePay of employee by its name
         *  created preparedStatement by passing query and calling executeUpdate method
         */
        String query = "update employee_payroll set BasicPay = ? where EmployeeName = ?";
        PreparedStatement preparedStatement = DatabaseConnection.connection.prepareStatement(query);
        preparedStatement.setDouble(1, salary);
        preparedStatement.setString(2, empName);
        preparedStatement.executeUpdate();
    }
}