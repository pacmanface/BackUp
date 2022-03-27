package com.pacmanface.tacos.data;

import java.util.Optional;
import com.pacmanface.tacos.Ingredient;

public interface IngredientRepository {
	Iterable<Ingredient> findAll();
	Optional<Ingredient> findById(String id);
	Ingredient save(Ingredient ingredient);
}
