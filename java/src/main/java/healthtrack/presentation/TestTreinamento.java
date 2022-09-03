package healthtrack.presentation;

import healthtrack.bean.Treinamento;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;
import healthtrack.dao.TreinamentoDAO;

public class TestTreinamento {

	public static void main(String[] args) {
		TreinamentoDAO treinoDAO = DAOFactory.getTreinamentoDAO();
		
		//insert
		Treinamento treinamento = new Treinamento();
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		treinamento.setDtTreinamento(date);
		treinamento.setDuracaoTreinamento(2);
		treinamento.setTotalCaloria(800);
		treinamento.setIntensidadeTreinamento("Moderado");
		treinamento.setCdExercicio(4);
		
		try {
			System.out.println("Treinamento cadastrado " + treinoDAO.insert(treinamento));
			System.out.println(treinoDAO.getById(18));
		}catch(DBException e) {
			e.printStackTrace();
		}	
		
	}
	
}
