package CrudSpringBootProject.concepts;

import CrudSpringBootProject.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public Employee getUser(Long id) {

        Employee user = userRepo.findById(id);

        System.out.println(user);

        return user;
    }


}
