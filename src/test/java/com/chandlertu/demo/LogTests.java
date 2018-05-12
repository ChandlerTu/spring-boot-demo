package com.chandlertu.demo;

import lombok.extern.apachecommons.CommonsLog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@CommonsLog
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTests {

  @Test
  public void test() {
    log.info("message");
  }

}
