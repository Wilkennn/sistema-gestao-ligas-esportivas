package com.example.dao;

import java.util.List;

public abstract class CommonDAO<T> {
    public abstract int create(T data);
    public abstract void update(T data);
    public abstract void delete(int id);
    public abstract T getById(int id);
    public abstract List<T> getAll();
}
