package healthtrack.dao;

import java.util.List;

import healthtrack.bean.Fc;
import healthtrack.exception.DBException;

public interface FcDAO {
	
	public List<Fc> getAll();
	
	public Fc getById(int id);
	
	public int insert(Fc fc)throws DBException;
	
	public int update(Fc fc)throws DBException;
	
	public int delete(Fc fc)throws DBException;
	
}
