package com.devsuperior.DSList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.DSList.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
		
}
