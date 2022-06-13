package dao.jdbc;

import core.CriminalCase;
import core.Detective;
import core.enums.CaseStatus;
import core.enums.CaseType;
import core.enums.EmployeeStatus;
import core.enums.Rank;
import dao.ICriminalCase;
import dao.IDetective;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class JDBCDetectiveDAOTest {
    @BeforeEach
    void init(){
        IDetective detectiveDAO = new JDBCDetectiveDAO();
        Detective cs = new Detective();
        cs.setId(Long.parseLong("1"));
        cs.setUserName("haha");
        cs.setFirstName("huhu");
        cs.setLastName("haha");
        cs.setPassWord("huhu");
        cs.setHiringDate(LocalDateTime.parse("2022-09-04T13:45:30"));
        cs.setBadgeNumber("1");
        cs.setRank(Rank.CHIEF_INSPECTOR);
        cs.setArmed(Boolean.parseBoolean("1"));
        cs.setStatus(EmployeeStatus.SUSPENDED);
        cs.setIdCriminal(Long.parseLong("1"));
        detectiveDAO.create(cs);

        Detective cs1 = new Detective();
        cs1.setId(Long.parseLong("2"));
        cs1.setUserName("haha");
        cs1.setFirstName("huhu");
        cs1.setLastName("haha");
        cs1.setPassWord("huhu");
        cs1.setHiringDate(LocalDateTime.parse("2022-09-04T13:45:30"));
        cs1.setBadgeNumber("1");
        cs1.setRank(Rank.CHIEF_INSPECTOR);
        cs1.setArmed(Boolean.parseBoolean("1"));
        cs1.setStatus(EmployeeStatus.SUSPENDED);
        cs1.setIdCriminal(Long.parseLong("1"));
        detectiveDAO.create(cs1);
    }

    @Test
    void create() {
        IDetective detectiveDAO = new JDBCDetectiveDAO();
        Detective cs1 = new Detective();
        cs1.setId(Long.parseLong("3"));
        cs1.setUserName("haha");
        cs1.setFirstName("huhu");
        cs1.setLastName("haha");
        cs1.setPassWord("huhu");
        cs1.setHiringDate(LocalDateTime.parse("2022-09-04T13:45:30"));
        cs1.setBadgeNumber("1");
        cs1.setRank(Rank.CHIEF_INSPECTOR);
        cs1.setArmed(Boolean.parseBoolean("1"));
        cs1.setStatus(EmployeeStatus.SUSPENDED);
        cs1.setIdCriminal(Long.parseLong("1"));
        detectiveDAO.create(cs1);
        int count = detectiveDAO.countT();
        //Assert
        assertEquals(3,count);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findById() {
    }

    @Test
    void getAll() {
    }
}