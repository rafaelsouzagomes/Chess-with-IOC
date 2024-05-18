package com.game.chess.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.chess.dtos.MovimentOptionsAvailable;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.services.IMovimentService;

@RestController()
@RequestMapping("/chess")
@CrossOrigin
public class ChessController {
	
	IMovimentService movimentService;
	
	@CrossOrigin
	@GetMapping("/moviment/options")
	public MovimentOptionsAvailable getMovimentOptions(MovimentRequestDTO mov)  {
		return movimentService.getMovimentOptions(mov);
	}
	
//	@CrossOrigin
//	@GetMapping("/init")
//	public ChessBoardDTO initGame()  {
//		return chessService.initGame();
//	}
//	

//	
//	@CrossOrigin
//	@GetMapping("/testeAlterar")
//	public int[][] testeAlterar()  {
//		return chessService.testeAlterar();
//	}
	
	public void setMovimentService(IMovimentService movimentService) {
		this.movimentService = movimentService;
	}

}
