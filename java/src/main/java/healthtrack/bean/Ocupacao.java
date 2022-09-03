package healthtrack.bean;

public class Ocupacao {
	
	private int cdOcupacao;
	private String dsOcupacao;
	private int horasSentado;
	private int horasEmPe;
	private String nvlStress;
	private boolean levantamentoPeso;
	
	public Ocupacao() {
	}
	
	public Ocupacao(int cdOcupacao, String dsOcupacao, int hrSentado, int hrEmPe, String nvlStress, boolean levantamentoPeso) {
		this.cdOcupacao = cdOcupacao;
		this.dsOcupacao = dsOcupacao;
		this.horasSentado = hrSentado;
		this.horasEmPe = hrEmPe;
		this.nvlStress = nvlStress;
		this.levantamentoPeso = levantamentoPeso;
	}
	
	public int getCdOcupacao() {
		return cdOcupacao;
	}
	public void setCdOcupacao(int cd_Ocupacao) {
		cdOcupacao = cd_Ocupacao;
	}
	public String getDsOcupacao() {
		return dsOcupacao;
	}
	public void setDsOcupacao(String ds_Ocupacao) {
		dsOcupacao = ds_Ocupacao;
	}
	public int getHorasSentado() {
		return horasSentado;
	}
	public void setHorasSentado(int horas_Sentado) {
		horasSentado = horas_Sentado;
	}
	public int getHorasEmPe() {
		return horasEmPe;
	}
	public void setHorasEmPe(int horas_Em_Pe) {
		horasEmPe = horas_Em_Pe;
	}
	public String getNivelStress() {
		return nvlStress;
	}
	public void setNivelStress(String nivel_Stress) {
		nvlStress = nivel_Stress;
	}
	public boolean isLevantamentoPeso() {
		return levantamentoPeso;
	}
	public void setLevantamentoPeso(boolean levantamento_Peso) {
		levantamentoPeso = levantamento_Peso;
	}
	
	@Override
	public String toString() {
		return "\nOcupacao [Codigo Ocupacao=" + cdOcupacao + ", Descricao Ocupacao=" + dsOcupacao + ", Horas Sentado="
				+ horasSentado + ", Horas em Pe=" + horasEmPe + ", Nivel de Stress=" + nvlStress
				+ ", Levantamento de Peso=" + levantamentoPeso + "]";
	}
	
	

}
