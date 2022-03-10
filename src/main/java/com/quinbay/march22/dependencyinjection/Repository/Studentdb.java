package com.quinbay.march22.dependencyinjection.Repository;

import com.quinbay.march22.dependencyinjection.dto.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Studentdb {
    List<Student> list = new ArrayList<>();

    public  List<Student> getStudentList(){

        if(list.size() == 0 )
        {
            Student  s1 = new Student(101,"Praveen");
            Student  s2 = new Student(102,"Ronnie");
            list.add(s1);
            list.add(s2);
            return list;
        }
        return list;
    }

    public void addStudent(Student student) {
        list.add(student);
    }

    public void deleteStudent(Long id) {

        for (Student s : list) {
            if (s.getId().equals(id)) {
                list.remove(s);
                break;
            }
        }
    }
    public Student updateStudent(Student student) {
        for (Student s : list) {
            if (s.getId().equals(student.getId())) {
                s.setName(student.getName());
                return new Student(s.getId(),s.getName());
            }
        }
        return null;
    }
}
