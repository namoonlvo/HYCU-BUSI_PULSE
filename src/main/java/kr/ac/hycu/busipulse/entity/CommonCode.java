package kr.ac.hycu.busipulse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "common_code", schema = "public")
public class CommonCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id")
    private Long codeId;

    @Column(name = "lcode", length = 10)
    private String lcode;

    @Column(name = "scode", length = 10)
    private String scode;

    @Column(name = "code_name", length = 100)
    private String codeName;

    @Column(name = "use_yn", length = 1, columnDefinition = "char(1)")
    private String useYn = "Y";

    @Column(name = "sort_ord")
    private Integer sortOrd;

    public Long getCodeId()     { return codeId; }
    public String getLcode()    { return lcode; }
    public String getScode()    { return scode; }
    public String getCodeName() { return codeName; }
    public String getUseYn()    { return useYn; }
    public Integer getSortOrd() { return sortOrd; }
}
