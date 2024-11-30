package com.example.submission.CRUD.repository;



import com.example.submission.CRUD.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<product, Long> {}
