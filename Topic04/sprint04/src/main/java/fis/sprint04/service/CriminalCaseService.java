package fis.sprint04.service;

import fis.sprint04.entity.CriminalCase;
import fis.sprint04.entity.enums.CaseStatus;

import java.util.List;
import java.util.Optional;

public interface CriminalCaseService {
    List<CriminalCase> findAll();

    CriminalCase findById(Long criminalCaseId);

    void save(CriminalCase criminalCase);

    void deleteById(Long criminalCaseId);
    List<CriminalCase> findAllByStatus(CaseStatus status);
    List<CriminalCase> findAllByUserName(String userName);
}
