package com.chandlertu.demo.json.property;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMessageTests {

  private static final String JSON = "{\"MsgType\":\"1920101\",\"Extra1920101\":\"Extra\"}";

  @Autowired
  private ObjectMapper mapper;

  @Test
  public void readValue() throws JsonParseException, JsonMappingException, IOException {
    TestMessage message = mapper.readValue(JSON, TestMessage.class);
    assertThat(message.toString()).isEqualTo("TestMessage1920101(extra1920101=Extra)");
  }

  @Test
  public void writeValueAsString() throws JsonProcessingException {
    TestMessage1920101 testMessage1920101 = new TestMessage1920101();
    testMessage1920101.setExtra1920101("Extra");
    String json = mapper.writeValueAsString(testMessage1920101);
    assertThat(json).isEqualTo(JSON);
  }

}
