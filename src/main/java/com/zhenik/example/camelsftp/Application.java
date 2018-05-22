package com.zhenik.example.camelsftp;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * camel-sftp NIK on 22/05/2018
 */
public class Application {
  public static void main(String[] args) {
    //
    CamelContext context= new DefaultCamelContext();
    try{
      context.addRoutes(new RouteBuilder() {
        @Override
        public void configure() throws Exception {
          from("file:samples/filesystem/input")
              // Send file to SFTP Server
              .to("sftp://foo@localhost:2222/samples/sftp/input?password=pass");
        }
      });

      context.start();
      Thread.sleep(5000);
      context.stop();

    }catch(Exception e){
      System.out.println("Inside Exception : " + e);
    }

  }
}
