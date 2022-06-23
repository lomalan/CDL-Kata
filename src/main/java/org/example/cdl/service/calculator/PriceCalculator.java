package org.example.cdl.service.calculator;


import org.example.cdl.model.Product;

public class PriceCalculator {

  private PriceCalculator() {}

  public static Integer calculateAmount(Product product, int productQuantity) {
    if (product.getDiscount() == null) {
      return product.getPrice();
    }
    return productQuantity % product.getDiscount().getProductNumberForDiscount() == 0
      ? product.getDiscount().getAmount()
      : product.getPrice();
  }

}
