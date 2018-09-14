package com.welltestedlearning.kitchenkiosk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class OrderApiController {

  private OrderRepository orderRepository;

  @Autowired
  public OrderApiController(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @PostMapping("/api/orders")
  public ResponseEntity<CreatedOrderResponse> receiveOrder(@RequestBody IncomingOrder incomingOrder) {
    Order order = new Order();
    order.setKioskName(incomingOrder.getKioskName());
    order.setKioskId(incomingOrder.getKioskId());
    order.setOrderItems(incomingOrder.getItems());
    order.moveToNextState();

    Order savedOrder = orderRepository.save(order);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
        path("/{idOfNewResource}").buildAndExpand(savedOrder.getId()).toUri();

    CreatedOrderResponse createdOrderResponse = new CreatedOrderResponse();
    createdOrderResponse.setKioskId(order.getKioskId());
    createdOrderResponse.setOrderNumber(order.getId());
    return ResponseEntity.created(uri).body(createdOrderResponse);
  }

  @GetMapping("/api/orders/{id}")
  public ResponseEntity<OrderResponse> orderStatus(@PathVariable("id") Long id) {
    Order foundOrder = orderRepository.findOne(id);
    if (foundOrder == null) {
      return ResponseEntity.notFound().build();
    }
    foundOrder.moveToNextState();
    orderRepository.save(foundOrder);

    OrderResponse mealOrderResponse = new OrderResponse();
    mealOrderResponse.setOrderNumber(foundOrder.getId());
    mealOrderResponse.setKioskId(foundOrder.getKioskId());
    mealOrderResponse.setStatus(foundOrder.getStatus());

    return ResponseEntity.ok(mealOrderResponse);
  }

  @DeleteMapping("/api/orders/{id}")
  public ResponseEntity delete(@PathVariable("id") Long id) {
    orderRepository.delete(id);
    return ResponseEntity.ok().build();
  }
}
