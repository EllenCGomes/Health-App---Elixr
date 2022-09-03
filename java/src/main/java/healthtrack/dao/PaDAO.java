package healthtrack.dao;

import java.util.List;

import healthtrack.bean.Pa;
import healthtrack.exception.DBException;

public interface PaDAO {

	public List<Pa> getAll();
	
	public Pa getById(int id);
	
	public int insert(Pa pa)throws DBException;
	
	public int update(Pa pa)throws DBException;
	
	public int delete(Pa pa)throws DBException;
	
}
