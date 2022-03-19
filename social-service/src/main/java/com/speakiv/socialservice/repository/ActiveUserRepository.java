package com.speakiv.socialservice.repository;

import com.speakiv.socialservice.model.entity.ActiveUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveUserRepository extends JpaRepository<ActiveUser,Long> {
}
