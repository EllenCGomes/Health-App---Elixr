package healthtrack.bean;

public class Altura {
	
	private int cdAltura;
	private float vlAltura;
	private String unMedidaSigla;
	private int cdUsuario;
	
	public Altura() {
	}
	
	public Altura(int cdAltura, float vlAltura, String unMedida, int estUsuario) {
		this.cdAltura = cdAltura;
		this.vlAltura = vlAltura;
		this.unMedidaSigla = unMedida;
		this.cdUsuario = estUsuario;
	}
	
	public int getCdAltura() {
		return cdAltura;
	}
	public void setCdAltura(int cd_Altura) {
		cdAltura = cd_Altura;
	}
	public float getVlAltura() {
		return vlAltura;
	}
	public void setVlAltura(float vl_Altura) {
		vlAltura = vl_Altura;
	}
	public String getUnMedidaSigla() {
		return unMedidaSigla;
	}
	public void setUnMedidaSigla(String un_Medida_Sigla) {
		unMedidaSigla = un_Medida_Sigla;
	}
	public int getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(int cd_usuario) {
		cdUsuario = cd_usuario;
	}
	@Override
	public String toString() {
		return "\nAltura [Codigo Altura=" + cdAltura + ", Valor Altura=" + vlAltura + ", Unidade de Medida=" + unMedidaSigla
				+ ", Codigo Usuario=" + cdUsuario + "]";
	}
	
	
}
