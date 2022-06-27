package fis.sprint04.controller;

import fis.sprint04.service.CriminalCaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ListCriminalCaseByStatusControllerTest {
    @InjectMocks
    ListCriminalCaseByStatusController listCriminalCaseByStatusController;
    @MockBean
    CriminalCaseService criminalCaseService;

    private MockMvc mockMvc;
    @Autowired
    public ListCriminalCaseByStatusControllerTest(MockMvc mockMvc){
        this.mockMvc=mockMvc;
    }
    @Test
    @WithMockUser(roles={"ROLE_CHIEF_INSPECTOR"})
    void getAllTutorials() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/criminalCases/COLD")
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print()).andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}