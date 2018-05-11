package com.chandlertu.demo.json.property;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

@JsonTypeInfo(use = Id.NAME, property = "MsgType")
@JsonTypeIdResolver(TestMessageTypeIdResolver.class)
public interface TestMessage {

}
