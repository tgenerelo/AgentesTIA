package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import IODatos.IODatos;
import agentesTIA.A007;
import agentesTIA.AEspionaje;
import agentesTIA.ASuperintendente;
import agentesTIA.Agente;

public class Menus {

	public static int mostrarMenu() {
		Scanner leerInput = new Scanner(System.in);
		int userInput = 0;
		boolean error = false;

		String titulo = "MENÚ PRINCIPAL";
		String[] vOpciones = { "1. Ver todos los agentes", "2. Ver agentes según sueldo", "3. Dar de alta nuevo piso",
				"4. Dar de alta nueva arma", "5. Dar de alta nuevo agente", "6. Encriptar todo", "7. Desencriptar todo",
				"8. Salir" };

		pintarMenu(titulo, vOpciones);

		do {
			System.out.print("  Introduce una opción: > ");

			try {
				userInput = leerInput.nextInt();
			} catch (InputMismatchException e) {
				error = true;
				leerInput = new Scanner(System.in);
			} catch (Exception e) {
				error = true;
			}

			if (userInput < 1 || userInput > vOpciones.length) {
				error = true;
			} else {
				error = false;
			}

			if (error == true)
				System.out.println("  Opción no válida. Inténtalo de nuevo.\n");

		} while (error == true);

		System.out.println();

		return userInput;
	}

	private static void pintarMenu(String titulo, String vOpciones[]) {

		int opcionMasLarga = calcularAnchoMenu(vOpciones);

		for (int i = 0; i < vOpciones.length; i++) {

			while (vOpciones[i].length() < opcionMasLarga) {
				vOpciones[i] += " ";
			}
		}

		int anchoTotal = (opcionMasLarga * 2) + 5;

		for (int i = 0; i < ((anchoTotal - titulo.length()) / 2); i++) {
			System.out.print(" ");
		}

		System.out.print("╔");

		for (int i = 0; i < titulo.length() + 2; i++) {
			System.out.print("═");
		}

		System.out.println("╗");

		for (int i = 0; i < ((anchoTotal - titulo.length()) / 2); i++) {
			System.out.print(" ");
		}

		System.out.println("║ " + titulo + " ║");

		for (int i = 0; i < ((anchoTotal - titulo.length()) / 2); i++) {
			System.out.print(" ");
		}

		System.out.print("╚");

		for (int i = 0; i < titulo.length() + 2; i++) {
			System.out.print("═");
		}

		System.out.println("╝");

		System.out.print("┌");
		for (int i = 0; i < anchoTotal; i++) {
			System.out.print("─");
		}

		System.out.println("┐");

		System.out.println("│ " + vOpciones[0] + " │ " + vOpciones[4] + " │");
		System.out.println("│ " + vOpciones[1] + " │ " + vOpciones[5] + " │");
		System.out.println("│ " + vOpciones[2] + " │ " + vOpciones[6] + " │");
		System.out.println("│ " + vOpciones[3] + " │ " + vOpciones[7] + " │");

		System.out.print("└");
		for (int i = 0; i < anchoTotal; i++) {
			System.out.print("─");
		}

		System.out.println("┘");
	}

	private static int calcularAnchoMenu(String[] vOpciones) {

		int ancho = 0;

		for (String opcion : vOpciones) {
			if (opcion.length() > ancho)
				ancho = opcion.length();
		}

		return ancho;

	}

	public static Agente[] nuevoAgente(Agente[] vAgentes, String ruta) {

		Scanner leerInput = new Scanner(System.in);
		int userInputInt = 0, pos = 0;
		boolean error = false;
		String nombreAgente = "", dirAgente = "";
		int edadAgente = 0;
		float salarioAgente = 0f;
		String vTiposAgente[] = { "Agente de espionaje", "Agente 007", "Superintendente" };

		System.out.println("Especifica el tipo de agente que quieres dar de alta:");

		for (int i = 0; i < vTiposAgente.length; i++) {
			System.out.println((i + 1) + ". " + vTiposAgente[i]);
		}

		do {
			error = false;

			System.out.print("\nTipo de agente: > ");

			try {
				userInputInt = leerInput.nextInt();
			} catch (InputMismatchException e) {
				error = true;
				leerInput = new Scanner(System.in);
				System.out.println("Opción no válida. Inténtalo de nuevo.\n");
			}

			if (userInputInt < 1 || userInputInt > vTiposAgente.length) {
				error = true;
			} else {
				error = false;
			}

		} while (error == true);

		System.out.println();

		pintarSubmenu(vTiposAgente[userInputInt - 1]);

		switch (userInputInt) {

		case 1:

			leerInput = new Scanner(System.in);
			System.out.print(" Introduce el nombre del nuevo agente: > ");
			nombreAgente = leerInput.nextLine();

			do {
				leerInput = new Scanner(System.in);
				System.out.print(" Introduce la edad del nuevo agente: > ");
				error = false;
				try {
					edadAgente = leerInput.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Edad no válida. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("Se ha producido un error desconocido (E1). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			leerInput = new Scanner(System.in);
			System.out.print(" Introduce la dirección del nuevo agente: > ");
			dirAgente = leerInput.nextLine();

			do {
				leerInput = new Scanner(System.in);
				System.out.print(" Introduce el salario del nuevo agente: > ");
				error = false;
				try {
					salarioAgente = leerInput.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("Salario no válido. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("Se ha producido un error desconocido (E2). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			pos = encontrarHuecoVector(vAgentes);

			if (pos != -1) {
				vAgentes[pos] = new AEspionaje(nombreAgente, edadAgente, dirAgente, salarioAgente);
			} else {
				System.out.println("Error al dar de alta el agente. No hay huecos libres.");
			}
			
			break;

		case 2:

			int muertesAgente = 0;

			leerInput = new Scanner(System.in);
			System.out.print(" Introduce el nombre del nuevo agente: > ");
			nombreAgente = leerInput.nextLine();

			do {
				leerInput = new Scanner(System.in);
				System.out.print(" Introduce la edad del nuevo agente: > ");
				error = false;
				try {
					edadAgente = leerInput.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Edad no válida. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("Se ha producido un error desconocido (E11). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			leerInput = new Scanner(System.in);
			System.out.print(" Introduce la dirección del nuevo agente: > ");
			dirAgente = leerInput.nextLine();

			do {
				leerInput = new Scanner(System.in);
				System.out.print(" Introduce el salario del nuevo agente: > ");
				error = false;
				try {
					salarioAgente = leerInput.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("Salario no válido. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("Se ha producido un error desconocido (E12). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			do {
				leerInput = new Scanner(System.in);
				System.out.print(" Introduce el número de bajas del nuevo agente: > ");
				error = false;
				try {
					muertesAgente = leerInput.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Número no válido. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("Se ha producido un error desconocido (E13). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			pos = encontrarHuecoVector(vAgentes);

			if (pos != -1) {
				vAgentes[pos] = new A007(nombreAgente, edadAgente, dirAgente, salarioAgente, muertesAgente);
			} else {
				System.out.println("Error al dar de alta el agente. No hay huecos libres.");
			}

			break;

		case 3:
			int anosMandato = 0;

			leerInput = new Scanner(System.in);
			System.out.print(" Introduce el nombre del nuevo agente: > ");
			nombreAgente = leerInput.nextLine();

			do {
				leerInput = new Scanner(System.in);
				System.out.print(" Introduce la edad del nuevo agente: > ");
				error = false;
				try {
					edadAgente = leerInput.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Edad no válida. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("Se ha producido un error desconocido (E11). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			leerInput = new Scanner(System.in);
			System.out.print(" Introduce la dirección del nuevo agente: > ");
			dirAgente = leerInput.nextLine();

			do {
				leerInput = new Scanner(System.in);
				System.out.print(" Introduce el salario del nuevo agente: > ");
				error = false;
				try {
					salarioAgente = leerInput.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("Salario no válido. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("Se ha producido un error desconocido (E12). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			do {
				leerInput = new Scanner(System.in);
				System.out.print(" Introduce los años de mandato del nuevo agente: > ");
				error = false;
				try {
					anosMandato = leerInput.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Número no válido. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("Se ha producido un error desconocido (E13). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			pos = encontrarHuecoVector(vAgentes);

			if (pos != -1) {
				vAgentes[pos] = new ASuperintendente(nombreAgente, edadAgente, dirAgente, salarioAgente, anosMandato);
			} else {
				System.out.println("Error al dar de alta el agente. No hay huecos libres.");
			}

			break;
			
		}

		System.out.println();
		IODatos.guardarAgentes(ruta, vAgentes);
		return vAgentes;

	}

	private static void pintarSubmenu(String titulo) {

		titulo = ("Nuevo " + titulo).toUpperCase();

		System.out.print("┌");

		for (int i = 0; i < titulo.length() + 2; i++) {
			System.out.print("─");
		}

		System.out.println("┐");

		System.out.println("│ " + titulo + " │");

		System.out.print("└");

		for (int i = 0; i < titulo.length() + 2; i++) {
			System.out.print("─");
		}

		System.out.println("┘");
	}

	private static int encontrarHuecoVector(Agente[] vAgentes) {

		for (int i = 0; i < vAgentes.length; i++) {
			if (vAgentes[i] == null) {
				return i;
			}
		}

		return -1;

	}
}
