package healthtrack.dao;

import java.util.List;

import healthtrack.bean.Exercicio;
import healthtrack.exception.DBException;

public interface ExercicioDAO {
	
	public List<Exercicio> getAll();
	
	public Exercicio getById(int id);
	
	public int insert(Exercicio exercicio)throws DBException;
	
	public int update(Exercicio exercicio)throws DBException;
	
	public int delete(Exercicio exercicio)throws DBException;
	
}
