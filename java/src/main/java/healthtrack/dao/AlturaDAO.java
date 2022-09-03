package healthtrack.dao;

import java.util.List;

import healthtrack.bean.Altura;
import healthtrack.exception.DBException;

public interface AlturaDAO {
	
	public List<Altura>getAll();
	
	public Altura getById(int id);
	
	public int insert(Altura altura) throws DBException;
	
	public int update(Altura altura)throws DBException;
	
	public int delete(Altura altura)throws DBException;
	
}
