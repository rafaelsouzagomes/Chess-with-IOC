package com.game.chess.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.chess.models.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>  {

}
