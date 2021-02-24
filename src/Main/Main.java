package Main;

import IODatos.IODatos;
import agentesTIA.Agente;
import menus.Menus;

public class Main {


	public static void main(String[] args) {
		
		Agente vAgente[]=new Agente [20];
		
		vAgente[0] = new agentesTIA.A007("Ag007", 30, "Calle Falsa 123", 2000f, 3);
		vAgente[1] = new agentesTIA.AEspionaje("AgEsp", 40, "Calle No Tan Falsa 123", 1800f);
		vAgente[2] = new agentesTIA.ASuperintendente("El Súper", 56, "Calle Supervía 1", 2200, 25);

		int userInput = 0;

		do {
			userInput = Menus.mostrarMenu();

			switch (userInput) {
			case 1:

				break;

			case 2:
				menus.Menus.salarioAgentes(vAgente);

				break;
			case 3:

				break;
			case 4:
				menus.Menus.nuevaArmas(IODatos.cargarDatosTexto("armas.txt"));
				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;
			}
		} while (userInput != 8);

	}

}
