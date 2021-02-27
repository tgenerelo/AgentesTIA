package Main;

import IODatos.IODatos;
import agentesTIA.Agente;
import menus.Menus;
import menus.Metodos;

public class Main {

	public static void main(String[] args) {
		
		String[] vRutas = new String[4];
		vRutas[0] = "Agentes.dat";
		vRutas[1] = "Pisos.txt";
		vRutas[2] = "Armas.txt";
		vRutas[3] = "Info.dat";
		
		int userInput = 0;

		do {
			
			Agente[] vAgentes = IODatos.cargarAgentes(vRutas[0]);
			String[] vPisos = IODatos.cargarDatosTexto(vRutas[1]);
			String[] vArmas = IODatos.cargarDatosTexto(vRutas[2]);
			
			userInput = Menus.mostrarMenu();

			switch (userInput) {
			case 1:
				Metodos.mostrarAgentes(vAgentes);
				break;
			case 2:
				Metodos.salarioAgentes(vAgentes);
				break;
			case 3:
				Metodos.nuevaArmasoPiso(vRutas[1]);
				vPisos = IODatos.cargarDatosTexto(vRutas[1]);
				break;
			case 4:
				Metodos.nuevaArmasoPiso(vRutas[2]);
				vArmas = IODatos.cargarDatosTexto(vRutas[2]);
				break;
			case 5:
				vAgentes = Metodos.nuevoAgente(vAgentes, vRutas[0]);
				break;
			case 6:
				IODatos.encriptar(vRutas[3], vAgentes, vArmas, vPisos);
				break;
			case 7:
				IODatos.desencriptar(vRutas, vAgentes, vArmas, vPisos);
				break;
			}
		} while (userInput != 8);

		System.out.println("  El programa se cerrará.");
		
	}

}
