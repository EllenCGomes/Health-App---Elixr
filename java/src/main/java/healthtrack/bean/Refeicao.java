package healthtrack.bean;

import java.util.Calendar;

public class Refeicao {

	private int cdRefeicao;
	private Calendar dtRefeicao;
	private String tpRefeicao;
	private int qtProteina;
	private int qtCarboidrato;
	private int qtAcucar;
	private int qtGordura;
	private Double pesoRefeicao;
	private String unMedidaPeso;
	private int cdUsuario;
	private int cdIngrediente;
	
	public Refeicao() {
		super();
	}
	
	public Refeicao(int cdRefeicao, Calendar dtRefeicao, String tpRefeicao, int qtProteina, int qtCarboidrato, int qtAcucar, int qtGordura, double psRefeicao, String unMedida, int estUsuario, int estIngrediente) {
		this.cdRefeicao = cdRefeicao;
		this.dtRefeicao = dtRefeicao;
		this.tpRefeicao = tpRefeicao;
		this.qtProteina = qtProteina;
		this.qtCarboidrato = qtCarboidrato;
		this.qtAcucar = qtAcucar;
		this.qtGordura = qtGordura;
		this.pesoRefeicao = psRefeicao;
		this.unMedidaPeso = unMedida;
		this.cdUsuario = estUsuario;
		this.cdIngrediente = estIngrediente;
	}
	
	public int getCdRefeicao() {
		return cdRefeicao;
	}
	public void setCdRefeicao(int cd_Refeicao) {
		cdRefeicao = cd_Refeicao;
	}
	public Calendar getDtRefeicao() {
		return dtRefeicao;
	}
	public void setDtRefeicao(Calendar dt_Refeicao) {
		dtRefeicao = dt_Refeicao;
	}
	public String getTpRefeicao() {
		return tpRefeicao;
	}
	public void setTpRefeicao(String tipo_Refeicao) {
		tpRefeicao = tipo_Refeicao;
	}
	public int getQtProteina() {
		return qtProteina;
	}
	public void setQtProteina(int qt_Proteina) {
		qtProteina = qt_Proteina;
	}
	public int getQtCarboidrato() {
		return qtCarboidrato;
	}
	public void setQtCarboidrato(int qt_Carboidrato) {
		qtCarboidrato = qt_Carboidrato;
	}
	public int getQtAcucar() {
		return qtAcucar;
	}
	public void setQtAcucar(int qt_Acucar) {
		qtAcucar = qt_Acucar;
	}
	public int getQtGordura() {
		return qtGordura;
	}
	public void setQtGordura(int qt_Gordura) {
		qtGordura = qt_Gordura;
	}
	public Double getPesoRefeicao() {
		return pesoRefeicao;
	}
	public void setPesoRefeicao(Double peso_Refeicao) {
		pesoRefeicao = peso_Refeicao;
	}
	public String getUnMedidaPeso() {
		return unMedidaPeso;
	}
	public void setUnMedidaPeso(String un_Medida_Peso) {
		unMedidaPeso = un_Medida_Peso;
	}
	
	public int getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(int cd_usuario) {
		cdUsuario = cd_usuario;
	}
	public int getCdIngrediente() {
		return cdIngrediente;
	}
	public void setCdIngrediente(int cd_Ingrediente) {
		cdIngrediente = cd_Ingrediente;
	}
	@Override
	public String toString() {
		return "\nRefeicao [Codigo Refeicao=" + cdRefeicao + ", Data Refeicao=" + dtRefeicao + ", Tipo de Refeicao="
				+ tpRefeicao + ", Qtd Proteina=" + qtProteina + ", Qtd Carboidrato=" + qtCarboidrato + ", Qtd Acucar="
				+ qtAcucar + ", Qtd Gordura=" + qtGordura + ", Peso da Refeicao=" + pesoRefeicao + ", Unidade de Medida="
				+ unMedidaPeso + ", Codigo Usuario=" + cdUsuario + ", Ingrediente="
				+ cdIngrediente + "]";
	}
	
	
}
