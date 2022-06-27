package fis.sprint04.service;





import fis.sprint04.entity.Detective;
import fis.sprint04.dto.DetectiveDTO;

import java.util.List;

public interface DetectiveService {
    List<Detective> findAll();

    Detective findById(Long detectiveId);
    DetectiveDTO findByUserName(String userName);
    void save(Detective detective);

    void deleteById(Long detectiveId);
}
