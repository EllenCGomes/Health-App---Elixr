package healthtrack.dao.impl;

import healthtrack.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import healthtrack.bean.Ocupacao;
import healthtrack.dao.OcupacaoDAO;

public class OracleOcupacaoDAO implements OcupacaoDAO{
	
	private Connection connection;
	private Ocupacao ocupacao;
	
	public int insert(Ocupacao ocupacao) {
		try {
			connection = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_OCUPACAO (ds_ocupacao, horas_sentado, horas_em_pe, nivel_stress, levantamento_peso) VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, ocupacao.getDsOcupacao());
			stmt.setInt(2, ocupacao.getHorasSentado());
			stmt.setInt(3, ocupacao.getHorasEmPe());
			stmt.setString(4, ocupacao.getNivelStress());
			stmt.setBoolean(5, ocupacao.isLevantamentoPeso());
			return stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Ocupacao> getAll(){
		List<Ocupacao> lstOcupacao = new ArrayList<Ocupacao>(); 
		PreparedStatement stmt;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_OCUPACAO");
			ResultSet rs = null;
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Ocupacao c = new Ocupacao();
				c.setDsOcupacao(rs.getString("DS_OCUPACAO"));
				c.setHorasSentado(rs.getInt("HORAS_SENTADO"));
				c.setHorasEmPe(rs.getInt("HORAS_EM_PE"));
				c.setNivelStress(rs.getString("NIVEL_STRESS"));
				c.setLevantamentoPeso(rs.getBoolean("LEVANTAMENTO_PESO"));
				lstOcupacao.add(c);
			}
			rs.close();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return lstOcupacao;
	}

	public Ocupacao getById(int id) {
        try {
            connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM T_OCUPACAO WHERE CD_OCUPACAO = ?");

            stmt.setInt(1, id);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            if(rs.next()) {
                int cdOcupacao = rs.getInt("CD_OCUPACAO");
                String dsOcupacao = rs.getString("DS_OCUPACAO");
				int hrSentado = rs.getInt("HORAS_SENTADO");
				int hrEmPe = rs.getInt("HORAS_EM_PE");
				String nvlStress = rs.getString("NIVEL_STRESS");
				boolean levantamentoPeso = rs.getBoolean("LEVANTAMENTO_PESO");  
				
				ocupacao = new Ocupacao(cdOcupacao, dsOcupacao, hrSentado, hrEmPe, nvlStress, levantamentoPeso);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return ocupacao;
    }
	
	public int delete(Ocupacao ocupacao) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_OCUPACAO WHERE CD_OCUPACAO = ?");
            stmt.setInt(1, ocupacao.getCdOcupacao());
            System.out.println("Ocupacao deletada com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Ocupacao ocupacao) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE T_OCUPACAO SET "
                    + "ds_ocupacao = ?,"
                    + "horas_sentado = ?"
                    + "horas_em_pe = ?,"
                    + "nivel_stress = ?,"
                    + "levantamento_peso = ?,"
                    + "WHERE cd_ocupacao = ?");
            stmt.setString(1, ocupacao.getDsOcupacao());
            stmt.setInt(2, ocupacao.getHorasSentado());
            stmt.setInt(3, ocupacao.getHorasEmPe());
            stmt.setString(4, ocupacao.getNivelStress());
            stmt.setBoolean(5, ocupacao.isLevantamentoPeso());
            System.out.println("Ocupacao Atualizada com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
