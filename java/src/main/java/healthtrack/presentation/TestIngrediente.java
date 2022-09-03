package healthtrack.presentation;

import healthtrack.bean.Ingrediente;
import healthtrack.exception.DBException;
import healthtrack.factory.*;
import healthtrack.dao.IngredienteDAO;

public class TestIngrediente {

	public static void main(String[] args) {					
		IngredienteDAO ingDAO = DAOFactory.getIngredienteDAO();
		
		//insert
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setDsIngrediente("Feijão");
		ingrediente.setVlKcal(35);
		
		try {
			System.out.println("Ingrediente cadastrado " + ingDAO.insert(ingrediente));
			System.out.println(ingDAO.getAll());
		}catch(DBException e) {
			e.printStackTrace();
		}	
		
	}
}
