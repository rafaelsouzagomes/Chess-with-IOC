package com.game.chess.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.services.IMovimentService;

@RestController()
@RequestMapping("/chess")
@CrossOrigin
public class ChessController {
	
	IMovimentService movimentService;
	
	@CrossOrigin
	@GetMapping("/moviment/options")
	public MovimentOptionsAvailableDTO getMovimentOptions(@RequestBody MovimentRequestDTO mov)  {
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
	
	@Autowired
	public void setMovimentService(IMovimentService movimentService) {
		this.movimentService = movimentService;
	}

}
