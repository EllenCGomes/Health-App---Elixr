package healthtrack.dao.impl;

import healthtrack.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import healthtrack.bean.Refeicao;
import healthtrack.dao.RefeicaoDAO;

public class OracleRefeicaoDAO implements RefeicaoDAO{

	private Connection connection;
	private Refeicao refeicao;
	
	public int insert(Refeicao refeicao) {
		try {
			connection = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_REFEICAO "
					+ "(DT_REFEICAO, TIPO_REFEICAO, QT_PROTEINA, "
					+ "QT_CARBOIDRATO, QT_ACUCAR, QT_GORDURA, PESO_REFEICAO, "
					+ "UN_MEDIDA_PESO, T_USUARIO_CD_USUARIO,T_INGREDIENTE_CD_INGREDIENTE) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			java.sql.Date dataRefeicao = new java.sql.Date(refeicao.getDtRefeicao().getTimeInMillis());
			stmt.setDate(1, dataRefeicao);
			stmt.setString(2, refeicao.getTpRefeicao());
			stmt.setInt(3, refeicao.getQtProteina());
			stmt.setInt(4, refeicao.getQtCarboidrato());
			stmt.setInt(5, refeicao.getQtAcucar());
			stmt.setInt(6, refeicao.getQtGordura());
			stmt.setDouble(7, refeicao.getPesoRefeicao());
			stmt.setString(8, refeicao.getUnMedidaPeso());
			stmt.setInt(9, refeicao.getCdUsuario());
			stmt.setInt(10, refeicao.getCdIngrediente());
			return stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Refeicao>getAll(){
		List<Refeicao> lstRefeicao = new ArrayList<Refeicao>(); 
		PreparedStatement stmt;
		try {
			connection = ConnectionManager.getInstance().getConnection();
		stmt = connection.prepareStatement("SELECT r.CD_REFEICAO, r.DT_REFEICAO, r.TIPO_REFEICAO, r.QT_PROTEINA, r.QT_CARBOIDRATO, "
				+ "r.QT_ACUCAR, r.QT_GORDURA, r.PESO_REFEICAO, r.UN_MEDIDA_PESO, "
				+ "i.DS_INGREDIENTE, i.VL_KCAL FROM T_REFEICAO r INNER JOIN T_INGREDIENTE i "
				+ "ON(r.T_INGREDIENTE_CD_INGREDIENTE = i.CD_INGREDIENTE) WHERE r.T_USUARIO_CD_USUARIO = 8");
		ResultSet rs = null;
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			Refeicao ref = new Refeicao();
			ref.setCdRefeicao(rs.getInt("CD_REFEICAO"));
			java.sql.Date dtRefeicao = rs.getDate("DT_REFEICAO");
			Calendar dataRefeicao = Calendar.getInstance();
			dataRefeicao.setTimeInMillis(dtRefeicao.getTime());
			ref.setDtRefeicao(dataRefeicao);
			ref.setTpRefeicao(rs.getString("TIPO_REFEICAO"));
			ref.setQtProteina(rs.getInt("QT_PROTEINA"));
			ref.setQtCarboidrato(rs.getInt("QT_CARBOIDRATO"));
			ref.setQtAcucar(rs.getInt("QT_ACUCAR"));
			ref.setQtGordura(rs.getInt("QT_GORDURA"));
			ref.setPesoRefeicao(rs.getDouble("PESO_REFEICAO"));
			ref.setUnMedidaPeso(rs.getString("UN_MEDIDA_PESO"));
			lstRefeicao.add(ref);
		}
		rs.close();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return lstRefeicao;
	}
	
	public Refeicao getById(int id) {
        try {
            connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM T_REFEICAO WHERE CD_REFEICAO = ?");

            stmt.setInt(1, id);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            if(rs.next()) {
            	int cdRefeicao = rs.getInt("CD_REFEICAO");
    			java.sql.Date dtRefeicao = rs.getDate("DT_REFEICAO");
    			Calendar dataRefeicao = Calendar.getInstance();
    			dataRefeicao.setTimeInMillis(dtRefeicao.getTime());
    			String tpRefeicao = rs.getString("TIPO_REFEICAO");
    			int qtProteina = rs.getInt("QT_PROTEINA");
    			int qtCarboidrato = rs.getInt("QT_CARBOIDRATO");
    			int qtAcucar = rs.getInt("QT_ACUCAR");
    			int qtGordura = rs.getInt("QT_GORDURA");
    			double psRefeicao = rs.getDouble("PESO_REFEICAO");
    			String unMedida = rs.getString("UN_MEDIDA_PESO");
    			int estUsuario = rs.getInt("T_USUARIO_CD_USUARIO");
    			int estIngrediente = rs.getInt("T_INGREDIENTE_CD_INGREDIENTE");
    			
    			refeicao = new Refeicao(cdRefeicao, dataRefeicao, tpRefeicao, qtProteina, qtCarboidrato, qtAcucar, qtGordura, psRefeicao, unMedida, estUsuario, estIngrediente); 			
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return refeicao;
    }
	
	public int delete(Refeicao refeicao) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_REFEICAO WHERE CD_REFEICAO = ?");
            stmt.setInt(1, refeicao.getCdRefeicao());
            System.out.println("Refeicao deletada com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Refeicao refeicao) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE T_REFEICAO SET "
                    + "dt_refeicao = ?,"
                    + "tipo_refeicao = ?,"
                    + "qt_proteina = ?,"
                    + "qt_carboidrato = ?"
                    + "qt_acucar = ?"
                    + "qt_gordura = ?"
                    + "peso_refeicao = ?"
                    + "un_medida_peso = ?"
                    + "WHERE cd_refeicao = ?");
            
			java.sql.Date dataRefeicao = new java.sql.Date(refeicao.getDtRefeicao().getTimeInMillis());
			stmt.setDate(1, dataRefeicao);
            stmt.setString(2, refeicao.getTpRefeicao());
            stmt.setInt(3, refeicao.getQtProteina());
            stmt.setInt(4, refeicao.getQtCarboidrato());
            stmt.setInt(5, refeicao.getQtAcucar());
            stmt.setInt(6, refeicao.getQtGordura());
            stmt.setDouble(7, refeicao.getPesoRefeicao());
            stmt.setString(8, refeicao.getUnMedidaPeso());
            stmt.setInt(9, refeicao.getCdRefeicao());
            System.out.println("Refeicao atualizada com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
