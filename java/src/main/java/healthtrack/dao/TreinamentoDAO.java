package healthtrack.dao;

import java.util.List;

import healthtrack.bean.Treinamento;
import healthtrack.exception.DBException;

public interface TreinamentoDAO {

	public List<Treinamento> getAll();
	
	public Treinamento getById(int id);
	
	public int insert(Treinamento treinamento)throws DBException;
	
	public int update(Treinamento treinamento)throws DBException;
	
	public int delete(Treinamento treinamento)throws DBException;
	
}
