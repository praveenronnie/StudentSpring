package com.quinbay.march22.dependencyinjection.Repository;
import com.quinbay.march22.dependencyinjection.dto.Student;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRedisRepository {
    private String STUDENT_COLLECTIONS = "Student";
    private RedisTemplate<String, Student> redisTemplate;
    private HashOperations hashOps;

    @Autowired
    public StudentRedisRepository(RedisTemplate<String,Student> redisTemplate)
    {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void init(){
        System.out.println("--------------inside postconstruct--------------");
        this.hashOps = this.redisTemplate.opsForHash();
    }

    public List<Student> findAll(){
//        Map<String, Student> allElements = hashOps.entries(STUDENT_COLLECTIONS);
//        return allElements.values().stream().collect(Collectors.toList());
        return hashOps.values(STUDENT_COLLECTIONS);
    }

    public Student findOne(String StudentID){
        return (Student) hashOps.get(STUDENT_COLLECTIONS,StudentID);
    }

    public Student save(Student student)
    {
        hashOps.put(STUDENT_COLLECTIONS,student.getId(),student);
        return student;
    }

    public Student insert(Student student)
    {
        hashOps.put(STUDENT_COLLECTIONS,student.getId(),student);
        return student;
    }

    public void delete(Long id)
    {
        hashOps.delete(STUDENT_COLLECTIONS,id);
    }

    public StudentRedisRepository() {

    }
}
