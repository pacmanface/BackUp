package com.pacmanface.tacos2.data;

import com.pacmanface.tacos2.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
