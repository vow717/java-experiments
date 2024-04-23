package com.example02;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.example02.entity.*;
import com.example02.service.*;
public class Textmain {
    public static void main(String[] args) {
        Product product1 = new Product("apple", 100);
        Product product2 = new Product("banana", 120);
        User user = new User("wkf", 1000, "abcd");

        Item item1 = new Item(product1, 2); // 买1个苹果
        Item item2 = new Item(product2, 1); // 买2个香蕉

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        Order order = OrderService.addOrder(user, items);

        // 检查订单是否创建成功
        if (order != null) {
            // 订单创建成功，打印订单详情
            System.out.println("订单创建成功！");
            System.out.println("商品总额: " + order.getTotalCost());
            System.out.println("用户余额: " + user.getBalance());
            System.out.println("快递地址: " + user.getAddress());
        } else {
            // 订单创建失败，打印用户余额不足
            System.out.println("用户余额不足！");
        }
    }
}
