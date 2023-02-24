package com.codegym.service.file;

public interface IModel<T> {
    T parseData(String line);
}
