package ryan.cloud.myaccout.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ryan.cloud.myaccout.service.AuthService;

@Controller
public class RegistrationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        authService.saveUser(username, password, "USER");
        return "redirect:/login";
    }
}