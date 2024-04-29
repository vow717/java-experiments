package com.example07.server;

import com.example07.entity.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicketOffice implements Runnable{
    private String name;
    private Railway buyFromRailway;
    private List<Ticket>tickets=new ArrayList<>();
    public TicketOffice(String name,Railway buyFromRailway){
        this.name=name;
        this.buyFromRailway=buyFromRailway;
    }
    public String getName(){
        return this.name;
    }
    public int getCount(){
        return tickets.size();
    }
    @Override
    public void run(){
        Random random=new Random();
        while(true){
            Ticket ticket=buyFromRailway.getTicket();
            if(ticket==null)
                break;
            else {
                this.tickets.add(ticket);
                try{
                    Thread.sleep(random.nextInt(50));
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("对不起,这里是"+this.name+"客服,该躺票已售空");
    }
}
