package com.pacmanface.tacosmongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Document
public class TacoOrder implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date placedAt;
	
	@NotBlank(message=" set a name, please")
	private String deliveryName;
	
	@NotBlank(message=" set a street, please")
	private String deliveryStreet;
	
	@NotBlank(message=" set a city, please")
	private String deliveryCity;
	
	@NotBlank(message=" set a state, please")
	private String deliveryState;
	
	@NotBlank(message=" set a zip number, please")
	private String deliveryZip;

	@Digits(integer=16, fraction=0, message=" set 16 digit cvv number")
	private String ccNumber;
	
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",	message=" must be formatted MM/YY")
	private String ccExpiration;
	
	@Digits(integer=3, fraction=0, message=" set 3 digit cvv number")
	private String ccCVV;
	
	private List<Taco> tacos = new ArrayList<>();
	
	public void addTaco(Taco taco) {
		tacos.add(taco);
	}
}
