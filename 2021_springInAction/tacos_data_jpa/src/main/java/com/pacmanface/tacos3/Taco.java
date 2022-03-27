package com.pacmanface.tacos3;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Taco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date createdAt = new Date();
	
	@NotNull
	@Size(min=1, message=" min 1 letter, please")
	private String name;
	
	@NotNull
	@Size(min=1, message=" min 1 element, please")
	@ManyToMany
	private List<Ingredient> ingredients;
}
