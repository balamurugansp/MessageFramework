package com.messagemq.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.messagemq.userservice.dto.UserEntity;

@Repository
public interface UserServiceRepository extends JpaRepository<UserEntity, Long> {

}

