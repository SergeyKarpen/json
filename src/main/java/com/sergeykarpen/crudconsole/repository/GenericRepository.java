package com.sergeykarpen.crudconsole.repository;


import java.io.IOException;
import java.util.List;

public interface GenericRepository <T, ID> {
    T save(T t);
    T update(T t) throws IOException;
    List <T> getAll();
    T getById(ID id) throws IOException;
    void deleteById(ID id) throws IOException;
}
