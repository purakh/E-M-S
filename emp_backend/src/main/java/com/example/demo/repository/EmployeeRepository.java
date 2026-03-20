package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    @Query("SELECT e FROM Employee e WHERE " +
           "LOWER(e.fname) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
           "LOWER(e.lname) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
           "CAST(e.id as string) LIKE %:keyword%")
    List<Employee> searchEmployee(@Param("keyword") String keyword);

}