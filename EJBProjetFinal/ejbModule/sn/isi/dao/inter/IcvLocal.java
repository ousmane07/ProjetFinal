package sn.isi.dao.inter;

import java.util.List;

import jakarta.ejb.Local;
import sn.isi.entities.CV;

@Local
public interface IcvLocal extends IRepository<CV> {
	
	public List<CV> liste();
	
	public int add (CV cv);

}
