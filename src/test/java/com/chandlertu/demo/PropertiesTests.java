package com.chandlertu.demo;

import lombok.extern.apachecommons.CommonsLog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@CommonsLog
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTests {

  @Value("${spring.application.name}")
  private String name;

  @Value("${logging.file}")
  private String loggingFile;
  
  @Test
  public void test() {
    log.info(name);
    log.info(loggingFile);
  }

}
