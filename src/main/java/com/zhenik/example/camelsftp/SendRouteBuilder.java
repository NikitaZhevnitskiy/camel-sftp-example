package com.zhenik.example.camelsftp;

import org.apache.camel.builder.RouteBuilder;

/**
 * camel-sftp NIK on 22/05/2018
 */
public class SendRouteBuilder extends RouteBuilder {

  private final AppConfig config;

  public SendRouteBuilder(final AppConfig config) {
    this.config=config;
  }

  public void configure() throws Exception {
    final String fileSystemInputDir = "file:"+config.fileSysDirInput +"?noop=true";

    // uri: sftp://foo@localhost:2222/samples/sftp/input?password=pass
    final String sftpInputDir = "sftp://"
        + config.sftpUsername
        + "@"
        + config.sftpHost
        + ":"
        + config.sftpPort
        + config.sftpDirInput
        + "?password="
        + config.sftpPassword;

    from(fileSystemInputDir)
        // Send file to SFTP Server
        .to(sftpInputDir);
  }
}
