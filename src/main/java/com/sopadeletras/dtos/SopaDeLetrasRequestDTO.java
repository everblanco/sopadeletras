package com.sopadeletras.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SopaDeLetrasRequestDTO {
	
	@NotEmpty
	@NotNull
	private String searchword;
	@Positive
	private int rows;
	@NotEmpty
	@NotNull
	private String word;

}
