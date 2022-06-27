package fis.sprint04.service.serviceImpl;



import fis.sprint04.entity.Detective;
import fis.sprint04.dto.DetectiveDTO;
import fis.sprint04.repository.DetectiveRepository;
import fis.sprint04.service.DetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetectiveServiceImpl implements DetectiveService {
    @Autowired
    DetectiveRepository detectiveRepository;
    @Override
    public List<Detective> findAll() {
        return detectiveRepository.findAll();
    }

    @Override
    public Detective findById(Long detectiveId) {
        return detectiveRepository.findById(detectiveId).get();
    }

    @Override
    public DetectiveDTO findByUserName(String userName) {
        return detectiveRepository.findByUserName(userName).get();
    }

    @Override
    public void save(Detective detective) {
        detectiveRepository.save(detective);
    }

    @Override
    public void deleteById(Long detectiveId) {
        detectiveRepository.deleteById(detectiveId);
    }
}
