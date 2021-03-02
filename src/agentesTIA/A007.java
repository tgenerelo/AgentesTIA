package agentesTIA;

import java.util.ArrayList;
import java.util.Iterator;

import IODatos.IODatos;

	/**
	 * @author Tomás Generelo
	 * @author Silvia Montañés
	 * @date 2021-03-01
	 * @version 1.0
	 */

public final class A007 extends Agente {

	private ArrayList<String>vArmas=new ArrayList<String>();
	private int muertes;

	/**
	 * Instancia un objeto de clase A007 con los datos especificados. vArmas se rellena automáticamente con la información del fichero correspondiente.
	 * @param nombre El nombre propio del agente.
	 * @param edad La edad del agente.
	 * @param direccion La dirección postal del agente.
	 * @param salario El salario que cobra el agente.
	 * @param muertes El número de bajas realizadas por el agente.
	 */
	public A007(String nombre, int edad, String direccion, float salario, int muertes) {
		super(nombre, edad, direccion, salario);
		this.vArmas = IODatos.cargarDatosTexto("recursos/Armas.txt");
		this.muertes = muertes;
	}

	/**
	 * Genera un String con la lista de armas de las que dispone el agente, separadas por comas.
	 * @return String con todas las armas separadas por comas.
	 */
	private String todasArmas() {
	
		String todasArmas = "";
		Iterator<String>it=vArmas.iterator();
	
		for (String arma : vArmas) {
			todasArmas += arma;
			if (it.hasNext())
				todasArmas += ", ";
		}
		
		return todasArmas;
	}

	
//	GETTERS Y SETTERS
	public ArrayList<String> getArmas() {
		return vArmas;
	}

	public void setArmas(ArrayList<String> vArmas) {
		this.vArmas = vArmas;
	}

	public int getMuertes() {
		return muertes;
	}

	public void setMuertes(int muertes) {
		this.muertes = muertes;
	}

	@Override
	public String toString() {
		return super.toString() + "\n  Número de bajas: ".toUpperCase() + muertes + "\n  Armas: ".toUpperCase() + todasArmas();
	}

}
