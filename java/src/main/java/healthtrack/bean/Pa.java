package healthtrack.bean;

import java.sql.Date;

public class Pa {

	private int cdPa;
	private int vlSistolica;
	private int vlDiastolica;
	private Date dtMedicao;
	private boolean detectaPressaoAlta;
	private int cdUsuario;
	
	public Pa() {
	}
	
	public Pa(int cdPa, int vlSistolica, int vlDiastolica, java.sql.Date dtMedicao, boolean dtcPressaoAlta, int estUsuario) {
		this.cdPa = cdPa;
		this.vlSistolica = vlSistolica;
		this.vlDiastolica = vlDiastolica;
		this.dtMedicao = dtMedicao;
		this.detectaPressaoAlta = dtcPressaoAlta;
		this.cdUsuario = estUsuario;
	}
	
	public int getCdPa() {
		return cdPa;
	}
	public void setCdPa(int cd_Pa) {
		cdPa = cd_Pa;
	}
	public int getVlSistolica() {
		return vlSistolica;
	}
	public void setVlSistolica(int vl_Sistolica) {
		vlSistolica = vl_Sistolica;
	}
	public int getVlDiastolica() {
		return vlDiastolica;
	}
	public void setVlDiastolica(int vl_Diastolica) {
		vlDiastolica = vl_Diastolica;
	}
	public Date getDtMedicao() {
		return dtMedicao;
	}
	public void setDtMedicao(Date dt_Medicao) {
		dtMedicao = dt_Medicao;
	}
	public boolean isDetectaPressaoAlta() {
		return detectaPressaoAlta;
	}
	public void setDetectaPressaoAlta(boolean detecta_Pressao_Alta) {
		detectaPressaoAlta = detecta_Pressao_Alta;
	}
	public int getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(int cd_Usuario) {
		cdUsuario = cd_Usuario;
	}
	@Override
	public String toString() {
		return "\nPa [Codigo Pa=" + cdPa + ", Valor Sistolica=" + vlSistolica + ", Valor Diastolica=" + vlDiastolica
				+ ", Data de Medicao=" + dtMedicao + ", Detectao de Pressao_Alta=" + detectaPressaoAlta
				+ ", Codigo Usuario=" + cdUsuario + "]";
	}
	
	
}
