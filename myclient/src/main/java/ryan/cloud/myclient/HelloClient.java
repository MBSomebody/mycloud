package ryan.cloud.myclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "myapp")
public interface HelloClient {

    @GetMapping("/getbyid")
    public String   getIdS(@RequestParam String id);
}
