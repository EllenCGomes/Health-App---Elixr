package healthtrack.presentation;

import healthtrack.bean.Peso;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;
import healthtrack.dao.PesoDAO;

public class TestPeso {

	public static void main(String[] args) {
		PesoDAO peDAO = DAOFactory.getPesoDAO();
		
		//insert
		Peso pe = new Peso();
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		
		pe.setVlPeso(55);
		pe.setUnMedidaSigla("Kg");
		pe.setDtMedicao(date);
		pe.setCdUsuario(1);
		
		try {
			System.out.println("Peso cadastrado " + peDAO.insert(pe));		
			System.out.println(peDAO.getAll());
		}catch(DBException e) {
			e.printStackTrace();
		}			
	}

}
