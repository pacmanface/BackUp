package com.pacmanface.jpatacos.data;

import com.pacmanface.jpatacos.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
