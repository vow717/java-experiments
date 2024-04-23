package com.example04;
import com.example04.entity.Student;
import com.example04.service.StudentService;
import com.example04.service.StudentServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getId() + ": " + student.getName() + " (" + student.getGender() + "), 年龄: " + student.getAge());
        }
    }

    public static void main(String[] args) {
        // 创建 StudentServiceImpl 实例
        StudentServiceImpl studentService = new StudentServiceImpl();

        // 调用实现类的方法进行测试，并打印输出
        System.out.println("所有学生:");
        printStudents(studentService.getAllStudents()); // 测试 getAllStudents 方法

        System.out.println("男性学生:");
        printStudents(studentService.getAllMaleStudents()); // 测试 getAllMaleStudents 方法

        System.out.println("女性学生:");
        printStudents(studentService.getAllFemaleStudents()); // 测试 getAllFemaleStudents 方法

        System.out.println("男性学生人数:");
        System.out.println(studentService.getNumberOfStudentsByGender("男")); // 测试 numberOfStudentsByGender 方法

        System.out.println("学生平均年龄:");
        System.out.println(studentService.getAverageAgeOfStudents()); // 测试 averageAgeOfStudents 方法

        System.out.println("年龄最大的学生:");
        printStudents(studentService.getOldestStudents()); // 测试 oldestStudent 方法

        System.out.println("年龄最小的学生:");
        printStudents(studentService.getYoungestStudents()); // 测试 youngestStudent 方法
    }
}
