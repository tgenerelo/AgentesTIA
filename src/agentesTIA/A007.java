package agentesTIA;

import java.util.Arrays;

import IODatos.IODatos;

public final class A007 extends Agente{

	private String [] vArmas;
	private int muertes;
	
	public A007(String nombre, int edad, String direccion, float salario, int muertes) {
		super(nombre, edad, direccion, salario);
		this.vArmas = IODatos.cargarDatosTexto("armas.txt");
		this.muertes = muertes;
	}

	public String[] getArmas() {
		return vArmas;
	}

	public void setArmas(String[] armas) {
		this.vArmas = armas;
	}

	public int getMuertes() {
		return muertes;
	}

	public void setMuertes(int muertes) {
		this.muertes = muertes;
	}

	@Override
	public String toString() {
		return "A_007 [armas=" + Arrays.toString(vArmas) + ", muertes=" + muertes + "]";
	}
	

	

	

}
