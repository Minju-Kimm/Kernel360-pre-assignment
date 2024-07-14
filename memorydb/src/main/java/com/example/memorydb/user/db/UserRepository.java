package com.example.memorydb.user.db;

import com.example.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


interface UserRepository extends JpaRepository<UserEntity, Long> {



}
