package com.example06.entity;
import java.util.List;
import java.util.ArrayList;
public class cargoship {
    private int id;
    private String name;
    private double maxweight;
    private List<container>containers=new ArrayList<>();
    private double nowweight;
    public cargoship(int id,String name,double maxweight,double nowweight){
        this.id=id;
        this.name=name;
        this.maxweight=maxweight;
        this.nowweight=nowweight;
    }
    public String getName(){
        return this.name;
    }
    public void cargoLoadContainer (container container1)throws overweightException{
        if(nowweight+container1.getWeight()>maxweight){
            throw new overweightException(this.id,this.name,nowweight+container1.getWeight()-maxweight);
        }
        else{
            nowweight+=container1.getWeight();
            containers.add(container1);
        }
    }

}
