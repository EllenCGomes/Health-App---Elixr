package healthtrack.dao.impl;

import healthtrack.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import healthtrack.bean.Conta;
import healthtrack.bean.Ocupacao;
import healthtrack.bean.Usuario;
import healthtrack.dao.UsuarioDAO;

public class OracleUsuarioDAO implements UsuarioDAO{
	
	private Connection connection;
	private Usuario usuario;
	
	public int insert(Usuario usuario) {
		try {
			connection = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_USUARIO "
					+ "(NM_USUARIO, DT_NASCIMENTO, PAIS, "
					+ "GENERO, T_OCUPACAO_CD_OCUPACAO, T_CONTA_CD_CONTA) "
					+ "VALUES (?, ?, ?, ?, ?, ?)");
			java.sql.Date dataNasc = new java.sql.Date(new java.util.Date().getTime());
			stmt.setString(1, usuario.getNmUsuario());
			stmt.setDate(2, dataNasc);
			stmt.setString(3, usuario.getPais());
			stmt.setString(4, usuario.getGenero());
			stmt.setInt(5, usuario.getCdOcupacao());
			stmt.setInt(6, usuario.getCdConta());
			return stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Usuario> getAll(){
		List<Usuario> lstUsuario = new ArrayList<Usuario>(); 
		PreparedStatement stmt;
		try {
			connection = ConnectionManager.getInstance().getConnection();
		stmt = connection.prepareStatement("SELECT u.CD_USUARIO, u.NM_USUARIO, u.DT_NASCIMENTO, u.PAIS, u.GENERO, o.DS_OCUPACAO, c.CD_CONTA FROM T_USUARIO u INNER JOIN T_OCUPACAO o ON(u.T_OCUPACAO_CD_OCUPACAO = o.CD_OCUPACAO) INNER JOIN T_CONTA c ON(u.T_CONTA_CD_CONTA = c.CD_CONTA)");
		ResultSet rs = null;
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			Usuario usu = new Usuario();
			Ocupacao ocu = new Ocupacao();
			Conta con = new Conta();
			
			usu.setCdUsuario(rs.getInt("CD_USUARIO"));
			usu.setNmUsuario(rs.getString("NM_USUARIO"));
			usu.setDtNasc(rs.getDate("DT_NASCIMENTO"));
			usu.setPais(rs.getString("PAIS"));
			usu.setGenero(rs.getString("GENERO"));
			ocu.setDsOcupacao(rs.getString("DS_OCUPACAO"));
			con.setCdConta(rs.getInt("CD_CONTA"));
			lstUsuario.add(usu);
		}
		rs.close();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return lstUsuario;
	}
	
	public Usuario getById(int id) {
        try {
            connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM T_USUARIO WHERE CD_USUARIO = ?");

            stmt.setInt(1, id);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            while(rs.next()) {
    			int cdUsuario = rs.getInt("CD_USUARIO");
    			String nmUsuario = rs.getString("NM_USUARIO");
    			java.sql.Date dtNascimento = rs.getDate("DT_NASCIMENTO");
    			String pais = rs.getString("PAIS");
    			String genero = rs.getString("GENERO");
    			int estOcupacao = rs.getInt("T_OCUPACAO_CD_OCUPACAO");
    			int estConta = rs.getInt("T_CONTA_CD_CONTA");
    		
    			usuario = new Usuario(cdUsuario, nmUsuario, dtNascimento, pais, genero, estOcupacao, estConta);    			
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
	
	public int delete(Usuario usuario) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_USUARIO WHERE CD_USUARIO = ?");
            stmt.setInt(1, usuario.getCdUsuario());
            System.out.println("Usuario deletado com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Usuario usuario) {
        try {
        	connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE T_USUARIO SET "
                    + "nm_usuario = ?,"
                    + "dt_nascimento = ?,"
                    + "pais = ?,"
                    + "genero = ?"
                    + "WHERE cd_usuario = ?");
            stmt.setString(1, usuario.getNmUsuario());
            stmt.setDate(2, usuario.getDtNasc());
            stmt.setString(3, usuario.getPais());
            stmt.setString(4, usuario.getGenero());
            System.out.println("Usuario atualizado com sucesso!");
            return stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
