package sn.isi.dao.inter;

import java.util.List;

import jakarta.ejb.Local;
import sn.isi.entities.Compte;

@Local
public interface ICompteLocal {
	
	public List<Compte> liste();
	
	public int add (Compte compte);
	
	public Compte findByUsernameAndPassword(String username, String password);
	
	public Compte findByCompte(Compte compte);

}
