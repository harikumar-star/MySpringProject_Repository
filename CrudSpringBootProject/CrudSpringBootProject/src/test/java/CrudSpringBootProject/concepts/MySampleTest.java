package CrudSpringBootProject.concepts;

import CrudSpringBootProject.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MySampleTest {

    @Mock
    UserRepo userrepo;

    @InjectMocks
    UserService userService;


    //UserService and userRepo
    @Test
    public void getUserTest() {
        when(userrepo.findById(1L)).thenReturn(new Employee(1, "hari"));
        Employee e = userService.getUser(1L);
        assertEquals("hari", e.getName());
        assertEquals(1L, e.getId());
        assertNotNull("Employee should not be null", e);


    }


}



