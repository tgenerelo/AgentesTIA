package Main;

import IODatos.IODatos;
import agentesTIA.Agente;
import menus.Menus;

public class Main {


	public static void main(String[] args) {
		
		Agente vAgente[]=new Agente [20];

		int userInput = 0;

		do {
			userInput = Menus.mostrarMenu();

			switch (userInput) {
			case 1:

				break;

			case 2:
				IODatos.salarioAgentes(vAgente);

				break;
			case 3:

				break;
			case 4:

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
