package ryan.cloud.myaccount.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ryan.cloud.myaccount.service.AuthService;



@Controller
public class RegistrationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/hh")
    public String hh(@RequestParam String username, @RequestParam String password, Model model) {
        System.out.println("register " + username);
        authService.saveUser(username, password, "USER");
        model.addAttribute("username", username);
        return "redirect:/login"; // 返回视图名称
    }
}