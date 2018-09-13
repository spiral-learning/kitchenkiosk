package com.welltestedlearning.kitchenkiosk;

import java.util.List;

public class IncomingOrder {
  private String kioskName;
  private Long kioskId;
  private List<String> items;

  public String getKioskName() {
    return kioskName;
  }

  public void setKioskName(String kioskName) {
    this.kioskName = kioskName;
  }

  public Long getKioskId() {
    return kioskId;
  }

  public void setKioskId(Long kioskId) {
    this.kioskId = kioskId;
  }

  public List<String> getItems() {
    return items;
  }

  public void setItems(List<String> items) {
    this.items = items;
  }
}
