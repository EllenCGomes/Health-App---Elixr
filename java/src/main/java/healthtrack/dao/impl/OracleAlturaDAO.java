package healthtrack.dao.impl;

import healthtrack.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import healthtrack.bean.Altura;
import healthtrack.dao.AlturaDAO;

public class OracleAlturaDAO implements AlturaDAO{

	private Connection connection;
	private Altura altura;
	
	public int insert(Altura altura) {
		try {
			connection = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_ALTURA (vl_altura, un_medida_sigla, t_usuario_cd_usuario) VALUES (?, ?, ?)");
			stmt.setFloat(1, altura.getVlAltura());
			stmt.setString(2, altura.getUnMedidaSigla());
			stmt.setInt(3, altura.getCdUsuario());
			return stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Altura>getAll(){
		List<Altura> lstAltura = new ArrayList<Altura>(); 
		PreparedStatement stmt;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_ALTURA");
			ResultSet rs = null;
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Altura alt = new Altura();
				alt.setCdAltura(rs.getInt("CD_ALTURA"));
				alt.setVlAltura(rs.getFloat("VL_ALTURA"));
				alt.setUnMedidaSigla(rs.getString("UN_MEDIDA_SIGLA"));
				lstAltura.add(alt);
			}
				rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return lstAltura;
	}
	
	public Altura getById(int id) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
        	PreparedStatement stmt = connection.prepareStatement("SELECT * FROM T_ALTURA WHERE CD_ALTURA = ?");
        
            stmt.setInt(1, id);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            if(rs.next()) {
            	int cdAltura = rs.getInt("CD_ALTURA");
				float vlAltura = rs.getFloat("VL_ALTURA");
				String unMedida = rs.getString("UN_MEDIDA_SIGLA");
				int estUsuario = rs.getInt("T_USUARIO_CD_USUARIO");
				
				altura = new Altura(cdAltura, vlAltura, unMedida, estUsuario);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return altura;
    }
	
	public int delete(Altura altura) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_ALTURA WHERE CD_ALTURA = ?");
            stmt.setInt(1, altura.getCdAltura());
            System.out.println("Altura deletada com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Altura altura) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE T_ALTURA SET "
                    + "vl_altura = ?,"
                    + "un_medida_sigla = ?,"
                    + "WHERE cd_altura = ?");
            stmt.setFloat(1, altura.getVlAltura());
            stmt.setString(2, altura.getUnMedidaSigla());
            stmt.setInt(2, altura.getCdAltura());
            System.out.println("Altura atualizada com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }	
}
