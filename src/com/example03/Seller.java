package com.example03;

public class Seller extends Employee{
    private double salesAmount;
    private double commissionRate;
    public Seller(String name,double baseSalary,double salesAmount,double commissionRate)
    {
        super(name,baseSalary);
        this.salesAmount=salesAmount;
        this.commissionRate=commissionRate;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary()+salesAmount*commissionRate;
    }
}
