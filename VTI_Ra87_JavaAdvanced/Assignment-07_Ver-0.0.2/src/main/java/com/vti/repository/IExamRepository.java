package com.vti.repository;

import com.vti.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IExamRepository extends JpaRepository<Exam, Integer> {

    @Query("SELECT COUNT(e) FROM Exam e WHERE e.duration = :duration")
    int getCountOfExamCode(int duration);

}
