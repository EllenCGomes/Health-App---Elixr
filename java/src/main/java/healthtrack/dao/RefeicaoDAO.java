package healthtrack.dao;

import java.util.List;

import healthtrack.bean.Refeicao;
import healthtrack.exception.DBException;

public interface RefeicaoDAO {

	public List<Refeicao> getAll();
	
	public Refeicao getById(int id);
	
	public int insert(Refeicao refeicao)throws DBException;
	
	public int update(Refeicao refeicao)throws DBException;
			
	public int delete(Refeicao refeicao)throws DBException;
	
}
