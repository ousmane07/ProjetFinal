package sn.isi.dao.impl;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import sn.isi.dao.inter.IcvLocal;
import sn.isi.dao.inter.IcvRemote;
import sn.isi.entities.CV;
import sn.isi.entities.Compte;

@Stateless
public class CVImpl implements IcvLocal, IcvRemote {
	
	@PersistenceContext(unitName = "EJBProjetFinal")
	private EntityManager em;
	
	@Override
	public List<CV> liste() {
		
		
		return em.createQuery("SELECT i FROM CV i").getResultList();
	}
	
	@Override
	public int add(CV cv) {
		
		int ok = 0;
		
		try {
			//em.getTransaction().begin();
			em.persist(cv);
			//em.getTransaction().commit();
			ok = 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	
	
	@Override
	public void beginSession() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(int id, CV t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CV t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CV> list(CV t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CV get(int id, CV t) {
		// TODO Auto-generated method stub
		return null;
	}



	

}
