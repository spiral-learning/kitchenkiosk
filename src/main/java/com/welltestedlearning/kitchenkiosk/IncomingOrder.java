package com.welltestedlearning.kitchenkiosk;

import java.util.List;

public class IncomingOrder {
  private String kioskName;
  private Long orderNumber;
  private List<String> items;

  public String getKioskName() {
    return kioskName;
  }

  public void setKioskName(String kioskName) {
    this.kioskName = kioskName;
  }

  public Long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public List<String> getItems() {
    return items;
  }

  public void setItems(List<String> items) {
    this.items = items;
  }
}
