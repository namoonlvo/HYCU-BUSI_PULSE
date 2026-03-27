package kr.ac.hycu.busipulse.repository;

import kr.ac.hycu.busipulse.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByUseYnOrderByDeptName(String useYn);
}
