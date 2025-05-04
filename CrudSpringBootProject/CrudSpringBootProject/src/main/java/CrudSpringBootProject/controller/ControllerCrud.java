package CrudSpringBootProject.controller;

import CrudSpringBootProject.model.Employee;
import CrudSpringBootProject.repoimpl.EmployeeCrud;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("crud")
public class ControllerCrud {

    EmployeeCrud empCrud;

    @Value("${app.name}")
    private String appName;


    public ControllerCrud(EmployeeCrud empCrud) {
        this.empCrud = empCrud;
    }

    @PostMapping("/getEmployeeAll")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        System.out.println("The appName ==" + appName);
        List<Employee> list = empCrud.getAllEmployee();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/gets")
    public ResponseEntity<String> showTheContent() {
        //System.out.println("getting iinside the controller");
        String response = "getting the value from the controller";
        // return ResponseEntity.ok(response,;
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "value123");
        return new ResponseEntity<>(response, headers, HttpStatus.BAD_GATEWAY);

    }
}
