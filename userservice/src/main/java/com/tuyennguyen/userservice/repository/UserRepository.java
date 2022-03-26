package com.tuyennguyen.userservice.repository;

import com.tuyennguyen.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
