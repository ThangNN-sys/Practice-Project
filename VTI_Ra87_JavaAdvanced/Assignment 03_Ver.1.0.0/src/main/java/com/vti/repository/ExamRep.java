package com.vti.repository;

import com.vti.entity.Exam;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ExamRep {

    private final HibernateUtils hibernateUtils;

    public ExamRep() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    // method để tạo mới 1 đối tượng vào bảng Exam
    public void createExam(Exam exam) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // create
            session.save(exam);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để lấy thông tin toàn bộ đối tượng thuộc bảng Exam
    public List<Exam> getAllExams() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create hql query
            Query<Exam> query = session.createQuery("FROM Exam");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để đếm toàn bộ đối tượng thuộc bảng Exam
    public short getCountOfExamCode(short duration) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            String sql;
            if (duration >= 180) {
                sql = "SELECT COUNT(1) FROM Exam WHERE Duration >= 180";
            } else if (duration >= 90) {
                sql = "SELECT COUNT(1) FROM Exam WHERE Duration >= 90 AND Duration < 180";
            } else {
                sql = "SELECT COUNT(1) FROM Exam WHERE Duration < 90";
            }
            // create hql query
            Query<Long> query = session.createQuery(sql);
            // get result
            return query.uniqueResult().shortValue();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để lấy thông tin đối tượng thuộc bảng Exam theo ID
    public Exam getExamByID(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // get exam by id
            Exam exam = session.get(Exam.class, id);
            return exam;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để lấy thông tin đối tượng thuộc bảng Exam theo Code 1
    public Exam getExamByCode1(String code1) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // get exam by code 1
            Exam exam = session.get(Exam.class, code1);
            return exam;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để lấy thông tin đối tượng thuộc bảng Exam theo Code 2
    public Exam getExamByCode2(String code2) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // get exam by code 2
            Exam exam = session.get(Exam.class, code2);
            return exam;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để lấy thông tin đối tượng thuộc bảng Exam theo Title
    public Exam getExamByTitle(String title) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // get exam by title
            Exam exam = session.get(Exam.class, title);
            return exam;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để lấy thông tin đối tượng thuộc bảng Exam theo Duration
    public Exam getExamByDuration(short duration) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // get exam by duration
            Exam exam = session.get(Exam.class, duration);
            return exam;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để update thông tin đối tượng thuộc bảng Exam - Cách 1
    public void updateExam(short id, String newTitle, short newDuration) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // get exam
            Exam exam = session.load(Exam.class, id);
            // update
            exam.setTitle(newTitle);
            exam.setDuration(newDuration);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để delete thông tin đối tượng thuộc bảng Exam, tìm theo ID
    public void deleteExam(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // get exam
            Exam exam = session.load(Exam.class, id);
            // delete
            session.delete(exam);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để kiểm tra và lấy thông tin đối tượng thuộc bảng Exam, tìm theo ID
    public boolean isExamExistsByID(short id) {
        // get exam
        Exam exam = getExamByID(id);
        // return result
        return exam != null;
    }
}
