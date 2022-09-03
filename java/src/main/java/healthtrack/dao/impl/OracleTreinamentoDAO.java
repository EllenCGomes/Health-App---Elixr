package healthtrack.dao.impl;

import healthtrack.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import healthtrack.bean.Exercicio;
import healthtrack.bean.Treinamento;
import healthtrack.dao.TreinamentoDAO;

public class OracleTreinamentoDAO implements TreinamentoDAO{

	private Connection connection;
	private Treinamento treinamento;
	
	public int insert(Treinamento treinamento) {
		try {
			connection = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_TREINAMENTO "
					+ "(dt_treinamento, duracao_treinamento, total_caloria, intensidade_treinamento, "
					+ "t_usuario_cd_usuario, t_exercicio_cd_exercicio) VALUES (?, ?, ?, ?, ?, ?)");
			stmt.setDate(1, treinamento.getDtTreinamento());
			stmt.setInt(2, treinamento.getDuracaoTreinamento());                                                                         
			stmt.setInt(3, treinamento.getTotalCaloria());
			stmt.setString(4, treinamento.getIntensidadeTreinamento());
			stmt.setInt(5, treinamento.getCdUsuario());
			stmt.setInt(6, treinamento.getCdExercicio());
			return stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Treinamento>getAll(){
		List<Treinamento> lstTreinamento = new ArrayList<Treinamento>(); 
		PreparedStatement stmt;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT t.cd_treinamento ,t.dt_treinamento, t.duracao_treinamento,t.intensidade_treinamento, "
					+ "t.total_caloria, e.cd_exercicio, e.ds_exercicio FROM T_TREINAMENTO t "
					+ "INNER JOIN T_EXERCICIO e "
					+ "ON(t.t_exercicio_cd_exercicio = e.cd_exercicio) "
					+ "WHERE t.t_usuario_cd_usuario = 1");
			ResultSet rs = null;
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Treinamento treino = new Treinamento();
				Exercicio exerc = new Exercicio();
				
				exerc.setCdExercicio(rs.getInt("CD_EXERCICIO"));
				exerc.setDsExercicio(rs.getString("DS_EXERCICIO"));
				treino.setCdTreinamento(rs.getInt("CD_TREINAMENTO"));
				treino.setDtTreinamento(rs.getDate("DT_TREINAMENTO"));
				treino.setDuracaoTreinamento(rs.getInt("DURACAO_TREINAMENTO"));
				treino.setTotalCaloria(rs.getInt("TOTAL_CALORIA"));
				treino.setIntensidadeTreinamento(rs.getString("INTENSIDADE_TREINAMENTO"));
				treino.setCdUsuario(rs.getInt("T_USUARIO_CD_USUARIO"));
				treino.setCdExercicio(rs.getInt("T_EXERCICIO_CD_EXERCICIO"));
				lstTreinamento.add(treino);
			}
				rs.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return lstTreinamento;
	}
	
	public Treinamento getById(int id) {
        try {        	        	
            connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM T_TREINAMENTO WHERE CD_TREINAMENTO = ?");

            stmt.setInt(1, id);

            ResultSet rs = null;
            rs = stmt.executeQuery();
            if(rs.next()) {            	
				int cdTreinamento = rs.getInt("CD_TREINAMENTO");
				java.sql.Date dtTreinamento =  rs.getDate("DT_TREINAMENTO");
				int durTreinamento = rs.getInt("DURACAO_TREINAMENTO");
				int totCalorias = rs.getInt("TOTAL_CALORIA");
				String intensidade = rs.getString("INTENSIDADE_TREINAMENTO");
				int estUsuario = rs.getInt("T_USUARIO_CD_USUARIO");
				int estExercicio = rs.getInt("T_EXERCICIO_CD_EXERCICIO");
				
				treinamento = new Treinamento(cdTreinamento, dtTreinamento, durTreinamento, totCalorias, intensidade, estUsuario, estExercicio);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return treinamento;
    }
	
	public int delete(Treinamento treinamento) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_TREINAMENTO WHERE CD_TREINAMENTO = ?");
            stmt.setInt(1, treinamento.getCdTreinamento());
            System.out.println("Treinamento deletado com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Treinamento treinamento) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE T_TREINAMENTO SET "
                    + "dt_treinamento = ?,"
                    + "duracao_treinamento = ?,"
                    + "total_caloria = ?,"
                    + "intensidade_treinamento = ?"
                    + "WHERE cd_treinamento = ?");
            stmt.setDate(1, treinamento.getDtTreinamento());
            stmt.setInt(2, treinamento.getDuracaoTreinamento());
            stmt.setInt(3, treinamento.getTotalCaloria());
            stmt.setString(4, treinamento.getIntensidadeTreinamento());
            stmt.setInt(5, treinamento.getCdTreinamento());
            System.out.println("Treinamento atualizado com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

