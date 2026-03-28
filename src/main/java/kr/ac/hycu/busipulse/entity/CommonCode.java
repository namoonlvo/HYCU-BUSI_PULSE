package kr.ac.hycu.busipulse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "common_code", schema = "public")
@IdClass(CommonCodeId.class)
public class CommonCode {

    @Id
    @Column(name = "lcode", length = 10)
    private String lcode;

    @Id
    @Column(name = "scode", length = 10)
    private String scode;

    @Column(name = "sname", length = 100)
    private String codeName;

    @Column(name = "use_yn", length = 1, columnDefinition = "char(1)")
    private String useYn = "Y";

    @Column(name = "sort_order")
    private Integer sortOrd;

    public String getLcode()    { return lcode; }
    public String getScode()    { return scode; }
    public String getCodeName() { return codeName; }
    public String getUseYn()    { return useYn; }
    public Integer getSortOrd() { return sortOrd; }
}
