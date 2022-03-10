package com.quinbay.march22.dependencyinjection.Controller;

import com.quinbay.march22.dependencyinjection.Service.StudentService;
import com.quinbay.march22.dependencyinjection.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
class StudentController {

    /*@GetMapping("/Greet")

    public String Greet(){
        return "Hello";
    }*/

    @Autowired
    StudentService studentService;


    @PostMapping(value = "/Student")
        public void addStudent(@RequestBody @Valid Student student, @RequestParam Integer number){
        studentService.addStudents(student, number);
    }

    @PutMapping
        public void updateStudent(@RequestBody Student student, @RequestParam Integer number){
         studentService.updateStudent(student,number);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudent(){
        System.out.println("inside get all students controller");
        List<Student> students = studentService.getAllStudents();
        System.out.println(students);
        return students;
    }
}