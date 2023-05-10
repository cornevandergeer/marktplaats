package nl.corne.marktplaats.model;

import java.util.List;

public interface DAOInterface<T> {

    List<T> getAll();

    int save(T t);

    void insert(T t);

    int update(T t);

    int delete(T t);
}
