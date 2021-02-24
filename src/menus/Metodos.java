package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import agentesTIA.ASuperintendente;
import agentesTIA.Agente;

public class Metodos {

	public static void mostrarAgentes(Agente[] vAgentes) {
		for (Agente agente : vAgentes) {
			if (agente != null)
				System.out.println(agente.toString() + "\n");
		}
	}

	public static Agente nuevoAgente() {

		Scanner leerInput = new Scanner(System.in);
		int userInput = 0;
		boolean error = false;

		System.out.println("Especifica el tipo de agente que quieres dar de alta:");
		System.out.println("1. Agente de espionaje");
		System.out.println("2. Agente 007");
		System.out.println("3. Superintendente");
		

		do {
			error = false;

			System.out.print("\nTipo de agente: > ");
			
			try {
				userInput = leerInput.nextInt();
			} catch (InputMismatchException e) {
				error = true;
				leerInput=new Scanner(System.in);
				System.out.println("Opción no válida. Inténtalo de nuevo.\n");
			}
			
			if (userInput <1 || userInput >3) {
				error = true;
			} else {
				error = false;
			}

		} while (error == true);
		
		switch (userInput) {
		case 1:
			// Agente de espionaje
			break;

		case 2:
			// Agente 007
			break;
			
		case 3:
			// Superintendente
			break;
		}
		
		return new ASuperintendente(null, userInput, null, userInput, userInput); // 
		
	}


}
