package com.sopadeletras.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopadeletras.dtos.SopaDeLetrasRequestDTO;
import com.sopadeletras.dtos.SopaDeLetrasResponseDTO;
import com.sopadeletras.services.SopaDeLetrasService;

@RestController
@RequestMapping("/")
public class SopaDeLetrasController {
	
	@Autowired
	SopaDeLetrasService sopaDeLetrasService;
	
	@PostMapping("search-horandvert")
	public ResponseEntity<SopaDeLetrasResponseDTO> searchhorandvert(@RequestBody @Validated SopaDeLetrasRequestDTO request) {
		
		char [][] matriz = sopaDeLetrasService.splitString(request.getSearchword(), request.getRows());
		
		SopaDeLetrasResponseDTO response = sopaDeLetrasService.jugar(matriz, request.getWord(), false);
		
		response.setRows(request.getRows());
		
		response.setWord(request.getWord());
		
		response.setSearchword(request.getSearchword());
		
		return ResponseEntity.status(200).body(response);
		
	}
	
	
	@PostMapping("search")
	public ResponseEntity<SopaDeLetrasResponseDTO> search(@RequestBody @Validated SopaDeLetrasRequestDTO request) {
		
		char [][] matriz = sopaDeLetrasService.splitString(request.getSearchword(), request.getRows());
		
		SopaDeLetrasResponseDTO response = sopaDeLetrasService.jugar(matriz, request.getWord(), true);
		
		response.setRows(request.getRows());
		
		response.setWord(request.getWord());
		
		response.setSearchword(request.getSearchword());
		
		return ResponseEntity.status(200).body(response);
		
	}
	

}
