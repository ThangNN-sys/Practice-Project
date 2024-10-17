package com.vti.utils;

import com.vti.entity.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Department;

public class HibernateUtils {

	private static HibernateUtils instance;

	private Configuration configuration;
	private SessionFactory sessionFactory;

	// Tạo singleton pattern cho đối tượng HibernateUtils
	public static HibernateUtils getInstance() {
		if (null == instance) {
			instance = new HibernateUtils();
		}
		return instance;
	}

	// hàm contractor cho class HibernateUtils
	private HibernateUtils() {
		configure();
	}

	// Phương thức configure() để load các config ở file hibernate.cfg.xml
	private void configure() {
		// khởi tạo configuration và tải configuration với nguồn từ file hibernate.cfg.xml
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		// add entity
		configuration.addAnnotatedClass(Department.class);
		configuration.addAnnotatedClass(Group.class);
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
