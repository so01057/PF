package com.zemnnni.portfolio.infrastructure.utility.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

    private final ObjectMapper objectMapper;

    public MapperUtil(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    public <T> T jsonMapperParser(String jsonData, Class<T> parsingClass) throws JsonProcessingException {
        return objectMapper.readValue(jsonData, parsingClass);
    }
}
