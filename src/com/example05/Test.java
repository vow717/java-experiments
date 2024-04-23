package com.example05;
import com.example05.entity.*;
import com.example05.resource.DatabaseUtils;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        System.out.println("索引为0的学生的老师所在学院为："+getCollegeName(DatabaseUtils.getListStudents().get(0)));
        System.out.println("索引为0的学生的老师名字是否是李丽:"+isTeacher(DatabaseUtils.getListStudents().get(0), "李丽"));
        System.out.println("学号为2022001的学生的老师所属学院为:"+getCollegeName(DatabaseUtils.getListStudents(),2022001));
        System.out.print("学生学号为2022003，老师编号为002的老师所属学院为:");
                printCollegeName(DatabaseUtils.getListStudents(), 2022003, 002);
    }

    /**
     * 基于给定学生，获取学生的导师的所在学院名称。
     * 任何一项不存在或失败，返回 未知学院
     * @param student
     * @return
     */
    private static String getCollegeName(Student student) {
        if(student==null)
            return "未知学院";
        if(student.getTeacher()==null)
            return "未知学院";
        if(student.getTeacher().getCollege()==null)
            return "未知学院";
        return student.getTeacher().getCollege().getName();
    }

    /**
     * 基于给定学生及教师姓名，判断是否为给定学生的指导教师。
     * 不匹配或不存在，均返回false
     * @param student
     * @param teacherName
     * @return
     */
    private static boolean isTeacher(Student student, String teacherName) {
        if(student==null)
            return false;
        if(student.getTeacher()==null)
            return false;
        return student.getTeacher().getName().equals(teacherName)?true:false;
    }

    /**
     * 基于给定学生集合，学生编号，实现获取学生的导师的所在学院名称。
     * 任何一项不存在或失败，返回 未知学院
     * 结合collection stream findFirst()方法实现
     * 可直接通过一条方法链实现
     *
     * @param students
     * @param sNumber
     * @return
     */
    private static String getCollegeName(List<Student> students, int sNumber) {
        return students.stream()
                .filter(student -> student.getId()==sNumber)
                .findFirst()
                .map(student -> student.getTeacher())
                .map(teacher -> teacher.getCollege().getName())
                .toString();
    }

    /**
     * 实现在给定学生集合中查询指定编号学生，如果学生导师编号为指定编号，打印显式导师所在学院名称。
     * 任何一项不存在或失败，打印显式 未知学院
     * 结合collection stream findFirst()方法实现
     * 可直接通过一条方法链实现
     *
     * @param students
     * @param sNumber，学生编号
     * @param tNumber，教师编号
     */
    private static void printCollegeName(List<Student> students, int sNumber, int tNumber) {
        students.stream()
                .filter(student -> student.getId()==sNumber&&student.getTeacher().getId()==tNumber)
                .findFirst()
                .map(student -> student.getTeacher().getCollege().getName())
                .ifPresentOrElse(value->System.out.println(value),()->System.out.println("未知学院"));

    }

}