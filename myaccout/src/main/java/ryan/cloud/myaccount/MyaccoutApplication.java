package ryan.cloud.myaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyaccoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyaccoutApplication.class, args);
    }



}
