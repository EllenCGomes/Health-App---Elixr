package healthtrack.bean;

import java.sql.Date;

public class Treinamento {
	
	private int cdTreinamento;
	private Date dtTreinamento;
	private int duracaoTreinamento;
	private int totCalorias;
	private String intensidadeTreinamento;
	private int cdUsuario;
	private int cdExercicio;
	
	public Treinamento() {
	}
	
	public Treinamento(int cdTreinamento, java.sql.Date dtTreinamento, int durTreinamento, int totCalorias, String intensidade, int estUsuario, int estExercicio) {
		this.cdTreinamento = cdTreinamento;
		this.dtTreinamento = dtTreinamento;
		this.duracaoTreinamento = durTreinamento;
		this.totCalorias = totCalorias;
		this.intensidadeTreinamento = intensidade;
		this.cdUsuario = estUsuario;
		this.cdExercicio = estExercicio;
	}
	
	public int getCdTreinamento() {
		return cdTreinamento;
	}
	public void setCdTreinamento(int cd_Treinamento) {
		cdTreinamento = cd_Treinamento;
	}
	public Date getDtTreinamento() {
		return dtTreinamento;
	}
	public void setDtTreinamento(Date dt_Treianmento) {
		dtTreinamento = dt_Treianmento;
	}
	public int getDuracaoTreinamento() {
		return duracaoTreinamento;
	}
	public void setDuracaoTreinamento(int duracao_Treinamento) {
		duracaoTreinamento = duracao_Treinamento;
	}
	public int getTotalCaloria() {
		return totCalorias;
	}
	public void setTotalCaloria(int total_Caloria) {
		totCalorias = total_Caloria;
	}
	public String getIntensidadeTreinamento() {
		return intensidadeTreinamento;
	}
	public void setIntensidadeTreinamento(String intensidade_Treinamento) {
		intensidadeTreinamento = intensidade_Treinamento;
	}
	public int getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(int usuario) {
		cdUsuario = usuario;
	}
	public int getCdExercicio() {
		return cdExercicio;
	}
	public void setCdExercicio(int exercicio) {
		cdExercicio = exercicio;
	}
	@Override
	public String toString() {
		return "\nTreinamento [Codigo Treinamento=" + cdTreinamento + ", Data Treinamento=" + dtTreinamento
				+ ", Duracao Treinamento=" + duracaoTreinamento + ", Total Caloria=" + totCalorias
				+ ", Intensidade Treinamento=" + intensidadeTreinamento + ", Usuario=" + cdUsuario + ", Exercicio="
				+ cdExercicio + "]";
	}
	
	

}
