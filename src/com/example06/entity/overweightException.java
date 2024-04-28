package com.example06.entity;

public class overweightException extends Exception{
    private int id;
    private String name;
    private double overweight;
    public overweightException(int id,String name,double overweight){
        this.id=id;
        this.name=name;
        this.overweight=overweight;
    }
    public void printException(){
        System.out.println("超重货船ID："+this.id);
        System.out.println("超重货船名称："+this.name);
        System.out.println("超重重量："+this.overweight);
    }
}
