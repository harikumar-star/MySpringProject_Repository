package SpringCore;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("SingletonBean instance created: " + this);
    }
}
