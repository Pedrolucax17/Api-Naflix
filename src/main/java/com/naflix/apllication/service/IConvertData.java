package com.naflix.apllication.service;

public interface IConvertData {
    <T> T getData(String json, Class<T> tClass);
}
