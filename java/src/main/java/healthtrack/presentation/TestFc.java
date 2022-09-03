package healthtrack.presentation;

import healthtrack.bean.Fc;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;
import healthtrack.dao.FcDAO;

public class TestFc {

	public static void main(String[] args) {
		FcDAO fcDAO = DAOFactory.getFcDAO();
		
		//insert
		Fc fc = new Fc();
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		
		fc.setVlFc(50);
		fc.setDtMedicao(date);
		fc.setDetectaArritmia(false);
		fc.setCdUsuario(1);
		
		try {
			System.out.println("Frequencia Cardiaca cadastrada " + fcDAO.insert(fc));
			System.out.println(fcDAO.getAll());
		}catch(DBException e) {
			e.printStackTrace();
		}	
		
	}

}
