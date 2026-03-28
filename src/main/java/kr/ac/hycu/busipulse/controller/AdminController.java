package kr.ac.hycu.busipulse.controller;

import kr.ac.hycu.busipulse.dto.UserCreateRequest;
import kr.ac.hycu.busipulse.entity.User;
import kr.ac.hycu.busipulse.repository.CommonCodeRepository;
import kr.ac.hycu.busipulse.repository.DepartmentRepository;
import kr.ac.hycu.busipulse.repository.UserRepository;
import kr.ac.hycu.busipulse.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final CommonCodeRepository commonCodeRepository;

    public AdminController(UserService userService,
                           UserRepository userRepository,
                           DepartmentRepository departmentRepository,
                           CommonCodeRepository commonCodeRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
        this.commonCodeRepository = commonCodeRepository;
    }

    @GetMapping("/user_manage")
    public String userManage(Model model) {
        model.addAttribute("departments", departmentRepository.findByUseYnOrderByDeptName("Y"));
        model.addAttribute("roleCodes", commonCodeRepository.findByLcodeAndUseYnOrderBySortOrder("05", "Y"));
        return "views/admin/user_manage";
    }

    @GetMapping("/code_manage")
    public String codeManage() {
        return "views/admin/code_manage";
    }

    /** 아이디 중복 확인 */
    @GetMapping("/user/check-id")
    @ResponseBody
    public ResponseEntity<Map<String, Boolean>> checkLoginId(@RequestParam String loginId) {
        boolean exists = userService.existsByLoginId(loginId);
        return ResponseEntity.ok(Map.of("exists", exists));
    }

    /** 사용자 등록 */
    @PostMapping("/user/create")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> createUser(
            @RequestBody UserCreateRequest req,
            Authentication auth) {

        if (userService.existsByLoginId(req.getLoginId())) {
            return ResponseEntity.badRequest()
                    .body(Map.of("success", false, "message", "이미 사용 중인 아이디입니다."));
        }

        // 현재 로그인 사용자의 UUID 조회
        UUID registrantId = userRepository.findByLoginId(auth.getName())
                .map(User::getUserId)
                .orElse(null);

        userService.createUser(req, registrantId);
        return ResponseEntity.ok(Map.of("success", true));
    }
}
