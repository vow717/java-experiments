package com.example01;

public class userText {
    public static void main(String[] args){
        var user1=new User("pyh");
        System.out.println(user1.getName());
        user1.setName("wkf");
        System.out.println(user1.getName());
    }

}
