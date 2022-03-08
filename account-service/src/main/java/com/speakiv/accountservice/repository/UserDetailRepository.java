package com.speakiv.accountservice.repository;

import com.speakiv.accountservice.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail,String> {
}
