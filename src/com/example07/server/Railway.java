package com.example07.server;
import com.example07.entity.Ticket;
import java.util.*;

import java.util.*;
public class Railway {
    private List<Ticket>tickets;
    public Railway(){
        List<Ticket>ticketList=new ArrayList<>();
        for(int i=101;i<=300;i++)
            ticketList.add(new Ticket((int)i,"Haerbing","北京"));
        this.tickets=ticketList;
    }
    public int getCount(){
        return tickets.size();
    }
    public synchronized Ticket getTicket(){
        if(tickets.isEmpty())
            return null;
        else return tickets.remove(0);
    }
}
