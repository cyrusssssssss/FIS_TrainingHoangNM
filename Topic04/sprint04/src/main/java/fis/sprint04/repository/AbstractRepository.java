package fis.sprint04.repository;



import fis.sprint04.entity.AbstractEntity;
import fis.sprint04.entity.Detective;

import java.util.Set;

public interface AbstractRepository<T extends AbstractEntity> {
    void create(T obj);

    Set<Detective> getALl();

    T findById(Long id);

    T update(T obj);

    void deleteById(Long id);

    T finbyId(Long id);
}
