package sn.isi.dao.inter;

import java.util.List;

import jakarta.ejb.Remote;
import sn.isi.entities.CV;

@Remote
public interface IcvRemote {
	public List<CV> liste();
	
	public int add (CV cv);

}
