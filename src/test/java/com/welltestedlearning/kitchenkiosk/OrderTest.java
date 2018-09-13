package com.welltestedlearning.kitchenkiosk;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderTest {

  @Test
  public void spying() throws Exception {
    //
    // controller.placeOrder(Order) { kitchenService.sendOrder() }
    // spy(controller).verify(sendOrder)
  }


  @Test
  public void mocking() throws Exception {
    Order order = new Order();
    order.setStatus("PLACED");

    OrderRepository repo = mock(OrderRepository.class);
    when(repo.findOne(any())).thenReturn(order);

    OrderApiController orderApiController = new OrderApiController(repo);
    ResponseEntity<OrderResponse> orderResponseResponseEntity = orderApiController.orderStatus(123L);
    String status = orderResponseResponseEntity.getBody().getStatus();
    assertThat(status)
        .isEqualTo("COOKING");
  }

  @Test
  public void faking() throws Exception {
    Order order = new Order();
    order.setStatus("PLACED");

    OrderRepository fakeRepo = new OrderRepository();
    Order savedOrder = fakeRepo.save(order);

    OrderApiController orderApiController = new OrderApiController(fakeRepo);
    ResponseEntity<OrderResponse> orderResponseResponseEntity = orderApiController.orderStatus(savedOrder.getId());
    String status = orderResponseResponseEntity.getBody().getStatus();
    assertThat(status)
        .isEqualTo("COOKING");
  }

  @Test
  public void moveToNextState() {
    Order order = new Order();
    assertThat(order.getStatus())
        .isEqualTo("NEW");
    order.moveToNextState();
    assertThat(order.getStatus())
        .isEqualTo("PLACED");
    order.moveToNextState();
    assertThat(order.getStatus())
        .isEqualTo("COOKING");
    order.moveToNextState();
    assertThat(order.getStatus())
        .isEqualTo("COMPLETED");
  }
}