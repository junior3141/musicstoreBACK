package com.musicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musicstore.model.repository.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
