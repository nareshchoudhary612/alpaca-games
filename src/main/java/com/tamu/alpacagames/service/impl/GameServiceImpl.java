package com.tamu.alpacagames.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamu.alpacagames.model.Game;
import com.tamu.alpacagames.repository.GameRepository;
import com.tamu.alpacagames.service.GameService;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	GameRepository gameRepository;
	
	@Override
	public List<Game> getHomepageGames() {
		
		return gameRepository.findByhomepageFlag(true);
	}
	
	@Override
	public List<Game> getGames() {
		
		return gameRepository.findAll();
	}

	@Override
	public Game createGame(Game game) {
		gameRepository.save(game);
		return gameRepository.findByName(game.getName());
	}

	@Override
	public Optional<Game> getGameById(Long id) {
		
		return gameRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		 gameRepository.deleteById(id);
		
		 
	}

	@Override
	public void save(Game game) {
		
		
		gameRepository.saveAndFlush(game);
		
	}
	
	

}
