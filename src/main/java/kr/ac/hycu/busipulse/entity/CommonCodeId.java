package kr.ac.hycu.busipulse.entity;

import java.io.Serializable;
import java.util.Objects;

public class CommonCodeId implements Serializable {

    private String lcode;
    private String scode;

    public CommonCodeId() {}

    public CommonCodeId(String lcode, String scode) {
        this.lcode = lcode;
        this.scode = scode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonCodeId that)) return false;
        return Objects.equals(lcode, that.lcode) && Objects.equals(scode, that.scode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lcode, scode);
    }
}
