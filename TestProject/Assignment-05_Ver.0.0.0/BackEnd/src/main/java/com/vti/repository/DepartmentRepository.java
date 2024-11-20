package com.vti.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;

@Repository
public class DepartmentRepository implements IDepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartments() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department ORDER BY id");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Department getDepartmentByID(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Department department = session.get(Department.class, id);

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Department getDepartmentByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Department department = query.uniqueResult();

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(int id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// update
			department.setName(newName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteDepartment(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// delete
			session.delete(department);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isDepartmentExistsByID(int id) {

		// get department
		Department department = getDepartmentByID(id);

		// return result
		if (department == null) {
			return false;
		}

		return true;
	}

	public boolean isDepartmentExistsByName(String name) {
		Department department = getDepartmentByName(name);

		if (department == null) {
			return false;
		}
		return true;
	}

	@Override
	public Department findByName(String name) {
		return null;
	}

	@Override
	public Page<Department> findByName(String name, Pageable pageable) {
		return null;
	}

	@Override
	public List<Department> findAll() {
		return List.of();
	}

	@Override
	public List<Department> findAll(Sort sort) {
		return List.of();
	}

	@Override
	public Page<Department> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public List<Department> findAllById(Iterable<Integer> iterable) {
		return List.of();
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Integer integer) {

	}

	@Override
	public void delete(Department department) {

	}

	@Override
	public void deleteAll(Iterable<? extends Department> iterable) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public <S extends Department> S save(S s) {
		return null;
	}

	@Override
	public <S extends Department> List<S> saveAll(Iterable<S> iterable) {
		return List.of();
	}

	@Override
	public Optional<Department> findById(Integer integer) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer integer) {
		return false;
	}

	@Override
	public void flush() {

	}

	@Override
	public <S extends Department> S saveAndFlush(S s) {
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Department> iterable) {

	}

	@Override
	public void deleteAllInBatch() {

	}

	@Override
	public Department getOne(Integer integer) {
		return null;
	}

	@Override
	public <S extends Department> Optional<S> findOne(Example<S> example) {
		return Optional.empty();
	}

	@Override
	public <S extends Department> List<S> findAll(Example<S> example) {
		return List.of();
	}

	@Override
	public <S extends Department> List<S> findAll(Example<S> example, Sort sort) {
		return List.of();
	}

	@Override
	public <S extends Department> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends Department> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends Department> boolean exists(Example<S> example) {
		return false;
	}
}
