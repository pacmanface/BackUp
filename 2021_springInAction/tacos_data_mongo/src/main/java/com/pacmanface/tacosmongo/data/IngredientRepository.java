package com.pacmanface.tacosmongo.data;

import com.pacmanface.tacosmongo.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
