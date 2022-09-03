package healthtrack.dao;

import java.util.List;

import healthtrack.bean.Peso;
import healthtrack.exception.DBException;

public interface PesoDAO {
	
	public List<Peso> getAll();

	public Peso getById(int id);
	
	public int insert(Peso peso)throws DBException;
	
	public int update(Peso peso)throws DBException;

	public int delete(Peso peso)throws DBException;
	
}
