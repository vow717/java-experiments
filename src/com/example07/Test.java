package com.example07;
import java.util.*;
import com.example07.entity.*;
import com.example07.server.*;
public class Test {
    public static void main(String[] args) {
        Railway R1=new Railway();
        TicketOffice T1=new TicketOffice("携程旅游",R1);
        TicketOffice T2=new TicketOffice("美团旅游",R1);
        TicketOffice T3=new TicketOffice("高德旅游",R1);
        Thread thread1=new Thread(T1);
        Thread thread2=new Thread(T2);
        Thread thread3=new Thread(T3);
        thread1.start();
        thread2.start();
        thread3.start();
        try{
            thread1.join();
            thread2.join();
            thread3.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(T1.getName()+"售出"+T1.getCount()+"张票");
        System.out.println(T2.getName()+"售出"+T2.getCount()+"张票");
        System.out.println(T3.getName()+"售出"+T3.getCount()+"张票");
        System.out.println("铁路处剩余"+R1.getCount()+"张票");

    }
}
