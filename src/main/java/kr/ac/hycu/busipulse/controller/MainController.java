package kr.ac.hycu.busipulse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        // 일단 다른 화면이 생성되지 않았으므로 처음 실행 시 layout.html을 띄우도록 설정
        return "layout/layout";
    }
}
