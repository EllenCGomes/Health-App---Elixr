package healthtrack.presentation;

import healthtrack.bean.Usuario;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;
import healthtrack.dao.UsuarioDAO;

public class TestUsuario {

	public static void main(String[] args) {
		UsuarioDAO usuDAO = DAOFactory.getUsuarioDAO();	
		
		//insert
		Usuario usu = new Usuario();
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		usu.setNmUsuario("Lucas");
		usu.setDtNasc(date);
		usu.setPais("Chile");
		usu.setGenero("M");
		usu.setCdOcupacao(4);
		usu.setCdConta(5);
		
		try {
			System.out.println("Usuario cadastrado " + usuDAO.insert(usu));
			System.out.println(usuDAO.getById(1));
		}catch(DBException e) {
			e.printStackTrace();
		}
		
	}

}
