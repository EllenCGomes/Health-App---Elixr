package healthtrack.presentation;

import healthtrack.bean.Pa;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;
import healthtrack.dao.PaDAO;

public class TestPa {

	public static void main(String[] args) {	
		PaDAO paDAO = DAOFactory.getPaDAO();
		
		//insert
		Pa pa = new Pa();
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		
		pa.setVlSistolica(120);
		pa.setVlDiastolica(85);
		pa.setDtMedicao(date);
		pa.setDetectaPressaoAlta(false);
		
		try {
			System.out.println("Pressao arterial cadastrada " + paDAO.insert(pa));
			System.out.println(paDAO.getById(61));
		}catch(DBException e) {
			e.printStackTrace();
		}	
		
	}

}
