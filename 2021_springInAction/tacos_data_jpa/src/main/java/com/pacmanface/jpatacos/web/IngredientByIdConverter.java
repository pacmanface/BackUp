package com.pacmanface.jpatacos.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.pacmanface.jpatacos.Ingredient;
import com.pacmanface.jpatacos.data.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

	private IngredientRepository repository;
	
	public IngredientByIdConverter(IngredientRepository repo) {
		repository = repo;
	}
	
	@Override
	public Ingredient convert(String id) {
		return repository.findById(id).orElse(null);
	}
}
