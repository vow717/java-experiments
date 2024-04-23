package com.example05.entity;

public class Student {
    private int id;
    private String name;
    private int year;
    private Teacher teacher;
    public Student(int id,String name,int year,Teacher teacher){
        this.id=id;
        this.name=name;
        this.year=year;
        this.teacher=teacher;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
