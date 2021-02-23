package agentesTIA;

import java.util.Arrays;

public final class A_007 extends AgenteCampo{

	private String [] armas;
	private int muertes;
	
	public A_007(String nombre, int edad, String direccion, float salario, String[] vPisos, String[] armas,
			int muertes) {
		super(nombre, edad, direccion, salario, vPisos);
		this.armas = armas;
		this.muertes = muertes;
	}

	public String[] getArmas() {
		return armas;
	}

	public void setArmas(String[] armas) {
		this.armas = armas;
	}

	public int getMuertes() {
		return muertes;
	}

	public void setMuertes(int muertes) {
		this.muertes = muertes;
	}

	@Override
	public String toString() {
		return "A_007 [armas=" + Arrays.toString(armas) + ", muertes=" + muertes + "]";
	}
	

	

	

}
