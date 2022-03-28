package com.pacmanface.jdbctacos;

import java.util.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Taco {

	@Id
	private Long id;
	private Date createdAt = new Date();
	
	@NotNull
	@Size(min=1, message=" min 1 letter, please")
	private String name;
	
	@NotNull
	@Size(min=1, message=" min 1 element, please")
	private List<Ingredient> ingredients;
}
