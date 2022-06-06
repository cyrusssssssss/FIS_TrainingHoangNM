package dao;

import core.Detective;
import core.Evidence;

public interface IDetective {
    void createDetective(Detective detective);
    void updateDetective(Detective detective);
    void deleteDetective(Long id);

    Detective findDetectiveById(Long id);
}
