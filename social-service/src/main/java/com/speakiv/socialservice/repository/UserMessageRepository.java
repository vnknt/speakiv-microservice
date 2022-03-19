package com.speakiv.socialservice.repository;

import com.speakiv.socialservice.model.entity.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMessageRepository extends JpaRepository<UserMessage,Long> {
}
