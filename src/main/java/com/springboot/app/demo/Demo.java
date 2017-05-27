package com.springboot.app.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenliang on 2017/5/19.
 */
//@PropertySource("classpath:jdbc.properties")
@PropertySources(value = {@PropertySource ("classpath:jdbc.properties"),
    @PropertySource ("classpath:mysql.properties") })
@ConfigurationProperties(prefix = "mysql")
@RestController
public class Demo {

  //第一种读取配置文件内容
  @Value("${jdbc_driver}")
  private String jdbcDriver;

  //第二中读取配置文件内容
  private String driver;

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public String getDriver() {
    return driver;
  }


  @RequestMapping(value = "/demo",method = RequestMethod.GET)
  public void demoTest(){
    System.out.println(jdbcDriver);
    System.out.println(driver);
  }
}
