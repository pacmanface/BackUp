package com.pacmanface.tacos.data;

import com.pacmanface.tacos.TacoOrder;

public interface OrderRepository {
	TacoOrder save(TacoOrder order);
}
