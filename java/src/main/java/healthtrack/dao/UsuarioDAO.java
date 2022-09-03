package healthtrack.dao;

import java.util.List;

import healthtrack.bean.Usuario;
import healthtrack.exception.DBException;

public interface UsuarioDAO {
	
	public List<Usuario>getAll();
	
	public Usuario getById(int id);
	
	public int insert(Usuario usuario)throws DBException;
	
	public int update(Usuario usuario)throws DBException;
	
	public int delete(Usuario usuario)throws DBException;
}
