package kr.ac.hycu.busipulse.dto;

import java.time.LocalDate;

public class UserCreateRequest {

    private String loginId;
    private String password;
    private String userName;
    private String email;
    private String phone;
    private LocalDate hireDate;
    private Long deptId;
    private Long roleCode;
    private String position;

    public String getLoginId()    { return loginId; }
    public String getPassword()   { return password; }
    public String getUserName()   { return userName; }
    public String getEmail()      { return email; }
    public String getPhone()      { return phone; }
    public LocalDate getHireDate(){ return hireDate; }
    public Long getDeptId()       { return deptId; }
    public Long getRoleCode()     { return roleCode; }
    public String getPosition()   { return position; }

    public void setLoginId(String loginId)       { this.loginId = loginId; }
    public void setPassword(String password)     { this.password = password; }
    public void setUserName(String userName)     { this.userName = userName; }
    public void setEmail(String email)           { this.email = email; }
    public void setPhone(String phone)           { this.phone = phone; }
    public void setHireDate(LocalDate hireDate)  { this.hireDate = hireDate; }
    public void setDeptId(Long deptId)           { this.deptId = deptId; }
    public void setRoleCode(Long roleCode)       { this.roleCode = roleCode; }
    public void setPosition(String position)     { this.position = position; }
}
