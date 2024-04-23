package com.example04.resource;
import com.example04.entity.Student;
import java.util.ArrayList;
import java.util.List;
public class DatabaseUtils {
    public static List<Student> getStudents() {
        // 模拟若干学生对象
        List<Student> students = new ArrayList<>();

        // 添加若干学生对象到列表中
        students.add(new Student(1, "张三", "男",18));
        students.add(new Student(2, "李四", "女",20));
        students.add(new Student(3, "王五", "男",23));
        students.add(new Student(4, "赵六", "男",21));
        students.add(new Student(5, "孙七", "女",23));

        return students;
    }
}
