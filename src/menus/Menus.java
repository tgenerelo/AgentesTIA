package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {

	/**
	 * Muestra el menú principal y devuelve la opción escogida por el usuario.
	 * @return Una opción válida escogida por el usuario.
	 */
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

	/**
	 * Devuelve la longitud del String más largo en el vector recibido.
	 * @param vOpciones Vector con las opciones que contiene el menú.
	 * @return La longitud de la opción más larga.
	 */
	private static int calcularAnchoMenu(String[] vOpciones) {
	
		int ancho = 0;
	
		for (String opcion : vOpciones) {
			if (opcion.length() > ancho)
				ancho = opcion.length();
		}
	
		return ancho;
	}

	/**
	 * Imprime en pantalla el menú principal.
	 * @param titulo El título que aparecerá en el menú sobre las opciones.
	 * @param vOpciones Un vector que contiene las distintas opciones del menú.
	 */
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

	/**
	 * Imprime por pantalla el contenido de un submenú con una serie de opciones numeradas automáticamente.
	 * @param titulo El título que mostrará el submenú.
	 */
	public static void pintarSubmenu(String titulo) {

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

}
