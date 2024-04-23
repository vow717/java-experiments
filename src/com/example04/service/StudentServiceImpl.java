package com.example04.service;
import com.example04.entity.Student;
import com.example04.resource.DatabaseUtils;

import java.util.OptionalInt;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService{
    @Override
    public List<Student> getAllStudents() {
        // 调用DatabaseUtils类获取集合资源
        List<Student> students = DatabaseUtils.getStudents();
        return students;
    }

    // 基于集合流操作，获取所有男性学生
    @Override
    public List<Student> getAllMaleStudents() {
        List<Student> students = getAllStudents();
        return students.stream()
                .filter(student -> "男".equals(student.getGender()))
                .collect(Collectors.toList());
    }

    // 基于集合流操作，获取所有女性学生
    @Override
    public List<Student> getAllFemaleStudents() {
        List<Student> students = getAllStudents();
        return students.stream()
                .filter(student -> "女".equals(student.getGender()))
                .collect(Collectors.toList());
    }

    // 基于集合流操作，获取特定性别的学生数量
    @Override
    public int getNumberOfStudentsByGender(String gender) {
        List<Student> students = getAllStudents();
        return (int) students.stream()
                .filter(student -> gender.equals(student.getGender()))
                .count();
    }

    // 基于集合流操作，获取平均年龄
    @Override
    public double getAverageAgeOfStudents() {
        List<Student> students = getAllStudents();
        return students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
    }

    // 基于集合流操作，获取所有最年长的学生
    @Override
    public List<Student> getOldestStudents() {
        List<Student> students = getAllStudents();
        OptionalInt maxAge = students.stream()
                .mapToInt(Student::getAge)
                .max();
        return students.stream()
                .filter(student -> student.getAge() == maxAge.getAsInt())
                .collect(Collectors.toList());
    }

    // 基于集合流操作，获取所有最年轻的学生
    @Override
    public List<Student> getYoungestStudents() {
        List<Student> students = getAllStudents();
        OptionalInt minAge = students.stream()
                .mapToInt(Student::getAge)
                .min();
        return students.stream()
                .filter(student -> student.getAge() == minAge.getAsInt())
                .collect(Collectors.toList());
    }


}
