package healthtrack.presentation;

import healthtrack.bean.Conta;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;
import healthtrack.dao.ContaDAO;

public class TestConta {
	
	public static void main(String[] args) {
		ContaDAO cDAO = DAOFactory.getContaDAO();
		
		//insert
		Conta conta = new Conta();
		conta.setEmail("emailawda@fiap.com.br");
		conta.setUsername("usernameawd");
		conta.setSenha("senhaawd");
		conta.setIdiomaConta("pt-BR");
		
		try {
			System.out.println("Conta cadastrada " + cDAO.insert(conta));
			System.out.println(cDAO.getAll());
		}catch(DBException e) {
			e.printStackTrace();
		}	
		
	}

}
