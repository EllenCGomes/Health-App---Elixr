package healthtrack.dao;

import java.util.List;

import healthtrack.bean.Ocupacao;
import healthtrack.exception.DBException;

public interface OcupacaoDAO {

	public List<Ocupacao> getAll();
	
	public Ocupacao getById(int id);
	
	public int insert(Ocupacao ocupacao)throws DBException;
	
	public int update(Ocupacao ocupacao)throws DBException;
	
	public int delete(Ocupacao ocupacao)throws DBException;
	
}
