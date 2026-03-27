package kr.ac.hycu.busipulse.repository;

import kr.ac.hycu.busipulse.entity.CommonCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommonCodeRepository extends JpaRepository<CommonCode, Long> {

    List<CommonCode> findByLcodeAndUseYnOrderBySortOrd(String lcode, String useYn);
}
