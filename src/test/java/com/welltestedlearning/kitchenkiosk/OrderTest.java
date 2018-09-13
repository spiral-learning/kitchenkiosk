package com.welltestedlearning.kitchenkiosk;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {

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