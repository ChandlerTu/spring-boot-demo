package com.chandlertu.demo.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

  @Scheduled(initialDelay = 1000, fixedRate = 86400000)
  public void reportCurrentTime() {
    System.out.println(System.currentTimeMillis());
  }

}
