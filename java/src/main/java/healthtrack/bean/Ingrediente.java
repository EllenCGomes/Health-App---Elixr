package healthtrack.bean;

public class Ingrediente {

	private int cdIngrediente;
	private String dsIngrediente;
	private int vlKcal;
	
	public Ingrediente() {
	}
	
	public Ingrediente(int cdIngrediente, String dsIngrediente, int vlKcal) {
		this.cdIngrediente = cdIngrediente;
		this.dsIngrediente = dsIngrediente;
		this.vlKcal = vlKcal;
	}
	
	public int getCdIngrediente() {
		return cdIngrediente;
	}
	public void setCdIngrediente(int cd_Ingrediente) {
		cdIngrediente = cd_Ingrediente;
	}
	public String getDsIngrediente() {
		return dsIngrediente;
	}
	public void setDsIngrediente(String ds_Ingrediente) {
		dsIngrediente = ds_Ingrediente;
	}
	public int getVlKcal() {
		return vlKcal;
	}
	public void setVlKcal(int vl_Kcal) {
		vlKcal = vl_Kcal;
	}
	
	@Override
	public String toString() {
		return "\nIngrediente [Codigo Ingrediente=" + cdIngrediente + ", Descricao Ingrediente=" + dsIngrediente + ", Valor Kcal="
				+ vlKcal + "]";
	}
	
}
	
	