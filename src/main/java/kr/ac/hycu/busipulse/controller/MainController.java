package kr.ac.hycu.busipulse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "layout/layout";
    }

    @GetMapping("/login")
    public String login() {
        return "views/login/login";
    }
}
