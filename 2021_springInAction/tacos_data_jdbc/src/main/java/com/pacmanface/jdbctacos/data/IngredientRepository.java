package com.pacmanface.jdbctacos.data;

import com.pacmanface.jdbctacos.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
