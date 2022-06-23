package fis.bank.criminal.repository;

import fis.bank.criminal.entity.AbstractEntity;
import fis.bank.criminal.entity.Detective;


import java.util.Set;

public interface AbstractRepository<T extends AbstractEntity> {
    void create(T obj);

    Set<Detective> getALl();

    T findById(Long id);

    T update(T obj);

    void deleteById(Long id);

    T finbyId(Long id);
}
