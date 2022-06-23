package org.example.cdl.model;

public class Product {

  private String name;
  private int price;
  private Discount discount;

  public Product(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public Product(String name, int price, Discount discount) {
    this.name = name;
    this.price = price;
    this.discount = discount;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public Discount getDiscount() {
    return discount;
  }
}
