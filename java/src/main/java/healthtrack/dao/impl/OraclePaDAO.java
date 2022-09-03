package healthtrack.dao.impl;

import healthtrack.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import healthtrack.bean.Pa;
import healthtrack.dao.PaDAO;

public class OraclePaDAO implements PaDAO{

	private Connection connection;
	private Pa pa;
	
	public int insert(Pa pa) {
		try {
			connection = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_PA (vl_sistolica, vl_diastolica, dt_medicao, "
					+ "detecta_pressao_alta, t_usuario_cd_usuario) VALUES (?, ?, ?, ?, ?)");
			java.sql.Date dataMedicao = new java.sql.Date(new java.util.Date().getTime());
			stmt.setInt(1, pa.getVlSistolica());
			stmt.setInt(2, pa.getVlDiastolica());
			stmt.setDate(3, dataMedicao);
			stmt.setBoolean(4, pa.isDetectaPressaoAlta());
			stmt.setInt(5, pa.getCdUsuario());
			return stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Pa>getAll(){
		List<Pa> lstPA = new ArrayList<Pa>(); 
		PreparedStatement stmt;
		try {
			connection = ConnectionManager.getInstance().getConnection();
		stmt = connection.prepareStatement("SELECT * FROM T_PA");
		ResultSet rs = null;
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			Pa pa = new Pa();
			pa.setCdPa(rs.getInt("CD_PA"));
			pa.setVlSistolica(rs.getInt("VL_SISTOLICA"));
			pa.setVlDiastolica(rs.getInt("VL_DIASTOLICA"));
			pa.setDtMedicao(rs.getDate("DT_MEDICAO"));
			pa.setDetectaPressaoAlta(rs.getBoolean("DETECTA_PRESSAO_ALTA"));
			lstPA.add(pa);
		}
		rs.close();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return lstPA;
	}
	
	public Pa getById(int id) {
        try {
            connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM T_PA WHERE CD_PA = ?");

            stmt.setInt(1, id);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            if(rs.next()) {
    			int cdPa = rs.getInt("CD_PA");
    			int vlSistolica = rs.getInt("VL_SISTOLICA");
    			int vlDiastolica = rs.getInt("VL_DIASTOLICA");
    			java.sql.Date dtMedicao = rs.getDate("DT_MEDICAO");
    			boolean dtcPressaoAlta = rs.getBoolean("DETECTA_PRESSAO_ALTA");
    			int estUsuario = rs.getInt("T_USUARIO_CD_USUARIO");
    			
    			pa = new Pa(cdPa, vlSistolica, vlDiastolica, dtMedicao, dtcPressaoAlta, estUsuario);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return pa;
    }
	
	public int delete(Pa pa) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_PA WHERE CD_PA = ?");
            stmt.setInt(1, pa.getCdPa());
            System.out.println("Pressao Arterial deletada com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Pa pa) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE T_PA SET "
            		+ "vl_sistolica = ?,"
            		+ "vl_diastolica = ?,"                    
                    + "dt_medicao = ?,"
                    + "detecta_pressao_alta = ?"
                    + "WHERE cd_pa = ?");
            stmt.setInt(1, pa.getVlSistolica());
            stmt.setInt(2, pa.getVlDiastolica());        
            stmt.setDate(3, pa.getDtMedicao());
            stmt.setBoolean(4, pa.isDetectaPressaoAlta());
            System.out.println("Pressao Arterial atualizada com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
