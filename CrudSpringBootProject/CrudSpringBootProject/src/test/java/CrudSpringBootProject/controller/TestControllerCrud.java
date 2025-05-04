package CrudSpringBootProject.controller;


import CrudSpringBootProject.model.Employee;
import CrudSpringBootProject.repoimpl.EmployeeCrud;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class TestControllerCrud {
    private MockMvc mockMvc;

    @Mock
    private EmployeeCrud empCrud;

    @InjectMocks
    private ControllerCrud controllerCrud;

    private List<Employee> employeeList;

    @Before
    public void setup() throws IOException { // 5
        mockMvc = MockMvcBuilders.standaloneSetup(controllerCrud).build();
        // Read JSON into employeeList
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = getClass().getClassLoader().getResourceAsStream("employees.json");
        employeeList = mapper.readValue(is, new TypeReference<List<Employee>>() {});
        System.out.println("The emp list =="+employeeList);
    }

    @Test
    public void testGetAllEmployee() throws Exception {
        // Mocking the service to return employeeList
        when(empCrud.getAllEmployee()).thenReturn(employeeList);
        // Perform the API call
        mockMvc.perform(post("/crud/getEmployeeAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Loop through the employeeList and dynamically check each value
                .andExpect(result -> {
                    for (int i = 0; i < employeeList.size(); i++) {
                        // Dynamic check for each employee in the list
                        result.getResponse().getContentAsString().contains(
                                "\"id\":" + employeeList.get(i).getId()
                        );
                        result.getResponse().getContentAsString().contains(
                                "\"name\":\"" + employeeList.get(i).getName() + "\""
                        );
                    }
                });
    }

    @Test
    public void testShowTheContent() throws Exception { // 6
        mockMvc.perform(get("/crud/gets"))
                .andExpect(status().isBadGateway())
               // .andExpect(status().isOk()) // fail case
                .andExpect(header().string("X-Custom-Header", "value123"))
                .andExpect(content().string("getting the value from the controller"));
    }


}
