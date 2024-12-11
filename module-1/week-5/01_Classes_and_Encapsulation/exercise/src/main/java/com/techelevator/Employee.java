package com.techelevator;

public class Employee {

    //Instance Variables
    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private double annualSalary;

    //Getters
    public int getEmployeeId() {
        return this.employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.lastName + ", " + firstName;
    }

    public String getDepartment() {
        return this.department;
    }

    public double getAnnualSalary() {
        return this.annualSalary;
    }

    //Setters
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //Constructor
    public Employee(int employeeId, String firstName, String lastName, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = salary;
    }

    //Method
    public void raiseSalary(double percent) {
        double newSalary = annualSalary + ((annualSalary * percent) / 100);
        annualSalary = newSalary;
    }


}
