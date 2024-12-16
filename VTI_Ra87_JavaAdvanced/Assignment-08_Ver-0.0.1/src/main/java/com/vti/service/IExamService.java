package com.vti.service;

import com.vti.entity.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IExamService {

    List<Exam> getAllExams();

    Page<Exam> getAllExamsPaging(Pageable pageable);

    Exam getExamById(short id);

    Exam getExamByDuration(int duration);

    void createExam(Exam exam);

    void updateExam1(short id, int newDuration);

    void updateExam2(Exam exam);

    void deleteExam(short id);

    boolean isExamExistsId(short id);

    boolean isExamExistsDuration(int duration);

}
