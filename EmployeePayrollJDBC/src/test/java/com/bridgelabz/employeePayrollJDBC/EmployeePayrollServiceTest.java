package com.bridgelabz.employeePayrollJDBC;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;

/**
 * @author - Shreyash Jadhav
 */
public class EmployeePayrollServiceTest {
    EmployeePayrollService employeePayrollService = new EmployeePayrollService();   // created object of class EmployeePayrollService
    /**
     *  Created setUP method which make connection to MySQl database
     */
    @BeforeEach
    public void setUP() {
        System.out.println("\n ********** Making Setup **********");
        DatabaseConnection.connectToDatabase();
        DatabaseConnection.driversList();
    }
    /**
     *  Created method to check count of data retrieved from database
     */
    @Test
    public void retrievedDataCountTest() {
        int actualResult = 0;
        try {
            actualResult = employeePayrollService.readEmployeePayrollData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(10, actualResult);
    }
    /**
     *  Created method to check updated salary is sync with database or not
     */
    @Test
    public void updatedSalaryTest() {
        String actualResult;
        try {
            employeePayrollService.updateBaseSalary("Terissa", 3000000);
            actualResult = employeePayrollService.readAnyColumnDataByEmployeeName("Terissa", "BasicPay");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals("3000000.0", actualResult);
    }
    /**
     *  Created tearDown method which close connection of MySQl database
     */
    @AfterEach
    public void tearDown() {
        try {
            DatabaseConnection.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n ********** Closed Connection **********");
    }
}