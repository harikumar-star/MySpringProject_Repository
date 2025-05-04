package CrudSpringBootProject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

@SpringBootApplication
public class CrudSpringBootProjectApplication {

    private static final Logger logger = LogManager.getLogger(CrudSpringBootProjectApplication.class);

    public static void main(String[] args) {
       // System.out.println("Spring CrudApplication !! " + args[0]);
        SpringApplication.run(CrudSpringBootProjectApplication.class, args);
    }

}
