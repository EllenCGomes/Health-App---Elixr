package healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import healthtrack.bean.Conta;
import healthtrack.dao.ContaDAO;
import healthtrack.singleton.ConnectionManager;

public class OracleContaDAO implements ContaDAO{

	private Connection connection;
	private Conta conta;
	
	public int insert(Conta conta) {
		try {
			connection = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_CONTA (email, username, senha, idioma_conta) VALUES (?, ?, ?, ?)");
			stmt.setString(1, conta.getEmail());
			stmt.setString(2, conta.getUsername());
			stmt.setString(3, conta.getSenha());
			stmt.setString(4, conta.getIdiomaConta());
			return stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Conta> getAll(){
		List<Conta> lstConta = new ArrayList<Conta>(); 
		PreparedStatement stmt;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_CONTA");
			ResultSet rs = null;
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Conta c = new Conta();
				c.setCdConta(rs.getInt("CD_CONTA"));
				c.setEmail(rs.getString("EMAIL"));
				c.setUsername(rs.getString("USERNAME"));
				c.setSenha(rs.getString("SENHA"));
				c.setIdiomaConta(rs.getString("IDIOMA_CONTA"));
				lstConta.add(c);
			}
				rs.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return lstConta;
	}
	
	public Conta getById(int id) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
        	PreparedStatement stmt = connection.prepareStatement("SELECT * FROM T_CONTA WHERE CD_CONTA = ?");
        
            stmt.setInt(1, id);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            if(rs.next()) {
            	int cdConta = rs.getInt("CD_CONTA");
				String email = rs.getString("EMAIL");
				String username = rs.getString("USERNAME");
				String senha = rs.getString("SENHA");
				String idiomaConta = rs.getString("IDIOMA_CONTA");
				
				conta = new Conta(cdConta, email, username, senha, idiomaConta);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return conta;
    }
	
	public int delete(Conta conta) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_CONTA WHERE CD_CONTA = ?");
            stmt.setInt(1, conta.getCdConta());
            System.out.println("Conta deletada com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Conta conta) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE T_CONTA SET "
                    + "email = ?,"
                    + "username = ?,"
                    + "senha = ?,"
                    + "idioma_conta = ?"
                    + "WHERE cd_conta = ?");
            stmt.setString(1, conta.getEmail());
            stmt.setString(2, conta.getUsername());
            stmt.setString(3, conta.getSenha());
            stmt.setString(4, conta.getIdiomaConta());
            stmt.setInt(5, conta.getCdConta());
            System.out.println("Conta atualizada com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
