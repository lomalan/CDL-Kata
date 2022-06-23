package org.example.cdl.model;

public class Discount {

  private final int amount;
  private final int productNumberForDiscount;

  public Discount(int amount, int productNumberForDiscount) {
    this.amount = amount;
    this.productNumberForDiscount = productNumberForDiscount;
  }

  public int getAmount() {
    return amount;
  }

  public int getProductNumberForDiscount() {
    return productNumberForDiscount;
  }
}
