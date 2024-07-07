package com.game.chess.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.chess.services.components.squareboard.SquareBoard;

@Entity
public class Game {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGame;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Player player_A;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Player player_B;
	
	@Lob
	@Column(name = "board", columnDefinition = "TEXT")
	private String board;

	@Transient
	private SquareBoard[][] squareBoard;

	private String name;
	
	public SquareBoard[][] getSquareBoard() {
        if (squareBoard == null && board != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                squareBoard = objectMapper.readValue(board, SquareBoard[][].class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return squareBoard;
    }
	
	public void setSquareBoard(SquareBoard[][] squareBoard) {
        this.squareBoard = squareBoard;
        if (squareBoard != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                this.board = objectMapper.writeValueAsString(squareBoard);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else {
            this.board = null;
        }
    }

	public Long getIdGame() {
		return idGame;
	}

	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getPlayer_A() {
		return player_A;
	}

	public void setPlayer_A(Player player_A) {
		this.player_A = player_A;
	}

	public Player getPlayer_B() {
		return player_B;
	}

	public void setPlayer_B(Player player_B) {
		this.player_B = player_B;
	}
	
	
}
