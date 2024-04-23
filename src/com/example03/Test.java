package com.example03;

public class Test {
    public static void main(String[] args) {
        Manager manager = new Manager("wkf", 5000, 2);
        Seller seller = new Seller("ljx", 3000, 20000, 0.15);

        double totalSalaries = SalaryService.getTotalSalaries(manager, seller);
        System.out.println("Total salaries: $" + totalSalaries);
    }
}

