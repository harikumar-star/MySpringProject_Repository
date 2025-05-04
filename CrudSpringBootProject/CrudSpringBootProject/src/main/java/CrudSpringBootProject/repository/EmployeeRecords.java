package CrudSpringBootProject.repository;

import CrudSpringBootProject.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRecords {


    public List<Employee> getAllEmployee();

}
