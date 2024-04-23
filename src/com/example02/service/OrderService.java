package com.example02.service;
import java.util.ArrayList;
import java.util.List;
import com.example02.entity.*;


public class OrderService {
    public static Order addOrder(User user, List<Item> items) {
        double totalCost = calculateTotalCost(items);
        if (user.getBalance() >= totalCost) {
            user.setBalance(user.getBalance() - totalCost);
            return new Order(user, items, totalCost);
        } else {
            return null;
        }
    }

    private static double calculateTotalCost(List<Item> items) {
        double totalCost = 0;
        for (Item item : items) {
            totalCost += item.getProduct().getPrice() * item.getQuantity();
        }
        return totalCost;
    }
}
