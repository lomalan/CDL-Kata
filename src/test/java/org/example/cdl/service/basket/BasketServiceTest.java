package org.example.cdl.service.basket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketServiceTest {

  private BasketService basketService;

  @BeforeEach
  void setup() {
    basketService = new BasketService();
  }

  @Test
  void placeTwoProducts() {
    basketService.placeProduct("A");
    basketService.placeProduct("A");

    assertEquals(2, basketService.getProductQuantity("A"));
  }

  @Test
  void placeTwoDifferentProducts() {
    basketService.placeProduct("A");
    basketService.placeProduct("B");

    assertEquals(1, basketService.getProductQuantity("A"));
    assertEquals(1, basketService.getProductQuantity("B"));
  }
}
