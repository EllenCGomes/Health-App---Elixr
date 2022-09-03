package healthtrack.dao;

import java.util.List;

import healthtrack.bean.Conta;
import healthtrack.exception.DBException;

public interface ContaDAO {

	public List<Conta> getAll();
	
	public Conta getById(int id);
	
	public int insert(Conta conta)throws DBException;
	
	public int update(Conta conta)throws DBException;
	
	public int delete(Conta conta)throws DBException;
	
}
