package br.com.literalura.literalura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class CovertData implements IConvertData{
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <R> R convertObj(String json, Class<R> returnedClass) {
        try {
            return mapper.readValue(json, returnedClass);
        } catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
