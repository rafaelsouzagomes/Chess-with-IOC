package com.game.chess.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.chess.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>  {

}
