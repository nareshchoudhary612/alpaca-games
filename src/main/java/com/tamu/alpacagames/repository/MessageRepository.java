package com.tamu.alpacagames.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamu.alpacagames.model.Message;
import com.tamu.alpacagames.model.Users;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	
}
