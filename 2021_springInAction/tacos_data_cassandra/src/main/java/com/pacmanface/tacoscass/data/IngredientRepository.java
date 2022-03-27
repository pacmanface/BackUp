package com.pacmanface.tacoscass.data;

import com.pacmanface.tacoscass.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
