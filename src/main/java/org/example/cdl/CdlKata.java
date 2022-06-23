package org.example.cdl;

import org.example.cdl.service.CheckoutService;
import org.example.cdl.service.message.MessageLoader;

public class CdlKata {

  public static void main(String[] args) {
    System.out.println(MessageLoader.create().getMessage(MessageLoader.INTRO_KEY));
    new CheckoutService().calculate(System.in);
  }
}
