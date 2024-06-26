package com.example05.entity;

public class Teacher {
    private int id;
    private String name;
    private College college;

    public Teacher(int id,String name,College college)
    {
        this.id=id;
        this.name=name;
        this.college=college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }
}
