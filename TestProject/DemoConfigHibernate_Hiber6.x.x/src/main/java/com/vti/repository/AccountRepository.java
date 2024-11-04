package com.vti.repository;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AccountRepository {

    private HibernateUtils hibernateUtils;

    public AccountRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Account> getAllAccounts() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Account> query = session.createQuery("FROM Account");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createAccount(Account Account) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // create
            session.save(Account);

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
