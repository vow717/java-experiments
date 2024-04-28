package com.example06;
import java.util.*;
import com.example06.entity.*;
import com.example06.load.Loading;
public class Test {
    public static void main(String[] args){
        cargoship ship1=new cargoship(001,"飞翔号",1500,0);
        cargoship ship2=new cargoship(002,"远行号",1000,0);
        List<container>containers=new ArrayList<>();
        containers.add(new container(11111,200));
        containers.add(new container(22222,300));
        containers.add(new container(33333,400));
        containers.add(new container(44444,200));
        containers.add(new container(55555,200));
       try {
           Loading.loadService(ship2, containers);
           System.out.println(ship2.getName()+"未超重");
       }catch (overweightException o){
           o.printException();
       }finally {
           System.out.println("启航!");
       }

        try {
            Loading.loadService(ship1, containers);
            System.out.println("货船名称:"+ship1.getName()+"货船状态:"+"未超重");
        }catch (overweightException o){
            o.printException();
        }finally {
            System.out.println("启航!");
        }

    }
}
