package Main;

import IODatos.IODatos;
import agentesTIA.Agente;
import menus.Menus;
import menus.Metodos;

public class Main {


	public static void main(String[] args) {
		
		Agente vAgentes[]=new Agente [20];
		
		vAgentes[0] = new agentesTIA.A007("James Bont", 30, "Calle Falsa 123", 2000f, 3);
		vAgentes[1] = new agentesTIA.AEspionaje("Filemón Pi", 40, "Calle No Tan Falsa 123", 1800f);
		vAgentes[2] = new agentesTIA.ASuperintendente("El Súper", 56, "Calle Supervía 1", 2200, 25);

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

				break;
			case 4:
				Metodos.nuevaArmasoPiso("pisos.txt");
				break;
			case 5:
				Metodos.nuevaArmasoPiso("armas.txt");
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
