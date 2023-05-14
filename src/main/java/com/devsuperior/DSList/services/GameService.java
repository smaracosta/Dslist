package com.devsuperior.DSList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.DSList.dto.GameDTO;
import com.devsuperior.DSList.dto.GameMinDTO;
import com.devsuperior.DSList.entities.Game;
import com.devsuperior.DSList.projections.GameMinProjection;
import com.devsuperior.DSList.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)  // Essa annotation garante que o método garanta que a operação com o BD aconteça.
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true) // O "readOnly = true, é para que ele apenas leia.
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto; 
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByGameList(Long listId){
		List<GameMinProjection> games = gameRepository.searchByList(listId);
		return games.stream().map(GameMinDTO::new).toList();
		
	}

}
