package com.vti.repository;

import com.vti.entity.Answer;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AnswerRep {

    private final HibernateUtils hibernateUtils;

    public AnswerRep() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    // 1 - Method để tạo mới 1 đối tượng vào bảng Answer
    public void createAnswer(Answer answer) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create
            session.save(answer);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // 2 - Method để lấy thông tin toàn bộ đối tượng thuộc bảng Answer
    public List<Answer> getAllAnswers() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create hql query
            Query<Answer> query = session.createQuery("FROM Answer");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // 3 - Method để lấy thông tin đối tượng thuộc bảng Answer theo ID
    public Answer getAnswerByID(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // get department by id
            Answer answer = session.get(Answer.class, id);
            return answer;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // 4 - Method để update thông tin đối tượng thuộc bảng Answer - Cách 1
    public void updateAnswer(short id, String content, Boolean isCorrect) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // get answer
            Answer answer = session.load(Answer.class, id);
            // update
            answer.setContent(content);
            answer.setCorrect(isCorrect);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // 5 - Method để delete thông tin đối tượng thuộc bảng Answer, tìm theo ID
    public void deleteAnswer(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // get Answer
            Answer answer = session.load(Answer.class, id);
            // delete
            session.delete(answer);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
