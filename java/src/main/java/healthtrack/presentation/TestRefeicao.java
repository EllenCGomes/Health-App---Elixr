package healthtrack.presentation;

import healthtrack.bean.Refeicao;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;
import healthtrack.dao.RefeicaoDAO;

public class TestRefeicao {

	public static void main(String[] args) {
		RefeicaoDAO refDAO = DAOFactory.getRefeicaoDAO();
		
		//insert
		Refeicao ref = new Refeicao();
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		//ref.setDtRefeicao(date);
		ref.setTpRefeicao("Jantar");
		ref.setQtProteina(200);
		ref.setQtCarboidrato(500);
		ref.setQtAcucar(50);
		ref.setQtGordura(50);
		ref.setPesoRefeicao(800.0);
		ref.setUnMedidaPeso("Grama");
		ref.setCdIngrediente(3);
		ref.setCdUsuario(2);
		
		try {
			System.out.println("Refeicao cadastrada " + refDAO.insert(ref));
			System.out.println(refDAO.getById(8)); 
		}catch(DBException e) {
			e.printStackTrace();
		}	
		
	}
	
}
