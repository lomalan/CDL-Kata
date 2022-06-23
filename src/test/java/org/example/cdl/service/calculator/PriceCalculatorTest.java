package org.example.cdl.service.calculator;

import org.example.cdl.model.Discount;
import org.example.cdl.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCalculatorTest {

  @Test
  void calculateOneProductWithDiscount() {
    Product product = createProductWithDiscount();
    Integer productPrice = PriceCalculator.calculateAmount(product, 1);

    assertEquals(product.getPrice(), productPrice);
  }

  @Test
  void calculateFiveProductWithDiscount() {
    Product product = createProductWithDiscount();
    Integer productPrice = PriceCalculator.calculateAmount(product, 5);

    assertEquals(product.getDiscount().getAmount(), productPrice);
  }

  @Test
  void calculateOneProductWithoutDiscount() {
    Product product = createProductWithoutDiscount();
    Integer productPrice = PriceCalculator.calculateAmount(product, 1);

    assertEquals(product.getPrice(), productPrice);
  }

  @Test
  void calculateFiveProductWithoutDiscount() {
    Product product = createProductWithoutDiscount();
    Integer productPrice = PriceCalculator.calculateAmount(product, 5);

    assertEquals(product.getPrice(), productPrice);
  }

  public Product createProductWithDiscount() {
    return new Product("A", 50, new Discount(10, 5));
  }

  public Product createProductWithoutDiscount() {
    return new Product("B", 20);
  }
}
