package com.pacmanface.jdbctacos.data;

import com.pacmanface.jdbctacos.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
