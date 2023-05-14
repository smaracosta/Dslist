package com.devsuperior.DSList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.DSList.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
		
}
