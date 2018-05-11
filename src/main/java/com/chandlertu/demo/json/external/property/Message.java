package com.chandlertu.demo.json.external.property;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

import lombok.Data;

@Data
public class Message {

  @JsonTypeInfo(use = Id.NAME, include = As.EXTERNAL_PROPERTY, property = "MsgType")
  @JsonTypeIdResolver(ExtraTypeIdResolver.class)
  private Extra extra;

}
