package ryan.cloud.myclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class MyclientApplication {
	@Autowired
	private  HelloClient fclient;

	public static void main(String[] args) {
		SpringApplication.run(MyclientApplication.class, args);
	}

	@RequestMapping("/getbyid")
    public String   getIdS(@RequestParam String id) {
		System.err.println("clt"+id);
        return fclient.getIdS(id); 
    }

}
