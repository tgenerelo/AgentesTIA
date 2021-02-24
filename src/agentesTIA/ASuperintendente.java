package agentesTIA;

public class ASuperintendente extends Agente {
	
	int anosMandato;

	public ASuperintendente(String nombre, int edad, String direccion, float salario, int anosMandato) {
		super(nombre, edad, direccion, salario);
		this.anosMandato=anosMandato;
	}

	public int getAnosMandato() {
		return anosMandato;
	}

	public void setAnosMandato(int anosMandato) {
		this.anosMandato = anosMandato;
	}


	
	@Override
	public String toString() {
		return super.toString() + "Años de mandato: " + anosMandato;
	}
	
	

}
