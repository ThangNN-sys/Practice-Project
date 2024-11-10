package com.vti.repository;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupRep {

    private final HibernateUtils hibernateUtils;

    public GroupRep() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    // method để tạo mới 1 đối tượng vào bảng Group
    public void createGroup(Group group) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create
            session.save(group);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để lấy thông tin toàn bộ đối tượng thuộc bảng Group
    public List<Group> getAllGroups() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create hql query
            Query<Group> query = session.createQuery("FROM Group");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để lấy thông tin đối tượng thuộc bảng Group theo ID
    public Group getGroupByID(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // get department by id
            Group group = session.get(Group.class, id);
            return group;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để lấy thông tin toàn đối tượng thuộc bảng Group theo Name
    public Group getGroupByName(String name) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create hql query
            Query<Group> query = session.createQuery("FROM Group WHERE name = :nameParameter");
            // set parameter
            query.setParameter("nameParameter", name);
            // get result
            Group group = query.uniqueResult();
            return group;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để update thông tin đối tượng thuộc bảng Group - Cách 1
    public void updateGroup(short id, String newName) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // get group
            Group group = session.load(Group.class, id);
            // update
            group.setName(newName);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để update thông tin đối tượng thuộc bảng Group - Cách 2
    public void updateGroup(Group group) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // update
            session.update(group);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để delete thông tin đối tượng thuộc bảng Group, tìm theo ID
    public void deleteGroup(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // get group
            Group group = session.load(Group.class, id);
            // delete
            session.delete(group);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // method để kiểm tra và lấy thông tin đối tượng thuộc bảng Group, tìm theo ID
    public boolean isGroupExistsByID(short id) {
        // get department
        Group group = getGroupByID(id);
        // return result
        return group != null;
    }

    // method để kiểm tra và lấy thông tin đối tượng thuộc bảng Group, tìm theo Name
    public boolean isGroupExistsByName(String name) {
        Group group = getGroupByName(name);
        return group != null;
    }

}
