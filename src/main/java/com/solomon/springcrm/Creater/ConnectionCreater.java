package com.solomon.springcrm.Creater;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component("connectionCreater")
@Scope("singleton")
public class ConnectionCreater {
  @Value("${jdbc.user}")
  private String user;

  @Value("${jdbc.password}")
  private String password;

  @Value("${jdbc.jdbcUrl}")
  private String jdbcUrl;

  private Connection connection;

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getJdbcUrl() {
    return jdbcUrl;
  }

  public void setJdbcUrl(String jdbcUrl) {
    this.jdbcUrl = jdbcUrl;
  }

  public Connection ConnectionCreation() throws SQLException {
    if (this.connection == null) {
      ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
      comboPooledDataSource.setJdbcUrl(this.getJdbcUrl());
      comboPooledDataSource.setUser(this.getUser());
      comboPooledDataSource.setPassword(this.getPassword());
      comboPooledDataSource.setMaxPoolSize(20);
      comboPooledDataSource.setMinPoolSize(5);
      comboPooledDataSource.setMaxIdleTime(30000);
      this.connection = comboPooledDataSource.getConnection();
    }
    return this.connection;
  }

  public void closeConnection() throws SQLException {
    if (this.connection != null && !this.connection.isClosed()) {
      this.connection.close();
    } else {
      throw new RuntimeException("Connection is already closed!");
    }
  }
}
