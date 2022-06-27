package fis.sprint04.service.serviceImpl;



import fis.sprint04.entity.Evidence;
import fis.sprint04.repository.EvidenceRepository;
import fis.sprint04.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvidenceServiceImpl implements EvidenceService {
    
    @Autowired
    EvidenceRepository evidenceRepository;
    
    @Override
    public List<Evidence> findAll() {
        return evidenceRepository.findAll();
    }
    
    @Override
    public Evidence findById(Long evidenceId) {
        Optional<Evidence> opt = evidenceRepository.findById(evidenceId);
        if(opt.isPresent())
            return opt.get();
        return null;
    }
    
    @Override
    public void save(Evidence evidence) {
        evidenceRepository.save(evidence);
    }
    
    @Override
    public void deleteById(Long evidenceId) {
        evidenceRepository.deleteById(evidenceId);
    }

    @Override
    public List<Evidence> findAllByNumber(String number) {
        return evidenceRepository.findAllByCriminalCaseNumber(number);
    }

}
