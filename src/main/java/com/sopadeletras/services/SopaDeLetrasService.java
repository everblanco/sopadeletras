package com.sopadeletras.services;

import org.springframework.stereotype.Service;

import com.sopadeletras.dtos.SopaDeLetrasResponseDTO;

@Service
public class SopaDeLetrasService {
	

	public char[][] splitString(String matriz, int rows) {

		int cols = (int) Math.ceil(matriz.length() / rows);

		char[][] resultado = new char[rows][cols];

		int index = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				char letra = matriz.charAt(index);
				resultado[i][j] = letra;
				index++;
				System.out.print(letra + ",");
			}
			System.out.println("");
		}

		return resultado;
	}
	

	public SopaDeLetrasResponseDTO jugar(char[][] matriz, String palabra, boolean diagonal) {

		int filas = matriz.length;
		int columnas = matriz[0].length;

		// Busqueda horizontal
		for (int i = 0; i < filas; i++) {
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < columnas; j++) {
				builder.append(matriz[i][j]);
			}
			if (builder.toString().contains(palabra)) {
				return SopaDeLetrasResponseDTO.builder().contains(true).startRow(i)
						.startCol(builder.toString().indexOf(palabra)).coincidencia("Horizontal").build();
			}
		}
		

		// Busqueda vertical
		for (int i = 0; i < columnas; i++) {
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < filas; j++) {
				builder.append(matriz[j][i]);
				if (builder.toString().contains(palabra)) {
					return SopaDeLetrasResponseDTO.builder().contains(true).startCol(i)
							.startRow(builder.toString().indexOf(palabra)).coincidencia("Vertical").build();
				}
			}
			
		}
		
		//Busquedad diagonal
		if(diagonal) {
			for(int i=0;i<filas;i++) {
				for(int j=0;j<columnas;j++) {
					StringBuilder builder = new StringBuilder();
					int k = 0;
					while(i+k<filas && j+k<columnas) {
						builder.append(matriz[i+k][j+k]);
						
						if(builder.toString().contains(palabra)) {
							return SopaDeLetrasResponseDTO.builder().contains(true).startCol(j+builder.indexOf(palabra))
									.startRow(i+builder.toString().indexOf(palabra)).coincidencia("Diagonal").build();
						}
						k++;
					}
//					System.out.println(builder.toString());
					
				}
			}
		}

		return SopaDeLetrasResponseDTO.builder().contains(false).build();
	}

}
