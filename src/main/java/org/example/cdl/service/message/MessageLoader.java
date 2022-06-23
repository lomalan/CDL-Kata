package org.example.cdl.service.message;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class MessageLoader {

  private static final Properties properties = new Properties();

  public static final String INTRO_KEY = "intro";
  public static final String PRODUCT_ABSENT = "product_absent";
  public static final String CURRENT_PRICE = "current_price";
  public static final String TOTAL_PRICE = "total_price";

  private static MessageLoader instance;

  private MessageLoader() {
    createProperties();
  }

  public static MessageLoader create() {
    if (instance == null) {
      instance = new MessageLoader();
      return instance;
    }
    return instance;
  }

  public String getMessage(String key) {
    return properties.getProperty(key);
  }

  private void createProperties() {
    try (InputStream is = ClassLoader.getSystemResource("messages.properties").openStream()) {
      properties.load(is);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
