package com.pacmanface.tacos.web;

//import java.util.HashMap;
//import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.pacmanface.tacos.Ingredient;
//import com.pacmanface.tacos.Ingredient.Type;
import com.pacmanface.tacos.data.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
	
	//use power of thejdbc
	/*
	private Map<String, Ingredient> ingredientMap = new HashMap<>();
	
	public IngredientByIdConverter() {
		ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
		ingredientMap.put("COTO", new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
		ingredientMap.put("GRBF",new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
		ingredientMap.put("CARN",new Ingredient("CARN", "Carnitas", Type.PROTEIN));
		ingredientMap.put("TMTO",new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
		ingredientMap.put("LETC",new Ingredient("LETC", "Lettuce", Type.VEGGIES));
		ingredientMap.put("CHED",new Ingredient("CHED", "Cheddar", Type.CHEESE));
		ingredientMap.put("JACK",new Ingredient("JACK", "Monterey Jack", Type.CHEESE));
		ingredientMap.put("SLSA",new Ingredient("SLSA", "Salsa", Type.SAUCE));
		ingredientMap.put("SRCR",new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
	}
	*/
	
	private IngredientRepository repository;
	
	@Autowired
	public IngredientByIdConverter(IngredientRepository repo) {
		repository = repo;
	}
	
	@Override
	public Ingredient convert(String id) {
		return repository.findById(id).orElse(null);
		//return ingredientMap.get(id);
	}
}
