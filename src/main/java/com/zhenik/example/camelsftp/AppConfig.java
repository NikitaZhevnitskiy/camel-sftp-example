package com.zhenik.example.camelsftp;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * camel-sftp NIK on 22/05/2018
 */
public final class AppConfig {

  public final String fileSysDirInput;
  public final String fileSysDirOutput;

  public final String sftpHost;
  public final int sftpPort;
  public final String sftpUsername;
  public final String sftpPassword;
  public final String sftpDirInput;
  public final String sftpDirOutput;

  public AppConfig(final Config fileSysConfig, final Config sftpConfig) {
    this.fileSysDirInput = fileSysConfig.getString("dir-input");
    this.fileSysDirOutput = fileSysConfig.getString("dir-output");

    this.sftpHost = sftpConfig.getString("host");
    this.sftpPort = sftpConfig.getInt("port");
    this.sftpUsername = sftpConfig.getString("username");
    this.sftpPassword = sftpConfig.getString("password");

    this.sftpDirInput = sftpConfig.getString("dir-input");
    this.sftpDirOutput = sftpConfig.getString("dir-output");
  }

  public static AppConfig load() {
    final Config config = ConfigFactory.load();
    final Config fileSysConfig  = config.getConfig("camel-sftp.file-system");
    final Config sftpConfig  = config.getConfig("camel-sftp.sftp-server");
    return new AppConfig(fileSysConfig,sftpConfig);
  }
}
