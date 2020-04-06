package com.tamu.alpacagames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamu.alpacagames.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
	
	
	List<Game> findByhomepageFlag(boolean flag);
	
	Game findByName(String name);
	
}
