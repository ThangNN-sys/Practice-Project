package com.vti.utils;

import com.vti.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    private static HibernateUtils instance;

    private Configuration configuration;
    private SessionFactory sessionFactory;

    // hàm contractor cho class HibernateUtils
    private HibernateUtils() {
        configure();
    }

    // Tạo singleton pattern cho đối tượng HibernateUtils
    public static HibernateUtils getInstance() {
        if (null == instance) {
            instance = new HibernateUtils();
        }
        return instance;
    }

    // Phương thức configure() để load các config ở file hibernate.cfg.xml
    private void configure() {
        // khởi tạo configuration và tải configuration với nguồn từ file hibernate.cfg.xml
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        // add entity, phải thực hiện với toàn bộ các class
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Answer.class);
        configuration.addAnnotatedClass(CategoryQuestion.class);
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(DetailDepartment.class);
        configuration.addAnnotatedClass(Exam.class);
        configuration.addAnnotatedClass(Group.class);
        configuration.addAnnotatedClass(Position.class);
        configuration.addAnnotatedClass(Question.class);
        configuration.addAnnotatedClass(Salary.class);
        configuration.addAnnotatedClass(TypeQuestion.class);
    }

    // phương thức buildSessionFactory
    private SessionFactory buildSessionFactory() {
        if (null == sessionFactory || sessionFactory.isClosed()) {
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    // phương thức đóng SessionFactory
    public void closeFactory() {
        if (null != sessionFactory && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }

    // phương thức để mở 1 Session mới từ SessionFactory (luôn open ra 1 new session)
    public Session openSession() {
        buildSessionFactory();
        return sessionFactory.openSession();
    }

}
