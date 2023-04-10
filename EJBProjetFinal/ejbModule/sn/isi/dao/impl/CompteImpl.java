package sn.isi.dao.impl;

import java.util.List;

import org.hibernate.Session;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import sn.isi.dao.inter.ICompteLocal;
import sn.isi.dao.inter.ICompteRemote;
import sn.isi.entities.Compte;

@Stateless
public class CompteImpl implements ICompteLocal, ICompteRemote {
	
	protected Session session;

	@PersistenceContext(unitName = "EJBProjetFinal")
	private EntityManager em;
	
	@Override
	public List<Compte> liste() {
		
		
		return em.createQuery("SELECT i FROM Compte i").getResultList();
	}
	
	
	 @Override
	    public Compte findByUsernameAndPassword(String username, String password) {
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<Compte> criteria = builder.createQuery(Compte.class);
	        Root<Compte> from = criteria.from(Compte.class);

	        criteria.select(from);

	        criteria.select(from);
	        criteria.where(builder.and(
	                builder.equal(from.get("username"),username.toLowerCase()) ,
	                builder.equal(from.get("password"),password.toLowerCase()))
	        );

	        return session.createQuery(criteria).getSingleResultOrNull();
	    }
	 
	 
	 
	  @Override
	    public Compte findByCompte(Compte compte) {
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<Compte> criteria = builder.createQuery(Compte.class);
	        Root<Compte> from = criteria.from(Compte.class);

	        criteria.select(from);
	        criteria.where(session.getCriteriaBuilder().equal(from.get("compte"),compte));

	        return session.createQuery(criteria).getSingleResultOrNull();
	    }
	
	
	
	
	

	@Override
	public int add(Compte compte) {
		
		int ok = 0;
		
		try {
			//em.getTransaction().begin();
			em.persist(compte);
			//em.getTransaction().commit();
			ok = 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

}
