package fis.sprint04.controller;

import fis.sprint04.entity.CriminalCase;
import fis.sprint04.entity.Evidence;
import fis.sprint04.entity.enums.CaseStatus;
import fis.sprint04.service.CriminalCaseService;
import fis.sprint04.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ListEvidenceController {
    @Autowired
    private EvidenceService evidenceService;
    @RequestMapping(value = "/evidences/{number}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_SENIOR')")
    public ResponseEntity<List<Evidence>> getAllTutorials(@PathVariable("number") String number) {
        try {
            List<Evidence> tutorials = new ArrayList<>();
            if (number == null)
                evidenceService.findAll().forEach(tutorials::add);
            else
                evidenceService.findAllByNumber(number).forEach(tutorials::add);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
