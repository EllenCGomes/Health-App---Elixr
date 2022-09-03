package healthtrack.dao;

import java.util.List;

import healthtrack.bean.Ingrediente;
import healthtrack.exception.DBException;

public interface IngredienteDAO {

	public List<Ingrediente>getAll();
	
	public Ingrediente getById(int id);
	
	public int insert(Ingrediente ingrediente)throws DBException;
	
	public int update(Ingrediente ingrediente)throws DBException;
	
	public int delete(Ingrediente ingrediente)throws DBException;
	
}
