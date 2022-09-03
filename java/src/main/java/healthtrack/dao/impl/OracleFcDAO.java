package healthtrack.dao.impl;

import healthtrack.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import healthtrack.bean.Fc;
import healthtrack.dao.FcDAO;

public class OracleFcDAO implements FcDAO{

	private Connection connection;
	private Fc fc;
	
	public int insert(Fc fc) {
		try {
			connection = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_FC (vl_fc, dt_medicao, detecta_arritmia,"
					+ " t_usuario_cd_usuario) VALUES (?, ?, ?, ?)");
			java.sql.Date dataMedicao = new java.sql.Date(new java.util.Date().getTime());
			stmt.setInt(1, fc.getVlFc());
			stmt.setDate(2, dataMedicao);
			stmt.setBoolean(3, fc.isDetectaArritmia());
			stmt.setInt(4, fc.getCdUsuario());
			return stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Fc>getAll(){
		List<Fc> lstFC = new ArrayList<Fc>(); 
		PreparedStatement stmt;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_FC");
			ResultSet rs = null;
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Fc fc = new Fc();
				fc.setCdFc(rs.getInt("CD_FREQUENCIA"));
				fc.setVlFc(rs.getInt("VL_FC"));
				fc.setDtMedicao(rs.getDate("DT_MEDICAO"));
				fc.setDetectaArritmia(rs.getBoolean("DETECTA_ARRITMIA"));
				lstFC.add(fc);
			}
			rs.close();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return lstFC;
	}
	
	public Fc getById(int id) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
        	PreparedStatement stmt = connection.prepareStatement("SELECT * FROM T_FC WHERE CD_FC = ?");
        
            stmt.setInt(1, id);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            if(rs.next()) {
            	int cdFc = rs.getInt("CD_FREQUENCIA");
				int vlFc = rs.getInt("VL_FC");
				java.sql.Date dtMedicao = rs.getDate("DT_MEDICAO");
				boolean dtcArritmia = rs.getBoolean("DETECTA_ARRITMIA");
				int estUsuario = rs.getInt("T_USUARIO_CD_USUARIO");
				
				fc = new Fc(cdFc, vlFc, dtMedicao, dtcArritmia, estUsuario);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return fc;
    }
	
	public int delete(Fc fc) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_FC WHERE CD_FC = ?");
            stmt.setInt(1, fc.getCdFc());
            System.out.println("Frequencia cardiaca deletada com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Fc fc) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE T_FC SET "
                    + "vl_fc = ?,"
                    + "dt_medicao = ?,"
                    + "detecta_arritmia = ?,"
                    + "WHERE cd_fc = ?");
            stmt.setInt(1, fc.getVlFc());
            stmt.setDate(2, fc.getDtMedicao());
            stmt.setBoolean(3, fc.isDetectaArritmia());
            stmt.setInt(4, fc.getCdFc());
            System.out.println("Frequencia cardiaca atualizada com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
	
}
