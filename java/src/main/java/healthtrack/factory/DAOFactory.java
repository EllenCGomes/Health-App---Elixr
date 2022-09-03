package healthtrack.factory;

import healthtrack.dao.*;

import healthtrack.dao.impl.*;

public abstract class DAOFactory {

	public static IngredienteDAO getIngredienteDAO() {
		return new OracleIngredienteDAO();
	}
	
	public static AlturaDAO getAlturaDAO() {
		return new OracleAlturaDAO();
	}
	
	public static ContaDAO getContaDAO() {
		return new OracleContaDAO();
	}
	
	public static ExercicioDAO getExercicioDAO() {
		return new OracleExercicioDAO();
	}
	
	public  static FcDAO getFcDAO() {
		return new OracleFcDAO();
	}
	
	public static OcupacaoDAO getOcupacaoDAO() {
		return new OracleOcupacaoDAO();
	}
	
	public static PaDAO getPaDAO() {
		return new OraclePaDAO();
	}
	
	public static PesoDAO getPesoDAO() {
		return new OraclePesoDAO();
	}
	
	public static RefeicaoDAO getRefeicaoDAO() {
		return new OracleRefeicaoDAO();
	}
	
	public static TreinamentoDAO getTreinamentoDAO() {
		return new OracleTreinamentoDAO();
	}
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
}
