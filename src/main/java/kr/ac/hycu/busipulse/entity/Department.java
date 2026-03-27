package kr.ac.hycu.busipulse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "department", schema = "public")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "dept_name", length = 100)
    private String deptName;

    @Column(name = "use_yn", length = 1, columnDefinition = "char(1)")
    private String useYn = "Y";

    public Long getDeptId()   { return deptId; }
    public String getDeptName() { return deptName; }
    public String getUseYn()  { return useYn; }
}
