package fis.sprint04.controller;

import fis.sprint04.entity.CriminalCase;
import fis.sprint04.entity.enums.CaseStatus;
import fis.sprint04.service.CriminalCaseService;
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
public class ListCriminalCaseByUserNameController {
    @Autowired
    private CriminalCaseService criminalCaseService;
    @RequestMapping(value = "/criminalCasesByUN/{userName}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_INSPECTOR')")
    public ResponseEntity<List<CriminalCase>> getAllTutorials(@PathVariable("userName") String userName) {
        try {
            List<CriminalCase> tutorials = new ArrayList<>();
            if (userName == null)
                criminalCaseService.findAll().forEach(tutorials::add);
            else
                criminalCaseService.findAllByUserName(userName).forEach(tutorials::add);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
