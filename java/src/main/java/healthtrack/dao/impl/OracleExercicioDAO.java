package healthtrack.dao.impl;
import healthtrack.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import healthtrack.bean.Exercicio;
import healthtrack.dao.ExercicioDAO;

public class OracleExercicioDAO implements ExercicioDAO{

	private Connection connection;
	private Exercicio exercicio;
	
	public int insert(Exercicio exercicio) {
		try {
			connection = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_EXERCICIO (ds_exercicio) VALUES (?)");
			stmt.setString(1, exercicio.getDsExercicio());
			return stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Exercicio> getAll(){
		List<Exercicio> lstExercicio = new ArrayList<Exercicio>(); 
		PreparedStatement stmt;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_EXERCICIO");
			ResultSet rs = null;
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Exercicio e = new Exercicio();
				e.setCdExercicio(rs.getInt("CD_EXERCICIO"));
				e.setDsExercicio(rs.getString("DS_EXERCICIO"));
				lstExercicio.add(e);
			}
				rs.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return lstExercicio;
	}
	
	public Exercicio getById(int id) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
        	PreparedStatement stmt = connection.prepareStatement("SELECT * FROM T_EXERCICIO WHERE CD_EXERCICIO = ?");
        
            stmt.setInt(1, id);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            if(rs.next()) {
            	int cdExercicio = rs.getInt("CD_EXERCICIO");
            	String dsExercicio = rs.getString("DS_EXERCICIO");
            	
            	exercicio = new Exercicio(cdExercicio, dsExercicio);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return exercicio;
    }
	
	public int delete(Exercicio exercicio) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_EXERCICIO WHERE CD_EXERCICIO = ?");
            stmt.setInt(1, exercicio.getCdExercicio());
            System.out.println("Exercicio deletado com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Exercicio exercicio) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE T_EXERCICIO SET "
                    + "ds_exercicio = ?"
                    + "WHERE cd_exercicio = ?");
            stmt.setString(1, exercicio.getDsExercicio());
            stmt.setInt(5, exercicio.getCdExercicio());
            System.out.println("Exercicio atualizado com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
