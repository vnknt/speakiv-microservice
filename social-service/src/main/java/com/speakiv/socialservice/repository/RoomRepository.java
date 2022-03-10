package com.speakiv.socialservice.repository;

import com.speakiv.socialservice.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
