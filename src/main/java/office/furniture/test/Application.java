package office.furniture.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by artyom on 15.25.11.
 */

@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
