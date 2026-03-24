package kr.ac.hycu.busipulse.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.Date;
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
    private Date hireDate;

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
    public Date getHireDate()       { return hireDate; }
    public Long getDeptId()         { return deptId; }
    public Long getRoleCode()       { return roleCode; }
    public String getPosition()     { return position; }
    public String getStatus()       { return status; }
    public String getUseYn()        { return useYn; }
}
