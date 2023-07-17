package com.sopadeletras.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SopaDeLetrasResponseDTO {
	
	private String searchword;
	
	private int rows;
	
	private String word;
	
	private boolean contains;
	
	private int startRow;
	
	private int startCol;
	
	private String coincidencia;

}
