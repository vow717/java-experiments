package com.example05.resource;
import com.example05.entity.*;
import java.util.ArrayList;
import java.util.List;
public class DatabaseUtils {
    private static List<Student> studentList=creatListStudents();
    public static List<Student> creatListStudents() {

    College C1=new College("计算机科学与技术");
    College C2=new College("软件工程");
    Teacher T1=new Teacher(001,"李莉",C2);
    Teacher T2=new Teacher(002,"董本志",C1);

    Student s1=new Student(2022001,"吴可凡",2022,T1);
    Student s2=new Student(2022002,"庞宇豪",2022,T1);
    Student s3=new Student(2022003,"孙天泽",2022,T2);
    Student s4=new Student(2022004,"刘俊杰",2022,T2);

    return List.of(s1,s2,s3,s4);
    }
    public static List<Student> getListStudents(){
        return studentList;
    }
}
