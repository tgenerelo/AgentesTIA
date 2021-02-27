package Main;

import IODatos.IODatos;
import agentesTIA.Agente;
import menus.Menus;
import menus.Metodos;

public class Main {

	public static void main(String[] args) {
		
		String rutaCarpeta = "ficheros/";
		
		// Vector de rutas de ficheros
		String[] vRutas = new String[4];
		vRutas[0] = "Agentes.dat";
		vRutas[1] = "Pisos.txt";
		vRutas[2] = "Armas.txt";
		vRutas[3] = "Info.dat";
		
		int userInput = 0;

		do {
			
			// Vectores vAgentes, vPisos y vArmas
			Agente[] vAgentes = IODatos.cargarAgentes(vRutas[0]);
			String[] vPisos = IODatos.cargarDatosTexto(vRutas[1]);
			String[] vArmas = IODatos.cargarDatosTexto(vRutas[2]);
			
			userInput = Menus.mostrarMenu();	// Muestra menu principal

			switch (userInput) {
			case 1:	// Opcion mostrar agentes
				Metodos.mostrarAgentes(vAgentes);
				break;
			case 2: // Opcion ver agentes por salario
				Metodos.salarioAgentes(vAgentes);
				break;
			case 3: // Opcion añadir nuevo piso
				Metodos.nuevaArmasoPiso(vRutas[1]);
				vPisos = IODatos.cargarDatosTexto(vRutas[1]);
				break;
			case 4: // Opcion añadir nueva arma
				Metodos.nuevaArmasoPiso(vRutas[2]);
				vArmas = IODatos.cargarDatosTexto(vRutas[2]);
				break;
			case 5: // Opcion añadir nuevo agente
				vAgentes = Metodos.nuevoAgente(vAgentes, vRutas[0]);
				break;
			case 6: // Opcion encriptar
				IODatos.encriptar(vRutas[3], vAgentes, vArmas, vPisos);
				break;
			case 7: // Opcion desencriptar
				IODatos.desencriptar(vRutas, vAgentes, vArmas, vPisos);
				break;
			}
		} while (userInput != 8);

		System.out.println("  El programa se cerrará.");
		
	}

}
