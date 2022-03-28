package com.pacmanface.jpatacos.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pacmanface.jpatacos.TacoOrder;
import com.pacmanface.jpatacos.data.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
	
	private OrderRepository orderRepo;
	
	public OrderController(OrderRepository repo) {
		orderRepo = repo;
	}
	
	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("tacoOrder", new TacoOrder());
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus) {
		if(errors.hasErrors())
			return "orderForm";

		orderRepo.save(order);
		sessionStatus.setComplete();
		log.info("Order submitted: " + order);
		return "redirect:/"; 
	}
}
