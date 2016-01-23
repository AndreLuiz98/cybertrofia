package br.ifpb.edu.hibernate;

import java.util.List;

import org.hibernate.Session;

public abstract class Dao<T> {
	
	public int insert(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		session.save(entity);
		
		session.getTransaction().commit();
		session.close();
		return 0;
	}

	public void update(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		session.update(entity);

		session.getTransaction().commit();
		session.close();
	}

	public void delete(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		session.delete(entity);

		session.getTransaction().commit();
		session.close();
	}
	
	public abstract T getById(String pk);
	
	public abstract List<T> getAll();
}
