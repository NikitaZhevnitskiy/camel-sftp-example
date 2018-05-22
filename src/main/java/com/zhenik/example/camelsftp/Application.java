package com.zhenik.example.camelsftp;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * camel-sftp NIK on 22/05/2018
 */
public class Application {
  public static void main(String[] args) {
    //
    CamelContext context= new DefaultCamelContext();
    try{
      context.addRoutes(new SendRouteBuilder());

      context.start();
      Thread.sleep(5000);
      context.stop();

    }catch(Exception e){
      System.out.println("Inside Exception : " + e);
    }

  }
}
