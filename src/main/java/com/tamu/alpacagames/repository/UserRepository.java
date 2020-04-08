package com.tamu.alpacagames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamu.alpacagames.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	
}
