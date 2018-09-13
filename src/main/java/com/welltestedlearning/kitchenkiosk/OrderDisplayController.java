package com.welltestedlearning.kitchenkiosk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderDisplayController {

  private OrderRepository orderRepository;

  @Autowired
  public OrderDisplayController(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @GetMapping("/")
  public String orderDisplay(Model model) {
    List<Order> orders = orderRepository.findAll().stream()
                                        .filter(Order::isNotDone)
                                        .collect(Collectors.toList());
    model.addAttribute("orders", orders);
    return "order-display";
  }
}
