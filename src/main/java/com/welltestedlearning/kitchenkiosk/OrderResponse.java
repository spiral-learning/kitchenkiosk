package com.welltestedlearning.kitchenkiosk;

public class OrderResponse {
  private Long orderNumber; // our ID number
  private Long kioskId; // order ID from external meal kiosk
  private String status;

  public Long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Long getKioskId() {
    return kioskId;
  }

  public void setKioskId(Long kioskId) {
    this.kioskId = kioskId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
