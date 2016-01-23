package br.ifpb.edu.entidades;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.ifpb.edu.hibernate.*;

public class PessoaDAO extends Dao<Pessoa> {

	@Override
	public Pessoa getById(String pk) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Pessoa pessoa = session.get(Pessoa.class, pk);

		session.getTransaction().commit();
		session.close();

		return pessoa;
	}

	@Override
	public List<Pessoa> getAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.getNamedQuery("Pessoa.getAll");

		@SuppressWarnings("unchecked")
		List<Pessoa> pessoas = query.list();

		session.getTransaction().commit();
		session.close();

		return pessoas;
	}	
}