package com.vti.repository;

import com.vti.entity.TypeQuestion;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TypeQuestionRep {

    private final HibernateUtils hibernateUtils;

    public TypeQuestionRep() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    // method để tạo mới 1 đối tượng vào bảng TypeQuestion
    public void createTypeQuestion(TypeQuestion typeQuestion) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create
            session.save(typeQuestion);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để lấy thông tin toàn bộ đối tượng thuộc bảng TypeQuestion
    public List<TypeQuestion> getAllTypeQuestion() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create hql query
            Query<TypeQuestion> query = session.createQuery("FROM TypeQuestion");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để lấy thông tin đối tượng thuộc bảng TypeQuestion theo ID
    public TypeQuestion getTypeQuestionById(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // get TypeQuestion by id
            TypeQuestion typeQuestion = session.get(TypeQuestion.class, id);
            return typeQuestion;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để lấy thông tin đối tượng thuộc bảng TypeQuestion theo Name
    public TypeQuestion getTypeQuestionByName(String name) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create hql query
            Query<TypeQuestion> query = session.createQuery("FROM TypeQuestion WHERE typeName = :nameParameter");
            // set parameter
            query.setParameter("nameParameter", name);
            // get result
            TypeQuestion typeQuestion = query.uniqueResult();
            return typeQuestion;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để update thông tin đối tượng thuộc bảng TypeQuestion - Cách 1
    public void updateTypeQuestion(short id, String newName) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // get typeQuestion
            TypeQuestion typeQuestion = session.load(TypeQuestion.class, id);
            // update
            typeQuestion.setTypeName(newName);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để delete thông tin đối tượng thuộc bảng typeQuestion, tìm theo ID
    public void deleteTypeQuestion(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // get typeQuestion
            TypeQuestion typeQuestion = session.load(TypeQuestion.class, id);
            // delete
            session.delete(typeQuestion);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
