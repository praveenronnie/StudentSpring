package com.quinbay.march22.dependencyinjection.Service;

import com.quinbay.march22.dependencyinjection.dto.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void addStudents(Student student, Integer number);
    void updateStudent(Student student, Integer number);
    void deleteStudent(Long id, Integer number);
}
