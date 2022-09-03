package healthtrack.bean;

public class Conta {
	
	private int cdConta;
	private String email;
	private String senha;
	private String username;
	private String idiomaConta;
	
	public Conta() {
	}
	
	public Conta(int cdConta, String email, String senha, String username, String idiomaConta) {
		this.cdConta = cdConta;
		this.email = email;
		this.senha = senha;
		this.username = username;
		this.idiomaConta = idiomaConta;
	}
	
	public int getCdConta() {
		return cdConta;
	}
	public void setCdConta(int cd_Conta) {
		cdConta = cd_Conta;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String Email) {
		email = Email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String Senha) {
		senha = Senha;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String Username) {
		username = Username;
	}
	public String getIdiomaConta() {
		return idiomaConta;
	}
	public void setIdiomaConta(String idioma_Conta) {
		idiomaConta = idioma_Conta;
	}
	@Override
	public String toString() {
		return "\nConta [Codigo Conta=" + cdConta + ", Email=" + email + ", Senha=" + senha + ", Username=" + username
				+ ", Idioma da Conta=" + idiomaConta + "]";
	}
	
	
}


