package com.pacmanface.tacoscass;

import java.util.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table("tacos")
public class Taco {

	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private UUID id = Uuids.timeBased();

	@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
	private Date createdAt = new Date();
	
	@NotNull
	@Size(min=1, message=" min 1 letter, please")
	private String name;
	
	@NotNull
	@Size(min=1, message=" min 1 element, please")
	@Column("ingredients")
	private List<IngredientUDT> ingredients = new ArrayList<>();

	public void addIngredient(IngredientUDT ingredient) {
		ingredients.add(ingredient);
	}
}
