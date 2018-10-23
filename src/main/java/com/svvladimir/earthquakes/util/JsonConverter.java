package com.svvladimir.earthquakes.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;

public class JsonConverter {

    private ObjectMapper mapper = new ObjectMapper();

    public JsonConverter() {
        mapper.enable(INDENT_OUTPUT);
        mapper.setSerializationInclusion(NON_NULL);
        mapper.disable(FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public <T> T jsonToObject(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String prettifyJson(String json) {
        try {
            Object objectJson = mapper.readValue(json, Object.class);
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
