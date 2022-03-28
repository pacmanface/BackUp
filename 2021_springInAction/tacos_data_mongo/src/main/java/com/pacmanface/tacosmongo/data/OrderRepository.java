package com.pacmanface.tacosmongo.data;

import com.pacmanface.tacosmongo.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {
}
