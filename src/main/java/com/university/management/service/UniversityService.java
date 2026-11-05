package com.university.management.service;

import com.university.management.model.Student;
import com.university.management.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {
    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();

    public UniversityService() {
        students.add(new Student(1L, "Rahim Ahmed", "rahim@student.edu", "CSE", 2, "Active"));
        students.add(new Student(2L, "Nusrat Jahan", "nusrat@student.edu", "EEE", 3, "Active"));
        students.add(new Student(3L, "Hasan Ali", "hasan@student.edu", "BBA", 1, "Probation"));

        teachers.add(new Teacher(1L, "Dr. Sarah Khan", "Computer Science", "sarah@university.edu", "Associate Professor"));
        teachers.add(new Teacher(2L, "Prof. Imran Hossain", "Electrical Engineering", "imran@university.edu", "Professor"));
        teachers.add(new Teacher(3L, "Ms. Farah Rahman", "Business Administration", "farah@university.edu", "Lecturer"));
    }

    public boolean authenticate(String username, String password) {
        return "admin".equalsIgnoreCase(username) && "admin123".equals(password);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public Student addStudent(Student student) {
        if (student.getId() == null) {
            student.setId(System.currentTimeMillis());
        }
        students.add(student);
        return student;
    }

    public Teacher addTeacher(Teacher teacher) {
        if (teacher.getId() == null) {
            teacher.setId(System.currentTimeMillis());
        }
        teachers.add(teacher);
        return teacher;
    }

    public long getStudentCount() {
        return students.size();
    }

    public long getTeacherCount() {
        return teachers.size();
    }
}
