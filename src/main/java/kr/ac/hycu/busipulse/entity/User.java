package kr.ac.hycu.busipulse.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "\"user\"", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID userId;

    @Column(name = "login_id", nullable = false, unique = true, length = 50)
    private String loginId;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "user_name", length = 30)
    private String userName;

    @Column(name = "email", length = 200)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "role_code")
    private Long roleCode;

    @Column(name = "position", length = 3, columnDefinition = "char(3)")
    private String position;

    @Column(name = "status", length = 3, columnDefinition = "char(3)")
    private String status;

    @Column(name = "use_yn", length = 1, columnDefinition = "char(1)")
    private String useYn = "Y";

    @Column(name = "rgid", columnDefinition = "uuid")
    private UUID rgid;

    @Column(name = "rgdt", columnDefinition = "TIMESTAMPTZ(0)")
    private OffsetDateTime rgdt;

    @Column(name = "upid", columnDefinition = "uuid")
    private UUID upid;

    @Column(name = "updt", columnDefinition = "TIMESTAMPTZ(0)")
    private OffsetDateTime updt;

    public UUID getUserId()         { return userId; }
    public String getLoginId()      { return loginId; }
    public String getPasswordHash() { return passwordHash; }
    public String getUserName()     { return userName; }
    public String getEmail()        { return email; }
    public String getPhone()        { return phone; }
    public LocalDate getHireDate()  { return hireDate; }
    public Long getDeptId()         { return deptId; }
    public Long getRoleCode()       { return roleCode; }
    public String getPosition()     { return position; }
    public String getStatus()       { return status; }
    public String getUseYn()        { return useYn; }
    public UUID getRgid()           { return rgid; }
    public OffsetDateTime getRgdt() { return rgdt; }

    public void setLoginId(String loginId)              { this.loginId = loginId; }
    public void setPasswordHash(String passwordHash)    { this.passwordHash = passwordHash; }
    public void setUserName(String userName)            { this.userName = userName; }
    public void setEmail(String email)                  { this.email = email; }
    public void setPhone(String phone)                  { this.phone = phone; }
    public void setHireDate(LocalDate hireDate)         { this.hireDate = hireDate; }
    public void setDeptId(Long deptId)                  { this.deptId = deptId; }
    public void setRoleCode(Long roleCode)              { this.roleCode = roleCode; }
    public void setPosition(String position)            { this.position = position; }
    public void setStatus(String status)                { this.status = status; }
    public void setUseYn(String useYn)                  { this.useYn = useYn; }
    public void setRgid(UUID rgid)                      { this.rgid = rgid; }
    public void setRgdt(OffsetDateTime rgdt)            { this.rgdt = rgdt; }
}
