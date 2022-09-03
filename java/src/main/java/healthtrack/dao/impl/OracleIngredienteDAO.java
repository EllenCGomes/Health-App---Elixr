package healthtrack.dao.impl;

import healthtrack.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import healthtrack.bean.Ingrediente;
import healthtrack.dao.IngredienteDAO;

public class OracleIngredienteDAO implements IngredienteDAO {
	
	private Connection connection;
	private Ingrediente ingrediente;
	
	public int insert(Ingrediente ingrediente) {
		try {
			connection = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_INGREDIENTE (ds_ingrediente, vl_kcal) VALUES (?, ?)");
			stmt.setString(1, ingrediente.getDsIngrediente());
			stmt.setInt(2, ingrediente.getVlKcal());
			return stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Ingrediente>getAll(){
		List<Ingrediente> lstIngrediente = new ArrayList<Ingrediente>(); 
		PreparedStatement stmt;
		try {
			
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_INGREDIENTE");
			ResultSet rs = null;
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Ingrediente c = new Ingrediente();
				c.setCdIngrediente(rs.getInt("CD_INGREDIENTE"));
				c.setDsIngrediente(rs.getString("DS_INGREDIENTE"));
				c.setVlKcal(rs.getInt("VL_KCAL"));
				lstIngrediente.add(c);
			}
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return lstIngrediente;
	}
	
	public Ingrediente getById(int id) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
        	PreparedStatement stmt = connection.prepareStatement("SELECT * FROM T_INGREDIENTE WHERE CD_INGREDIENTE = ?");
        
            stmt.setInt(1, id);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            if(rs.next()) {
            	int cdIngrediente = rs.getInt("CD_INGREDIENTE");
				String dsIngrediente = rs.getString("DS_INGREDIENTE");
				int vlKcal = rs.getInt("VL_KCAL");
				
				ingrediente = new Ingrediente(cdIngrediente, dsIngrediente, vlKcal);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return ingrediente;
    }
	
	public int delete(Ingrediente ingrediente) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_INGREDIENTE WHERE CD_INGREDIENTE = ?");
            stmt.setInt(1, ingrediente.getCdIngrediente());
            System.out.println("Ingrediente deletado com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Ingrediente ingrediente) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE T_INGREDIENTE SET "
                    + "ds_ingrediente = ?,"
                    + "vl_kcal = ?"
                    + "WHERE cd_ingrediente = ?");
            stmt.setString(1, ingrediente.getDsIngrediente());
            stmt.setInt(2, ingrediente.getVlKcal());
            stmt.setInt(5, ingrediente.getCdIngrediente());
            System.out.println("Ingrediente atualizado com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
