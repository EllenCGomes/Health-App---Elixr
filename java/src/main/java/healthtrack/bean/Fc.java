package healthtrack.bean;

import java.sql.Date;

public class Fc {
	private int cdFc;
	private int vlFc;
	private Date dtMedicao;
	private boolean detectaArritmia;
	private int cdUsuario;
	
	public Fc() {
	}
	
	public Fc(int cdFc, int vlFc, java.sql.Date dtMedicao, boolean dtcArritmia, int estUsuario) {
		this.cdFc = cdFc;
		this.vlFc = vlFc;
		this.dtMedicao = dtMedicao;
		this.detectaArritmia = dtcArritmia;
		this.cdUsuario = estUsuario;
	}
	
	public int getCdFc() {
		return cdFc;
	}
	public void setCdFc(int cd_Fc) {
		cdFc = cd_Fc;
	}
	public int getVlFc() {
		return vlFc;
	}
	public void setVlFc(int vl_Fc) {
		vlFc = vl_Fc;
	}
	public Date getDtMedicao() {
		return dtMedicao;
	}
	public void setDtMedicao(Date dt_Medicao) {
		dtMedicao = dt_Medicao;
	}
	public boolean isDetectaArritmia() {
		return detectaArritmia;
	}
	public void setDetectaArritmia(boolean detecta_Arritmia) {
		detectaArritmia = detecta_Arritmia;
	}
	public int getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(int cd_Usuario) {
		cdUsuario = cd_Usuario;
	}
	
	@Override
	public String toString() {
		return "\nFc [Codigo Frequencia=" + cdFc + ", Valor Frequencia=" + vlFc + ", Data Medicao=" + dtMedicao + ", Detecta Arritmia="
				+ detectaArritmia + ", Codigo Usuario=" + cdUsuario + "]";
	}
	
	
	
}
