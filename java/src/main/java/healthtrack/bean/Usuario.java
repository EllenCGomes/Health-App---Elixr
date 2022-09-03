package healthtrack.bean;

import java.sql.Date;

public class Usuario {
	private int cdUsuario;
	private String nmUsuario;
	private Date dtNasc;
	private String pais;
	private String genero;
	private int cdOcupacao;
	private int cdConta;
	
	public Usuario() {
		super();
	}
		
	public Usuario(int cdUsuario, String nmUsuario, java.sql.Date dtNascimento, String pais, String genero, int estOcupacao, int estConta) {
		this.cdUsuario = cdUsuario;
		this.nmUsuario = nmUsuario;
		this.dtNasc = dtNascimento;
		this.pais = pais;
		this.genero = genero;
		this.cdOcupacao = estOcupacao;
		this.cdConta = estConta;
	}
	
	public int getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(int cd_Usuario) {
		cdUsuario = cd_Usuario;
	}
	public String getNmUsuario() {
		return nmUsuario;
	}
	public void setNmUsuario(String nm_Usuario) {
		nmUsuario = nm_Usuario;
	}
	public Date getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(Date dt_Nasc) {
		dtNasc = dt_Nasc;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String Pais) {
		pais = Pais;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String Genero) {
		genero = Genero;
	}
	public int getCdOcupacao() {
		return cdOcupacao;
	}
	public void setCdOcupacao(int cd_ocupacao) {
		cdOcupacao = cd_ocupacao;
	}
	public int getCdConta() {
		return cdConta;
	}
	public void setCdConta(int Cd_conta) {
		cdConta = Cd_conta;
	}
	@Override
	public String toString() {
		return "Usuario [Cd_Usuario=" + cdUsuario + ", Nm_Usuario=" + nmUsuario + ", Dt_Nasc=" + dtNasc + ", Pais="
				+ pais + ", Genero=" + genero + ", Ocupacao=" + cdOcupacao + ", Conta=" + cdConta + "]";
	}
	
	
}
