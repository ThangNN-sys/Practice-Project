package com.vti.service;

import com.vti.entity.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IExamService {

    List<Exam> getListExams();

    Page<Exam> getAllExams(Pageable pageable);

    Exam getExamById(short id);

    Exam getExamByDuration(int duration);

    void createExam(Exam exam);

    void updateExam1(short id, int newDuration);

    void updateExam2(Exam exam);

    void deleteExam(short id);

    boolean isExamExistId(short id);

    boolean isExamExistDuration(int duration);

}
