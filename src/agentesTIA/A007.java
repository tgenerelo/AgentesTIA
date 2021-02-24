package agentesTIA;

import java.util.Arrays;

public final class A007 extends Agente{

	private String [] armas;
	private int muertes;
	
	public A007(String nombre, int edad, String direccion, float salario, int muertes) {
		super(nombre, edad, direccion, salario);
		//this.armas = IODatos.cargarDatosTexto("Armas.txt");
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
