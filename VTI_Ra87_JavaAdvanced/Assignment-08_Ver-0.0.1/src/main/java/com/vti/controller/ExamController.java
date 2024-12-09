package com.vti.controller;

import com.vti.entity.Exam;
import com.vti.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/exams")
public class ExamController {
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: Exam
     */

    @Autowired
    private IExamService service;

    // get all list
//    @GetMapping()
//    public List<Exam> getListExams() {
//        return service.getListExams();
//    }
    // get all paging
    @GetMapping()
    public Page<Exam> getAllExams(Pageable pageable) {
        return service.getAllExams(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public Exam getExamById(@PathVariable(name = "id") short id) {
        return service.getExamById(id);
    }

    // get by duration
    @GetMapping(value = "/duration/{duration}")
    public Exam getExamByDuration(@PathVariable(name = "duration") int duration) {
        return service.getExamByDuration(duration);
    }

    // create new
    @PostMapping()
    public void createExam(@RequestBody Exam create) {
        service.createExam(create);
    }

    // update name find by id
    @PutMapping(value = "/u1/{id}")
    public void updateExam1(@PathVariable(name = "id") short id, @RequestBody Exam update1) {
        update1.setId(id);
        service.updateExam1(id, update1.getDuration());
    }

    // update by object
    @PutMapping(value = "/u2")
    public void updateExam2(@RequestBody Exam update2) {
        service.updateExam2(update2);
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteExam(@PathVariable(name = "id") short id) {
        service.deleteExam(id);
    }

    // exists by id
    @GetMapping(value = "/exists-id/{id}")
    public boolean isExamExistId(@PathVariable(name = "id") short id) {
        return service.isExamExistId(id);
    }

    // exists by duration
    @GetMapping(value = "/exists-duration/{duration}")
    public boolean isExamExistDuration(@PathVariable(name = "duration") int duration) {
        return service.isExamExistDuration(duration);
    }

}
