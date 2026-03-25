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

    @GetMapping("/dashboard/summary")
    public String dashboardSummary() {
        return "views/dashboard/summary";
    }

    @GetMapping("/schedule/calendar")
    public String scheduleCalendar() {
        return "views/schedule/calendar";
    }

    @GetMapping("/schedule/list")
    public String scheduleList() {
        return "views/schedule/list";
    }

    @GetMapping("/leave/manage")
    public String leaveManage() {
        return "views/leave/manage";
    }

    @GetMapping("/project/master")
    public String projectMaster() {
        return "views/project/master";
    }

    @GetMapping("/project/wbs_manage")
    public String projectWbsManage() {
        return "views/project/wbs_manage";
    }

    @GetMapping("/project/document")
    public String projectDocument() {
        return "views/project/document";
    }

    @GetMapping("/task/my_list")
    public String taskMyList() {
        return "views/task/my_list";
    }

    @GetMapping("/task/history")
    public String taskHistory() {
        return "views/task/history";
    }

    @GetMapping("/report/performance")
    public String reportPerformance() {
        return "views/report/performance";
    }

    @GetMapping("/board/notice")
    public String boardNotice() {
        return "views/board/notice";
    }

    @GetMapping("/board/meeting")
    public String boardMeeting() {
        return "views/board/meeting";
    }

    @GetMapping("/admin/user_manage")
    public String adminUserManage() {
        return "views/admin/user_manage";
    }

    @GetMapping("/admin/code_manage")
    public String adminCodeManage() {
        return "views/admin/code_manage";
    }
}
