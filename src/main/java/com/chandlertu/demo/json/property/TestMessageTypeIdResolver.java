package com.chandlertu.demo.json.property;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

import java.io.IOException;

public class TestMessageTypeIdResolver extends TypeIdResolverBase {

  private JavaType superType;

  @Override
  public Id getMechanism() {
    return Id.NAME;
  }

  @Override
  public String idFromValue(Object value) {
    return idFromValueAndType(value, value.getClass());
  }

  @Override
  public String idFromValueAndType(Object value, Class<?> suggestedType) {
    return suggestedType.getSimpleName().substring(TestMessage.class.getSimpleName().length());
  }

  @Override
  public void init(JavaType baseType) {
    superType = baseType;
  }

  @Override
  public JavaType typeFromId(DatabindContext context, String id) throws IOException {
    try {
      Class<?> subType = Class.forName(TestMessage.class.getName() + id);
      return context.constructSpecializedType(superType, subType);
    } catch (ClassNotFoundException e) {
      return super.typeFromId(context, id);
    }
  }

}
