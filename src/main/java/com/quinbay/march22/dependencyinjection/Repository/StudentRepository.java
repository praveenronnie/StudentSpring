package com.quinbay.march22.dependencyinjection.Repository;

import com.quinbay.march22.dependencyinjection.Entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

}
