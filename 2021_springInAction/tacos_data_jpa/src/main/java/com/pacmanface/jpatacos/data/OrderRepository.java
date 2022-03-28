package com.pacmanface.jpatacos.data;

import com.pacmanface.jpatacos.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    Optional<TacoOrder> findByDeliveryCity(String city);
}
