package ryan.cloud.bizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ryan.cloud.bizapp.service.UserService;

@RestController
public class BizController {

    @Autowired
    private UserService userService;


    @RequestMapping("/getbyid")
    public String   getIdS(@RequestParam String id) {
        // return "hello " + id;
        System.err.println(id);
        return userService.findAll().toString();
    }

}
