package com.sergeykarpen.crudconsole.repository;


import java.io.IOException;
import java.util.List;

public interface GenericRepository<T, ID> {
    T save(T t) throws IOException;

    T update(T t) throws IOException;

    List<T> getAll() throws IOException;

    T getById(ID id) throws IOException;

    void deleteById(ID id) throws IOException;

    List<T> convertStringsToObjects(List<String> input) throws IOException;

    List<String> convertObjectsToStrings(List<T> input) throws IOException;

    String convertObjectToString(T t) throws IOException;
}
