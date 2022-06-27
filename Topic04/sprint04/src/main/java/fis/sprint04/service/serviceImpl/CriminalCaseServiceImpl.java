package fis.sprint04.service.serviceImpl;



import fis.sprint04.entity.CriminalCase;
import fis.sprint04.entity.enums.CaseStatus;
import fis.sprint04.repository.CriminalCaseRepository;
import fis.sprint04.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriminalCaseServiceImpl implements CriminalCaseService {

    @Autowired
    CriminalCaseRepository criminalCaseRepository;

    @Override
    public List<CriminalCase> findAll() {
        return criminalCaseRepository.findAll();
    }

    @Override
    public CriminalCase findById(Long criminalCaseId) {
        Optional<CriminalCase> opt = criminalCaseRepository.findById(criminalCaseId);
        if(opt.isPresent())
            return opt.get();
        return null;
    }

    @Override
    public void save(CriminalCase criminalCase) {
        criminalCaseRepository.save(criminalCase);
    }

    @Override
    public void deleteById(Long criminalCaseId) {
        criminalCaseRepository.deleteById(criminalCaseId);
    }

    @Override
    public List<CriminalCase> findAllByStatus(CaseStatus status) {
        return criminalCaseRepository.findAllByStatus(status);
    }

    @Override
    public List<CriminalCase> findAllByUserName(String userName) {
        return criminalCaseRepository.findAllByAssignedUserName(userName);
    }

}
