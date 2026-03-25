package kr.ac.hycu.busipulse.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Authentication auth) {
        if (auth != null && auth.isAuthenticated()) {
            return "redirect:/dashboard/main";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Authentication auth) {
        if (auth != null && auth.isAuthenticated()) {
            return "redirect:/dashboard/main";
        }
        return "views/login/login";
    }

    @GetMapping("/dashboard/main")
    public String dashboardMain() {
        return "views/dashboard/main";
    }
}
