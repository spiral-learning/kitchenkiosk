package com.welltestedlearning.kitchenkiosk;

public class CreatedOrderResponse {
  private Long orderNumber; // our ID
  private Long kioskId; // meal order kiosk's Id

  public Long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Long getKioskId() {
    return kioskId;
  }

  public void setKioskId(Long id) {
    this.kioskId = id;
  }
}
