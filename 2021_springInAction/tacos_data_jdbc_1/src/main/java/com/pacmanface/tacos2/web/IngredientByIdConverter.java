package com.pacmanface.tacos2.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.pacmanface.tacos2.Ingredient;
import com.pacmanface.tacos2.data.IngredientRepository;

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
