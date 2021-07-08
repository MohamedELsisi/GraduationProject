package com.graduation.demo.Dao;

import com.graduation.demo.Model.Exam;
import com.graduation.demo.Model.LevelAndDep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssignDepartmentRepository extends JpaRepository<LevelAndDep,Long> {

    @Query(value = "SELECT * FROM level_and_dep WHERE department_id=?1 AND level_id=?2", nativeQuery = true)
    LevelAndDep findByDepartmentAndLevel(int department_id,int level_id);

}
