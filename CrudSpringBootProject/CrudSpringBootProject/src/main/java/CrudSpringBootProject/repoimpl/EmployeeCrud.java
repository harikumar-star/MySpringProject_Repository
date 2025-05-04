package CrudSpringBootProject.repoimpl;

import CrudSpringBootProject.model.Employee;
import CrudSpringBootProject.repository.EmployeeRecords;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeCrud implements EmployeeRecords {
    @Override
    public List<Employee> getAllEmployee() {

        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1, "Arun"));
        list.add(new Employee(2, "Priya"));
        list.add(new Employee(3, "Karthik"));
        list.add(new Employee(4, "Divya"));
        list.add(new Employee(5, "Vikram"));


        return list;
    }
}
