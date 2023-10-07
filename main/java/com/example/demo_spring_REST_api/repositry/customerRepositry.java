package com.example.demo_spring_REST_api.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_spring_REST_api.entity.Customer;

public interface customerRepositry extends JpaRepository<Customer, Integer> {

}
