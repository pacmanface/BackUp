package com.pacmanface.tacos3.data;

import com.pacmanface.tacos3.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
