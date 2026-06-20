package com.ducat.springWE1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducat.springWE1.Entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    
}
