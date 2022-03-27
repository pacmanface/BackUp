package com.pacmanface.tacos3.data;

import com.pacmanface.tacos3.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    Optional<TacoOrder> findByDeliveryCity(String city);
}
