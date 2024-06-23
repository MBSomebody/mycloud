package ryan.cloud.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;


@SpringBootApplication
//@EnableDiscoveryClient
@RestController
//@RefreshScope
@EnableTransactionManagement
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}
	
	@RequestMapping("/getbyid")
    public String   getIdS(@RequestParam String id) {
		System.err.println(id);
        return "hello " + id; 
    }

	@Value("${message:aa11 default}")
	private String message;
  
	@RequestMapping("/message")
	String getMessage() {
	  return this.message;
	}
	
	@RequestMapping("/getr")
    public String   getR( ) {
         return message; 
    }

}
