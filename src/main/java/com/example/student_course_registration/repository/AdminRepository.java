package com.example.student_course_registration.repository;
import com.example.student_course_registration.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, String> {
    Admin findByUsername(String username);
}