package fis.bank.criminal.service;



import fis.bank.criminal.entity.CriminalCase;

import java.util.List;

public interface CriminalCaseService {
    List<CriminalCase> findAll();

    CriminalCase findById(Long criminalCaseId);

    void save(CriminalCase criminalCase);

    void deleteById(Long criminalCaseId);
}
