package healthtrack.bean;

import java.sql.Date;

public class Peso {

	private int cdPeso;
	private float vlPeso;
	private String unMedidaSigla;
	private Date dtMedicao;
	private int cdUsuario;
	
	public Peso() {
	}
	
	public Peso(int cdPeso, float vlPeso, String unMedida, java.sql.Date dtMedicao, int estUsuario) {
		this.cdPeso = cdPeso;
		this.vlPeso = vlPeso;
		this.unMedidaSigla = unMedida;
		this.dtMedicao = dtMedicao;
		this.cdUsuario = estUsuario;
	}
	
	public int getCdPeso() {
		return cdPeso;
	}
	public void setCdPeso(int cd_Peso) {
		cdPeso = cd_Peso;
	}
	public float getVlPeso() {
		return vlPeso;
	}
	public void setVlPeso(float vl_Peso) {
		vlPeso = vl_Peso;
	}
	public String getUnMedidaSigla() {
		return unMedidaSigla;
	}
	public void setUnMedidaSigla(String un_Medida_Sigla) {
		unMedidaSigla = un_Medida_Sigla;
	}
	public Date getDtMedicao() {
		return dtMedicao;
	}
	public void setDtMedicao(Date dt_Medicao) {
		dtMedicao = dt_Medicao;
	}
	public int getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(int cd_Usuario) {
		cdUsuario = cd_Usuario;
	}
	@Override
	public String toString() {
		return "\nPeso [Codigo Peso=" + cdPeso + ", Valor Peso=" + vlPeso + ", Unidade de Medida=" + unMedidaSigla
				+ ", Data de Medicao=" + dtMedicao + ", Codigo Usuario=" + cdUsuario + "]";
	}
	
	
}
