package sn.isi.dao.inter;

import java.util.List;

import jakarta.ejb.Remote;
import sn.isi.entities.Compte;

@Remote
public interface ICompteRemote {
public List<Compte> liste();
	
	public int add (Compte compte);
	
	public Compte findByUsernameAndPassword(String username, String password);
	
	public Compte findByCompte(Compte compte);

}
