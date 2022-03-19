package com.speakiv.socialservice.repository;

import com.speakiv.socialservice.model.entity.RoomMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomMessageRepository extends JpaRepository<RoomMessage,Long> {
}
