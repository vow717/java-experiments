package com.example03;

public class SalaryService {
    public static double getTotalSalaries(Workable... employees) {
        double totalSalaries = 0;
        for (Workable employee : employees) {
            totalSalaries += employee.calculateSalary();
        }
        return totalSalaries;
    }
}

