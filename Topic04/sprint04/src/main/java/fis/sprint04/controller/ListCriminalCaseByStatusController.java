package fis.sprint04.controller;

import fis.sprint04.entity.CriminalCase;
import fis.sprint04.entity.enums.CaseStatus;
import fis.sprint04.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ListCriminalCaseByStatusController {
    @Autowired
    private CriminalCaseService criminalCaseService;
    @RequestMapping(value = "/criminalCasesByS/{status}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_CHIEF_INSPECTOR')")
    public ResponseEntity<List<CriminalCase>> getAllTutorials(@PathVariable("status") String status) {
        try {
            List<CriminalCase> tutorials = new ArrayList<>();
            if (status == null)
                criminalCaseService.findAll().forEach(tutorials::add);
            else
                criminalCaseService.findAllByStatus(CaseStatus.valueOf(status)).forEach(tutorials::add);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
