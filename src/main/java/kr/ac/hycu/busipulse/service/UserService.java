package kr.ac.hycu.busipulse.service;

import kr.ac.hycu.busipulse.dto.UserCreateRequest;
import kr.ac.hycu.busipulse.entity.User;
import kr.ac.hycu.busipulse.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean existsByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId).isPresent();
    }

    public void createUser(UserCreateRequest req, UUID registrantId) {
        User user = new User();
        user.setLoginId(req.getLoginId());
        user.setPasswordHash(passwordEncoder.encode(req.getPassword()));
        user.setUserName(req.getUserName());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setHireDate(req.getHireDate());
        user.setDeptId(req.getDeptId());
        user.setRoleCode(req.getRoleCode());
        user.setPosition(req.getPosition());
        user.setStatus("ACT");
        user.setUseYn("Y");
        user.setRgid(registrantId);
        user.setRgdt(OffsetDateTime.now());
        userRepository.save(user);
    }
}
