package healthtrack.presentation;

import healthtrack.bean.Altura;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;
import healthtrack.dao.AlturaDAO;

public class TestAltura {
	
	public static void main(String[] args) {
		AlturaDAO altDAO = DAOFactory.getAlturaDAO();
		
		//insert
		Altura altura = new Altura();
		altura.setVlAltura(1.75f);
		altura.setUnMedidaSigla("Kg");
		altura.setCdUsuario(1);
		
		try {
			System.out.println("Altura cadastrada " + altDAO.insert(altura));
			System.out.println(altDAO.getAll());
		}catch(DBException e) {
			e.printStackTrace();
		}		
	}

}
