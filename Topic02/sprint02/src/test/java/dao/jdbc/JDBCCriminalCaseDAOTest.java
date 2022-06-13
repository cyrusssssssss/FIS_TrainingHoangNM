package dao.jdbc;

import core.CriminalCase;
import core.enums.CaseStatus;
import core.enums.CaseType;
import dao.ICriminalCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class JDBCCriminalCaseDAOTest {
    @BeforeEach
    void init(){
        ICriminalCase criminalCaseDAO = new JDBCCriminalCaseDAO();
        CriminalCase cs = new CriminalCase();
        cs.setId(Long.parseLong("1"));
        cs.setNumber("2");
        cs.setType(CaseType.UNCATEGORIZED);
        cs.setSortDescription("huhu");
        cs.setDetailedDescription("haa");
        cs.setStatus(CaseStatus.CLOSED);
        cs.setNotes("hi");
        cs.setLeadInvestigator("123");

        criminalCaseDAO.create(cs);

        CriminalCase cs1 = new CriminalCase();
        cs1.setId(Long.parseLong("2"));
        cs1.setNumber("3");
        cs1.setType(CaseType.UNCATEGORIZED);
        cs1.setSortDescription("conan");
        cs1.setDetailedDescription("huhuhuhu");
        cs1.setStatus(CaseStatus.CLOSED);
        cs1.setNotes("hiii");
        cs1.setLeadInvestigator("124");
        criminalCaseDAO.create(cs1);
    }

    @Test
    void createCriminalCase() {
        //Arrange
        ICriminalCase criminalCaseDAO = new JDBCCriminalCaseDAO();
        CriminalCase cs = new CriminalCase();
        cs.setId(Long.parseLong("3"));
        cs.setNumber("2");
        cs.setType(CaseType.UNCATEGORIZED);
        cs.setSortDescription("huhu");
        cs.setDetailedDescription("haa");
        cs.setStatus(CaseStatus.CLOSED);
        cs.setNotes("hi");
        cs.setLeadInvestigator("123");
        //Action
        criminalCaseDAO.create(cs);
        int count = criminalCaseDAO.countT();
        //Assert
        assertEquals(2,count);

    }

    @Test
    void updateCriminalCase() {
    }

    @Test
    void deleteCriminalCase() {
        ICriminalCase criminalCaseDAO = new JDBCCriminalCaseDAO();
        criminalCaseDAO.delete(Long.parseLong("1"));
    }

    @Test
    void findCriminalCaseById() {
        ICriminalCase criminalCaseDAO = new JDBCCriminalCaseDAO();
        ArrayList<CriminalCase> list = new ArrayList<>();
        CriminalCase cs = criminalCaseDAO.findById(Long.parseLong("1"));
        list.add(cs);
        assertEquals(1,list.size());

    }

    @Test
    void getAll() {
        ICriminalCase criminalCaseDAO = new JDBCCriminalCaseDAO();

        List<CriminalCase> list = criminalCaseDAO.getAll();
        assertEquals(2,list.size());
    }
}