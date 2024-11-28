package com.vti.entity.generator;

import com.vti.entity.Exam;
import com.vti.repository.IExamRepository;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ExamCodeGenerator implements IdentifierGenerator {
    private final IExamRepository examRepository;

    @Autowired
    public ExamCodeGenerator(IExamRepository repository) {
        this.examRepository = repository;
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

        Exam exam = (Exam) object;
        String prefix;

        if (exam.getDuration() >= 180) {
            prefix = "L";
        } else if (exam.getDuration() >= 90) {
            prefix = "M";
        } else {
            prefix = "S";
        }

        int count = examRepository.getCountOfExamCode(exam.getDuration());

        return prefix + "-" + (count + 1);
    }
}
