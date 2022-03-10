package com.quinbay.march22.dependencyinjection.Repository;

import com.quinbay.march22.dependencyinjection.Entity.MongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMongoRepository extends MongoRepository<MongoEntity, Integer> {


}