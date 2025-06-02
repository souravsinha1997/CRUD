package com.crud.simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.simple.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
