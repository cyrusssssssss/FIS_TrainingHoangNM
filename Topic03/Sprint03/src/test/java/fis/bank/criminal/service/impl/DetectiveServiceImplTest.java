package fis.bank.criminal.service.impl;


import fis.bank.criminal.entity.Detective;
import fis.bank.criminal.entity.enums.EmployeeStatus;
import fis.bank.criminal.entity.enums.Rank;
import fis.bank.criminal.service.DetectiveService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DetectiveServiceImplTest {

    @Autowired
    DetectiveService detectiveService;

    @Test
    @Order(1)
    void getALl() {
        System.out.println(detectiveService.findALl());
        assertEquals(6,detectiveService.findALl().size());
    }

    @Test
    @Order(2)
    void findById() {
        Detective detective = detectiveService.findById(1L);
        assertEquals("512334",detective.getBadgeNumber());
    }

    @Test
    @Order(3)
    void save() {

        Detective detective = new Detective();
        detective.setCreatedAt(LocalDateTime.now());
        detective.setModifiedAt(LocalDateTime.now());
        detective.setVersion(1);
        detective.setBadgeNumber("2001");
        detective.setArmed(true);
        detective.setFirstName("Ngo");
        detective.setHiringDate(LocalDateTime.now());
        detective.setLastName("Trieu");
        detective.setPassWord("229");
        detective.setRank(Rank.JUNIOR);
        detective.setStatus(EmployeeStatus.ACTIVE);
        detective.setUserName("trieuhuhu");
        detectiveService.save(detective);
        assertEquals(7,detectiveService.findALl().size());
    }

    @Test
    @Order(4)
    void deleteById() {

        detectiveService.deleteById(7L);
        assertEquals(6,detectiveService.findALl().size());
    }
}