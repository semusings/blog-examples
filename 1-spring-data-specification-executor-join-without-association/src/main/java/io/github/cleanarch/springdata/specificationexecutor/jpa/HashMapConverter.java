package io.github.cleanarch.springdata.specificationexecutor.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {

  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(Map<String, Object> object) {

    try {
      return objectMapper.writeValueAsString(object);
    } catch (final JsonProcessingException e) {
      LOG.error("JSON writing error", e);
    }

    return null;
  }

  @Override
  public Map<String, Object> convertToEntityAttribute(String json) {

    try {
      return objectMapper.readValue(json, Map.class);
    } catch (final IOException e) {
      LOG.error("JSON reading error", e);
    }

    return null;
  }
}
