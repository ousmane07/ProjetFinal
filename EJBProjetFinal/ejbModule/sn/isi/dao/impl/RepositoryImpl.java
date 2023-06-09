package sn.isi.dao.impl;

import java.util.List;

import org.hibernate
.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import sn.isi.dao.inter.IRepository;

public class RepositoryImpl<T> implements IRepository<T>  {
	
	
	  protected Session session;

	    protected Transaction transaction;
	    
	    public RepositoryImpl () {
	    	 this.beginSession();
	         transaction = null;
	    }

	@Override
	public void beginSession() {
	      SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	        session = sessionFactory.openSession();
		
	}

	@Override
	public int add(T t) {
        transaction = session.beginTransaction();
        session.persist(t);
        transaction.commit();

        return 1;
        
	}

	@Override
	public int delete(int id, T t) {
	     transaction = session.beginTransaction();
	        session.remove(session.get(t.getClass(), id));
	        transaction.commit();
	        return 1;
	}

	@Override
	public int update(T t) {
		  transaction = session.beginTransaction();
	        session.merge(t);
	        transaction.commit();
	        return 1;
	}

	@Override
	public List<T> list(T t) {
	      this.beginSession();

	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        @SuppressWarnings("unchecked")
	        CriteriaQuery<T> criteria = (CriteriaQuery<T>) builder.createQuery(t.getClass());
	        @SuppressWarnings("unchecked")
	        Root<T> contactRoot = (Root<T>) criteria.from(t.getClass());

	        criteria.select(contactRoot);
	        return session.createQuery(criteria).getResultList();
	}

	@Override
	public T get(int id, T t) {
		// TODO Auto-generated method stub
		return null;
	}

}
