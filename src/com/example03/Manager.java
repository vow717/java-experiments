package com.example03;

public class Manager extends Employee{
    private int level;
    public Manager(String name, double baseSalary, int level) {
        super(name, baseSalary);
        this.level = level;
    }
    @Override
    public double calculateSalary() {
        return super.calculateSalary() * level * 0.8;
    }
}
