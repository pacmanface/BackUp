package com.pacmanface.tacoscass.data;

import com.pacmanface.tacoscass.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {
}
