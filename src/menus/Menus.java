package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import agentesTIA.Agente;

public class Menus {

	public static int mostrarMenu() {
		Scanner leerInput = new Scanner(System.in);
		int userInput = 0;
		boolean error = false;

			String titulo = "MENÚ PRINCIPAL";
			String[] vOpciones = { "1. Ver todos los agentes", "2. Ver agentes según sueldo",
					"3. Dar de alta nuevo piso", "4. Dar de alta nueva arma", "5. Dar de alta nuevo agente",
					"6. Encriptar todo", "7. Desencriptar todo", "8. Salir" };

			pintarMenu(titulo, vOpciones);
			
			do {
				System.out.print("  Introduce una opción: > ");
				
				try {
					userInput=leerInput.nextInt();
				} catch (InputMismatchException e) {
					error=true;
					leerInput = new Scanner(System.in);
				} catch (Exception e) {
					error = true;
				}
				
				if (userInput<1 || userInput>vOpciones.length) {
					error=true;
				} else {
					error=false;
				}
					
				
				if (error==true)
					System.out.println("  Opción no válida. Inténtalo de nuevo.\n");
				
			} while (error==true);
			
			System.out.println();

		return userInput;
	}

	public static void verAgentes(Agente[] vAgentes) {
		for (Agente agente : vAgentes) {
			if (agente != null)
				System.out.println(agente);
		}
	}

//	public static void agregarPiso() {
//		Main.vPisos
//	}

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
	
	
	public static void nuevaArmas (String vItems[]) {
		
		Scanner leer=new Scanner(System.in);
		
		for (int i=0; i<vItems.length;i++) {
			if(vItems[i]==null) {
				System.out.println("Escribe el nombre de la nueva arma");
				String nombre=leer.nextLine();
				nombre=vItems[i];
				break;
			}
		}
	}

	
public static void salarioAgentes(Agente vAgente[]) {
		
		System.out.println("Introduce el salario minimo");
		Scanner leer=new Scanner(System.in);
		int cantidad =leer.nextInt();
		
		
		for(int i=0; i<vAgente.length;i++) {
			if((vAgente[i]!=null) && (cantidad<=vAgente[i].getSalario())){
				System.out.println(vAgente[i]);
			}
		}
	}
	
	
	

}
