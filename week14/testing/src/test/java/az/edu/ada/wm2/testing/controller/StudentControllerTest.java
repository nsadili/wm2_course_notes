package az.edu.ada.wm2.testing.controller;

import az.edu.ada.wm2.testing.service.StudentService;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    StudentService service;

    @Mock
    Map<String, Object> model;

    @InjectMocks
    StudentController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void showEditForm() throws Exception {
        mockMvc.perform(get("/student/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("student"))
                .andExpect(view().name("student_form"));
    }

}