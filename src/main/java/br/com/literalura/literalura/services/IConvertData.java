package br.com.literalura.literalura.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConvertData {

    <R> R convertObj(String json, Class<R> returnedClass) throws JsonProcessingException;
}
