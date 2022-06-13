package dao;

import core.CriminalCase;

import java.util.List;

public interface IDao<T> {
    void create(T t);
    void update(T t, Long id);
    void delete(Long id);
    T findById(Long id);
    List<T> getAll();
    int countT();
}
