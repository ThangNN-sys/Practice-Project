package com.vti.repository;

import com.vti.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IExamRepository extends JpaRepository<Exam, Short> {

    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: Exam
     */

    @Query("SELECT v FROM Exam v")
    List<Exam> findAll();

    @Query("SELECT v FROM Exam v WHERE v.id = :idParam")
    Exam findExamById(@Param("idParam") short id);

    @Query("SELECT v FROM Exam v WHERE v.duration = :durationParam")
    Exam findExamByDuration(@Param("durationParam") int duration);

    @Query("SELECT COUNT(e) FROM Exam e WHERE e.duration = :duration")
    int getCountOfExamCode(int duration);

}
