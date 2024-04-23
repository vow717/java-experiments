package com.example04.entity;

public class Student {
    private int id;
    private String name;
    private String gender;
    private int age;
    public Student(int id,String name,String gender,int age)
    {
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.age=age;
    }
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    public String getGender() {
        return this.gender;
    }
    public int getAge() {
        return this.age;
    }
}
