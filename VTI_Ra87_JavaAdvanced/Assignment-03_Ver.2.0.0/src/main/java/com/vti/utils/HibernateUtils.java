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

	/**
	 * This method is design pattern singleton to get object HibernateUtil.
	 * @return Instance of ManagerHibernate
	 */
	public static HibernateUtils getInstance() {
		if (null == instance) {
			instance = new HibernateUtils();
		}
		return instance;
	}

	/**
	 * Constructor for class HibernateUtils.
	 */
	private HibernateUtils() {
		configure();
	}

	/**
	 * This method is created configuration object.
	 */
	private void configure() {
		// load configuration
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// add entity
		configuration.addAnnotatedClass(Address.class);
		configuration.addAnnotatedClass(DetailDepartment.class);
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Group.class);
		configuration.addAnnotatedClass(GroupAccount.class);
		configuration.addAnnotatedClass(Manager.class);
		configuration.addAnnotatedClass(Department.class);
		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(Salary.class);
		configuration.addAnnotatedClass(Position.class);
		configuration.addAnnotatedClass(Exam.class);
		configuration.addAnnotatedClass(CategoryQuestion.class);
	}

	/**
	 * This method is got SessionFactory.
	 */
	private SessionFactory buildSessionFactory() {
		if (null == sessionFactory || sessionFactory.isClosed()) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}

		return sessionFactory;
	}

	/**
	 * This method closes Factory session .
	 */
	public void closeFactory() {
		if (null != sessionFactory && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}

	/**
	 * This method is opened session from SessionFactory.
	 */
	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();
	}

}
