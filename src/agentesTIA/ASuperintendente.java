package agentesTIA;

public class ASuperintendente extends Agente {

	int anosMandato;
	
	/**
	 * Instancia un objeto de clase ASuperintendente con los datos especificados.
	 * @param nombre El nombre propio del agente.
	 * @param edad La edad del agente.
	 * @param direccion La dirección postal del agente.
	 * @param salario El salario que cobra el agente.
	 * @param anosMandato El número de años de mandato.
	 */
	public ASuperintendente(String nombre, int edad, String direccion, float salario, int anosMandato) {
		super(nombre, edad, direccion, salario);
		this.anosMandato = anosMandato;
	}
	
	
//	GETTERS Y SETTERS
	public int getAnosMandato() {
		return anosMandato;
	}

	public void setAnosMandato(int anosMandato) {
		this.anosMandato = anosMandato;
	}

	@Override
	public String toString() {
		String decoracion = "═════════════════════════════════════════  ";
		return decoracion + "\n" + super.toString() + "\n  Años de mandato: ".toUpperCase() + anosMandato + "\n" + decoracion;
	}

}
