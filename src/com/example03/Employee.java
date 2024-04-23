package com.example03;
public class Employee implements Workable {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    @Override
    public void updateName(String newName) {
        this.name = newName;
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}

