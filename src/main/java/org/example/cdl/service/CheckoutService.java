package org.example.cdl.service;

import org.example.cdl.model.Product;
import org.example.cdl.repository.InventoryRepository;
import org.example.cdl.service.basket.BasketService;
import org.example.cdl.service.calculator.PriceCalculator;
import org.example.cdl.service.message.MessageLoader;

import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.cdl.service.message.MessageLoader.CURRENT_PRICE;
import static org.example.cdl.service.message.MessageLoader.TOTAL_PRICE;

public class CheckoutService {

  private static final Logger LOGGER = Logger.getLogger(CheckoutService.class.getName());
  private static final String TOTAL_COMMAND = "Total";
  private final BasketService basketService = new BasketService();

  public Integer calculate(InputStream in) {
    Scanner scanner = new Scanner(in);

    Integer totalPrice = 0;
    while (scanner.hasNext()) {
      String scannedProduct = scanner.nextLine();
      if (scannedProduct.equals(TOTAL_COMMAND)) {
        break;
      }
      totalPrice += calculatePriceForProduct(scannedProduct);
      LOGGER.log(Level.INFO, messageLoader().getMessage(CURRENT_PRICE), totalPrice);
    }
    LOGGER.log(Level.INFO, messageLoader().getMessage(TOTAL_PRICE), totalPrice);
    return totalPrice;
  }

  private Integer calculatePriceForProduct(String scannedProduct) {
    Product product = InventoryRepository.getProductByName(scannedProduct);
    if (product == null) {
      return 0;
    }
    basketService.placeProduct(scannedProduct);
    return PriceCalculator.calculateAmount(product, basketService.getProductQuantity(scannedProduct));
  }

  private MessageLoader messageLoader() {
    return MessageLoader.create();
  }
}
