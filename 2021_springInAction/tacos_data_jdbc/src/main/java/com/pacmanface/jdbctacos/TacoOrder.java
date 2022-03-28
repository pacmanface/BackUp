package com.pacmanface.jdbctacos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import java.io.Serializable;
import java.util.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class TacoOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private Date placedAt = new Date();
	
	@NotBlank(message=" 1 to 50 letters, please")
	private String deliveryName;
	
	@NotBlank(message=" 1 to 50 letters, please")
	private String deliveryStreet;
	
	@NotBlank(message=" 1 to 50 letters, please")
	private String deliveryCity;
	
	@NotBlank(message=" 1-3 letters or digits, please. UK,US,RO,POL,77")
	private String deliveryState;
	
	@Size(min=5, max=10, message=" 5 to 10 digits, please")
	private String deliveryZip;
	
	@Digits(integer=16, fraction = 0, message = " 16 digits, please")
	private String ccNumber;
	
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message=" MM/YY")
	private String ccExpiration;
	
	@Digits(integer=3, fraction=0, message=" 1 to  3 digit, please")
	private String ccCVV;
	
	private List<Taco> tacos = new ArrayList<>();
	
	public void addTaco(Taco taco) {
		tacos.add(taco);
	}
}
