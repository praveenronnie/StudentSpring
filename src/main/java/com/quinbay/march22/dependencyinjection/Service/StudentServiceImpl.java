package com.quinbay.march22.dependencyinjection.Service;

import com.quinbay.march22.dependencyinjection.Entity.MongoEntity;
import com.quinbay.march22.dependencyinjection.Entity.StudentEntity;
import com.quinbay.march22.dependencyinjection.Repository.StudentMongoRepository;
import com.quinbay.march22.dependencyinjection.Repository.StudentRedisRepository;
import com.quinbay.march22.dependencyinjection.Repository.StudentRepository;
import com.quinbay.march22.dependencyinjection.Repository.Studentdb;
import com.quinbay.march22.dependencyinjection.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    Studentdb studentdb;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentRedisRepository studentRedisRepository;

    @Autowired
    StudentMongoRepository studentMongoRepository;

    @Override
    public List<Student> getAllStudents() {


        List<Student> list = new ArrayList<>();
        for (StudentEntity studentEntity : studentRepository.findAll()) {
            Student student = new Student();
            student.setId(studentEntity.getId());
            student.setName(studentEntity.getName());
            list.add(student);
        }

        for (MongoEntity mongoEntity : studentMongoRepository.findAll()) {
            Student student1 = new Student();
            student1.setId(mongoEntity.getId());
            student1.setName(mongoEntity.getName());
            list.add(student1);
        }

        list.addAll(studentRedisRepository.findAll());

        list.addAll(studentdb.getStudentList());
        return list;
    }

    @Override
    public void addStudents(Student student,Integer number){
        if(number==1)

        {
            studentRepository.save(new StudentEntity(student.getId(),student.getName()));
        }


        if(number==2)
        {
            studentdb.addStudent(student);
        }

        if(number==3)
            studentRedisRepository.insert(student);

        if(number==4) {
            studentMongoRepository.save(new MongoEntity(student.getId(),student.getName()));
        }
    }

    @Override
    public void updateStudent(Student student, Integer number) {
        if (number == 1) {

            for (StudentEntity studentEntity : studentRepository.findAll()) {
                if (studentEntity.getId() == student.getId()) {
                    studentRepository.save(new StudentEntity(student.getId(),student.getName()));
                }

            }
            if (number == 2) {
                studentdb.updateStudent(student);}
                if (number == 3)
                    studentRedisRepository.save(student);

                if (number == 4) {
                    studentMongoRepository.save(new MongoEntity(student.getId(), student.getName()));
                }
            }
        }

    @Override
    public void deleteStudent(Long id, Integer number)
    {
        if(number==1)
        {

            studentRepository.deleteById(id);
        }
        if(number==2)
        {
            studentdb.deleteStudent(id);
        }
        if(number==3)
        {
            studentRedisRepository.delete(id);
        }
        if(number==4) {
            for (MongoEntity student : studentMongoRepository.findAll()) {
                if (student.getId() == id) {
                    studentMongoRepository.delete(student);
                }
            }
        }
    }
}
