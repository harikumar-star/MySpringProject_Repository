package CrudSpringBootProject.concepts;

import CrudSpringBootProject.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperExample {


    public static void main(String[] args) throws JsonProcessingException {

        //USED TO CONVERT J
        // 1.JAVA OBJ TO JSON
        // 2. JSON TO JAVA OBJ

        ObjectMapper objectMapper = new ObjectMapper();

        Employee emp = new Employee();
        emp.setId(12);
        emp.setName("hari");

        // Java object to JSON
        String json = objectMapper.writeValueAsString(emp);
        System.out.println(json); // Output: {"id":1,"name":"John"}


        // JSON to Object
        Employee userObj = objectMapper.readValue(json, Employee.class);
        System.out.println(userObj.getName()); // Output: John
    }


}
