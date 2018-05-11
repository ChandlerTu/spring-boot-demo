package com.chandlertu.demo.json.external.property;

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
public class MessageTests {

  private static final String JSON =
      "{\"Extra\":{\"AlarmId\":1,\"RecordId\":\"1\"},\"MsgType\":\"1920101\"}";

  @Autowired
  private ObjectMapper mapper;

  @Test
  public void readValue() throws JsonParseException, JsonMappingException, IOException {
    Message message = mapper.readValue(JSON, Message.class);
    assertThat(message.toString()).isEqualTo(
        "Message(extra=Extra1920101(alarmId=1, recordId=1, serviceType=null, warnType=null))");
  }

  @Test
  public void writeValueAsString() throws JsonProcessingException {
    Extra1920101 extra1920101 = new Extra1920101();
    extra1920101.setAlarmId(1);
    extra1920101.setRecordId("1");

    Message message = new Message();
    message.setExtra(extra1920101);

    String json = mapper.writeValueAsString(message);
    assertThat(json).isEqualTo(JSON);
  }

}
