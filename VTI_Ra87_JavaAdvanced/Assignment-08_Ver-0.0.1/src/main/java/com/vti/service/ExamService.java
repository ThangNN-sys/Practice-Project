package com.vti.service;

import com.vti.entity.Exam;
import com.vti.repository.IExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService implements IExamService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: Exam
     */

    @Autowired
    private IExamRepository repository;

    // get all
    @Override
    public List<Exam> getAllExams() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<Exam> getAllExamsPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public Exam getExamById(short id) {
        return repository.findExamById(id);
    }

    // get by duration with @Query
    @Override
    public Exam getExamByDuration(int duration) {
        return repository.findExamByDuration(duration);
    }

    // create new
    @Override
    public void createExam(Exam exam) {
        repository.save(exam);
    }

    // update duration find by id
    @Override
    public void updateExam1(short id, int newDuration) {
        Exam exam = repository.findExamById(id);
        repository.save(exam);
    }

    // update by object
    @Override
    public void updateExam2(Exam exam) {
        repository.save(exam);
    }

    // delete by id
    @Override
    public void deleteExam(short id) {
        repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isExamExistsId(short id) {
        return repository.existsById(id);
    }

    // exists by duration
    @Override
    public boolean isExamExistsDuration(int duration) {
        Exam exam = repository.findExamByDuration(duration);
        return exam != null;
        // return repository.findExamByDuration(duration) != null; // cách viết ngắn gọn
    }

}
