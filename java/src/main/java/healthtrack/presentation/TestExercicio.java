package healthtrack.presentation;

import healthtrack.bean.Exercicio;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;
import healthtrack.dao.ExercicioDAO;

public class TestExercicio {

	public static void main(String[] args) {
		ExercicioDAO exercDAO = DAOFactory.getExercicioDAO();
		
		//insert
		Exercicio exercicio = new Exercicio();
		exercicio.setDsExercicio("barra fixa");

		try {
			System.out.println("Exercicio cadastrado " + exercDAO.insert(exercicio));
			System.out.println(exercDAO.getAll());
		}catch(DBException e) {
			e.printStackTrace();
		}	
		
	}
	
}
