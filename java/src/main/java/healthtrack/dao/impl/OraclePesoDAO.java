package healthtrack.dao.impl;

import healthtrack.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import healthtrack.bean.Peso;
import healthtrack.dao.PesoDAO;

public class OraclePesoDAO implements PesoDAO{

	private Connection connection;
	private Peso peso;
	
	public int insert(Peso peso) {
		try {
			connection = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_PESO (vl_peso, un_medida_sigla, dt_medicao, t_usuario_cd_usuario) VALUES (?, ?, ?, ?)");
			java.sql.Date dataPeso = new java.sql.Date(new java.util.Date().getTime());
			stmt.setFloat(1, peso.getVlPeso());
			stmt.setString(2, peso.getUnMedidaSigla());
			stmt.setDate(3, dataPeso);
			stmt.setInt(4, peso.getCdUsuario());
			return stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Peso>getAll(){
		List<Peso> lstPeso = new ArrayList<Peso>(); 
		PreparedStatement stmt;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_PESO");
			ResultSet rs = null;
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Peso pe = new Peso();
				pe.setCdPeso(rs.getInt("CD_PESO"));
				pe.setVlPeso(rs.getFloat("VL_PESO"));
				pe.setUnMedidaSigla(rs.getString("UN_MEDIDA_SIGLA"));
				pe.setDtMedicao(rs.getDate("DT_MEDICAO"));
				lstPeso.add(pe);
			}
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return lstPeso;
	}
	
	public Peso getById(int id) {
        try {
            connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM T_PESO WHERE CD_PESO = ?");

            stmt.setInt(1, id);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            if(rs.next()) {
				int cdPeso = rs.getInt("CD_PESO");
				float vlPeso = rs.getFloat("VL_PESO");
				String unMedida = rs.getString("UN_MEDIDA_SIGLA");
				java.sql.Date dtMedicao = rs.getDate("DT_MEDICAO");
				int estUsuario = rs.getInt("T_USUARIO_CD_USUARIO");
				
				peso = new Peso(cdPeso, vlPeso, unMedida, dtMedicao, estUsuario);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return peso;
    }
	
	public int delete(Peso peso) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_PESO WHERE CD_PESO = ?");
            stmt.setInt(1, peso.getCdPeso());
            System.out.println("Peso deletado com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Peso peso) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE T_PESO SET "
                    + "vl_peso = ?,"
                    + "un_medida_sigla = ?,"
                    + "dt_medicao = ?,"                
                    + "WHERE cd_peso = ?");
            stmt.setFloat(1, peso.getVlPeso());
            stmt.setString(2, peso.getUnMedidaSigla());
            stmt.setDate(3, peso.getDtMedicao());           
            System.out.println("Peso atualizado com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
