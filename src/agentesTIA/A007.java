package agentesTIA;

import IODatos.IODatos;

public final class A007 extends Agente{

	private String [] vArmas;
	private int muertes;
	
	public A007(String nombre, int edad, String direccion, float salario, int muertes) {
		super(nombre, edad, direccion, salario);
		this.vArmas = IODatos.cargarDatosTexto("Armas.txt");
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

	private String todasArmas() {
		String todasArmas = "";

		for (int i = 0; i < vArmas.length; i++) {
			if (vArmas[i] != null) {
				todasArmas += vArmas[i];
			}
			if (i < vArmas.length-1 && vArmas[i+1]!=null)
				todasArmas += ", ";
		}
		
		return todasArmas;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nNúmero de bajas: " + muertes + "\nArmas: " + todasArmas();
	}
	

	

	

}
