package com.example.fufastorebemongo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fufastorebemongo.model.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, ObjectId> {

    @Query("{ 'username' : ?0 }")
    Users findUsername(String username);
}
