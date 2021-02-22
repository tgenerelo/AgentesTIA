package agentesTIA;

import java.util.Arrays;

public class AgenteCampo extends Agente {
	
	protected String[] vPisos;

	public AgenteCampo(String nombre, int edad, String direccion, float salario, String[] vPisos) {
		super(nombre, edad, direccion, salario);
		this.vPisos = vPisos;
	}

	public String[] getvPisos() {
		return vPisos;
	}

	public void setvPisos(String[] vPisos) {
		this.vPisos = vPisos;
	}

	@Override
	public String toString() {
		return "AgenteCampo [vPisos=" + Arrays.toString(vPisos) + "]";
	}
	
	
}
