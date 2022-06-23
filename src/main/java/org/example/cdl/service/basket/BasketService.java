package org.example.cdl.service.basket;

import java.util.HashMap;
import java.util.Map;

public class BasketService {
  private Map<String, Integer> basket;

  public BasketService() {
    this.basket = new HashMap<>();
  }

  public void placeProduct(String productName) {
    basket.put(productName, basket.getOrDefault(productName, 0) + 1);
  }

  public Integer getProductQuantity(String productName) {
    return basket.get(productName);
  }
}
