package com.welltestedlearning.kitchenkiosk;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderRepository {
  private Map<Long, Order> mealOrderMap = new HashMap<>();
  private AtomicLong sequence = new AtomicLong(1);

  Order findOne(Long id) {
    return mealOrderMap.get(id);
  }

  Order save(Order order) {
    if (order.getId() == null) {
      order.setId(sequence.getAndIncrement());
    }
    mealOrderMap.put(order.getId(), order);
    return order;
  }

  List<Order> findAll() {
    return new ArrayList<>(mealOrderMap.values());
  }
}
