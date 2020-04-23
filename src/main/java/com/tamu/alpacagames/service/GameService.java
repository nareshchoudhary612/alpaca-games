package com.tamu.alpacagames.service;

import java.util.List;
import java.util.Optional;

import com.tamu.alpacagames.model.Game;

public interface GameService {
	
	List<Game> getHomepageGames();
	
	Game createGame(Game game);
	
	Optional<Game> getGameById(Long id);

	List<Game> getGames();

	void deleteById(Long id);

	void save(Game game);
}
