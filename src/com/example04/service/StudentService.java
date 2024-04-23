package com.example04.service;
import com.example04.entity.Student;
import java.util.ArrayList;
import java.util.List;
public interface StudentService {
    // 获取所有学生
    List<Student> getAllStudents();

    // 获取所有男性学生
    List<Student> getAllMaleStudents();

    // 获取所有女性学生
    List<Student> getAllFemaleStudents();

    // 获取特定性别的学生数量
    int getNumberOfStudentsByGender(String gender);

    // 获取平均年龄
    double getAverageAgeOfStudents();

    // 获取最年长的学生
    List<Student>  getOldestStudents();

    // 获取最年轻的学生
    List<Student>  getYoungestStudents();
}
