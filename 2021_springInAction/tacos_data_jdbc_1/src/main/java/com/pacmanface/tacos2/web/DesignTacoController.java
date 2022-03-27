package com.pacmanface.tacos2.web;

import java.util.*;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import lombok.extern.slf4j.Slf4j;
import com.pacmanface.tacos2.Taco;
import com.pacmanface.tacos2.data.IngredientRepository;
import com.pacmanface.tacos2.Ingredient;
import com.pacmanface.tacos2.Ingredient.Type;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
	
	private IngredientRepository repository;
	
	public DesignTacoController(IngredientRepository repo) {
		repository = repo;
	}
	
	@GetMapping
	public String showDesignForm(Model model) {
		model.addAttribute("taco", new Taco());
		return "design";
	}
	
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = (List<Ingredient>) repository.findAll();
		
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), 
					filterByType(ingredients, type));
		}
	}
	
	private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients
			.stream()
			.filter(x -> x.getType().equals(type))
			.collect(Collectors.toList());
	}
	
	@PostMapping
	public String processTaco(@Valid @ModelAttribute("taco") Taco taco, Errors errors) {
		if(errors.hasErrors())
			return "/design";
		log.info("Processing taco " + taco);
		return "redirect:/orders/current";
	}
}
