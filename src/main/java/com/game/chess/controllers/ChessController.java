package com.game.chess.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.chess.models.dtos.InitGameDTO;
import com.game.chess.models.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.models.dtos.MovimentRequestDTO;
import com.game.chess.models.dtos.PlayerDTO;
import com.game.chess.services.GameService;
import com.game.chess.services.IMovimentService;
import com.game.chess.services.player.PlayerService;

@RestController()
@RequestMapping("/chess")
@CrossOrigin
public class ChessController {
	
	IMovimentService movimentService;
	
	GameService gameService;
	
	@Autowired
	PlayerService playerSerivce;
	
	@CrossOrigin
	@GetMapping("/moviment/options")
	public MovimentOptionsAvailableDTO getMovimentOptions(@RequestBody MovimentRequestDTO mov)  {
		return movimentService.getMovimentOptions(mov);
	}
	
	@CrossOrigin
	@GetMapping("/game/init")
	public void initGame(@RequestBody InitGameDTO dto)  {
		 gameService.initGame(dto);
	}
	
	@CrossOrigin
	@GetMapping("/game/init")
	public void createPlayer(@RequestBody PlayerDTO dto)  {
		playerSerivce.createPlayer(dto);
	}
//	

//	
//	@CrossOrigin
//	@GetMapping("/testeAlterar")
//	public int[][] testeAlterar()  {
//		return chessService.testeAlterar();
//	}
	
	@Autowired
	public void setMovimentService(IMovimentService movimentService) {
		this.movimentService = movimentService;
	}
	
	@Autowired
	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}

}
