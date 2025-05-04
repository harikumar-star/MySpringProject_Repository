package CrudSpringBootProject.concepts;

import CrudSpringBootProject.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepo {

   public Employee findById(Long id) {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("hari");
        return emp;
    }
    

}
