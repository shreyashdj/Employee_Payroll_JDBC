package com.bridgelabz.employeePayrollJDBC;

/**
 * @author - Shreyash Jadhav
 */
public class Main {
    public static void main(String[] args) {
        DatabaseConnection.connectToDatabase();
        DatabaseConnection.driversList();
    }
}