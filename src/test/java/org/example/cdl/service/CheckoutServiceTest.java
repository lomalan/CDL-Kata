package org.example.cdl.service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutServiceTest {

  @Test
  void buyProductsWithoutDiscounts() {
    ByteArrayInputStream inputStream = new ByteArrayInputStream("A\nA\nB\nC\nD\nTotal".getBytes());

    Integer totalPrice = new CheckoutService().calculate(inputStream);
    assertEquals(165, totalPrice);
  }

  @Test
  void buyProductsWithDiscount() {
    ByteArrayInputStream inputStream = new ByteArrayInputStream("A\nA\nA\nB\nB\nJ\nD".getBytes());

    Integer totalPrice = new CheckoutService().calculate(inputStream);
    assertEquals(190, totalPrice);
  }
}
