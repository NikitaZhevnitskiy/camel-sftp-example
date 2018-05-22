package com.zhenik.example.camelsftp;

import org.apache.camel.builder.RouteBuilder;

/**
 * camel-sftp NIK on 22/05/2018
 */
public class SendRouteBuilder extends RouteBuilder {

  public void configure() throws Exception {
    final String path1 = "samples/filesystem/input";
    final String path2 = "samples/sftp/input";
    from("file:"+path1+"?noop=true")
        .to("file:"+path2);
  }
}
