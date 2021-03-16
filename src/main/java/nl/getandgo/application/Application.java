package nl.getandgo.application;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// is a convenience annotation that adds all of the following:
// - @Configuration : Tags the class as source of bean definitions for the application context.
// - @EnableAutoConfiguration : Tells Spring Boot to start adding beans based on classpath setting,
//                              other beans, and various property setting.For example,
//                              if "spring-webmvc" is on the class path, this annotation flags
//                              the application as a web application and activates key behaviors,
//                              such as setting up a "DispatcherServlet".
// - @ComponentScan : Tells Spring to look for other components, configurations, and services in
//                    the "com/example" package, letting it find the controllers.
public class Application {
    public static void main(String[] args) { SpringApplication.run(Application.class, args); }
 }

