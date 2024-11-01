package com.vti.entity.generator;

import com.vti.entity.Exam;
import com.vti.repository.ExamRep;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class ExamCodeGenerator implements IdentifierGenerator {

	private ExamRep repository;

	public ExamCodeGenerator() {
		repository = new ExamRep();
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

		int count = repository.getCountOfExamCode(exam.getDuration());

		return prefix + "-" + (count + 1);
	}

}
