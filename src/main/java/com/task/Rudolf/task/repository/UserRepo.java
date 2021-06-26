package com.task.Rudolf.task.repository;

import com.task.Rudolf.task.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepo extends JpaRepository<UserEntity, Long > {


        UserEntity findByEmail(String email);

}
