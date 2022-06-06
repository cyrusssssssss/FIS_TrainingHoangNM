package dao;

import core.CriminalCase;
import core.Evidence;

public interface ICriminalCase {
    void createCriminalCase(CriminalCase criminalCase);
    void updateCriminalCase(CriminalCase criminalCase);
    void deleteCriminalCase(Long id);
    CriminalCase findCriminalCaseById(Long id);
}
