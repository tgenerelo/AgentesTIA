package Main;

import IODatos.IODatos;
import agentesTIA.Agente;
import menus.Menus;
import menus.Metodos;

public class Main {

	public static void main(String[] args) {
		
		String rutaAgentes = "Agentes.dat";
		String rutaPisos = "Pisos.txt";
		String rutaArmas = "Armas.txt";
		String rutaCrypt = "Info.dat";
		
		Agente vAgentes[] = IODatos.cargarAgentes(rutaAgentes);
		String[] vArmas = IODatos.cargarDatosTexto(rutaArmas);
		String[] vPisos = IODatos.cargarDatosTexto(rutaPisos);

		int userInput = 0;

		do {
			userInput = Menus.mostrarMenu();

			switch (userInput) {
			case 1:
				Metodos.mostrarAgentes(vAgentes);
				break;
			case 2:
				Metodos.salarioAgentes(vAgentes);
				break;
			case 3:
				IODatos.nuevaArmasoPiso(rutaPisos);
				vPisos = IODatos.cargarDatosTexto(rutaPisos);
				break;
			case 4:
				IODatos.nuevaArmasoPiso(rutaArmas);
				vArmas = IODatos.cargarDatosTexto(rutaArmas);
				break;
			case 5:
				vAgentes = Metodos.nuevoAgente(vAgentes, rutaAgentes);
				break;
			case 6:
				IODatos.encriptar(rutaCrypt, vAgentes, vArmas, vPisos);
				break;
			case 7:
				IODatos.desencriptar(rutaCrypt, vAgentes, vArmas, vPisos);
				break;
			}
		} while (userInput != 8);

		System.out.println("  El programa se cerrará.");
		
	}

}
