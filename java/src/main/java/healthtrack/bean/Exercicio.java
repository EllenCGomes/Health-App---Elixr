package healthtrack.bean;

public class Exercicio {
	
	private int cdExercicio;
	private String dsExercicio;
	
	public Exercicio() {
	}
	
	public Exercicio(int cdExercicio, String dsExercicio) {
		this.cdExercicio = cdExercicio;
		this.dsExercicio = dsExercicio;
	}
	
	public int getCdExercicio() {
		return cdExercicio;
	}
	public void setCdExercicio(int cd_Exercicio) {
		cdExercicio = cd_Exercicio;
	}
	public String getDsExercicio() {
		return dsExercicio;
	}
	public void setDsExercicio(String ds_Exercicio) {
		dsExercicio = ds_Exercicio;
	}

	@Override
	public String toString() {
		return "\nExercicio [Codigo Exercicio=" + cdExercicio + ", Descricao Exercicio=" + dsExercicio + "]";
	}
	

}
