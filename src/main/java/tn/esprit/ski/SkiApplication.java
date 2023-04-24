package tn.esprit.ski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SkiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkiApplication.class, args);
    }

}
