package com.pacmanface.tacos;

import java.util.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {
	
	private Long id;
	private Date createdAt = new Date();
	
	@NotNull
	@Size(min=5, message=" set at least 5 characters, please")
	private String name;
	
	@NotNull
	@Size(min=1, message=" set at least 1 element, please")
	private List<Ingredient> ingredients;
}
