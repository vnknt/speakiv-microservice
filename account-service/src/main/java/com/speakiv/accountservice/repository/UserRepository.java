package com.speakiv.accountservice.repository;

import com.speakiv.accountservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
