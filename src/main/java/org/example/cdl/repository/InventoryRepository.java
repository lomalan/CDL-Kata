package org.example.cdl.repository;

import org.example.cdl.model.Discount;
import org.example.cdl.model.Product;
import org.example.cdl.service.message.MessageLoader;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.cdl.service.message.MessageLoader.PRODUCT_ABSENT;

public class InventoryRepository {

  private InventoryRepository() {}

  private static final Logger LOGGER = Logger.getLogger(InventoryRepository.class.getName());

  private static final Map<String, Product> inventory = Map
    .of("A", new Product("A", 50, new Discount(30, 3)),
      "B", new Product("B", 30, new Discount(15, 2)),
      "C", new Product("C", 20),
      "D", new Product("D", 15));

  public static Product getProductByName(String productName) {
    Product product = inventory.get(productName);
    if (product == null) {
      LOGGER.log(Level.WARNING, MessageLoader.create().getMessage(PRODUCT_ABSENT));
    }
    return product;
  }
}
