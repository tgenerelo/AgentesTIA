package menus;

import java.util.InputMismatchException;
import java.util.Scanner;
import IODatos.IODatos;
import agentesTIA.A007;
import agentesTIA.AEspionaje;
import agentesTIA.ASuperintendente;
import agentesTIA.Agente;

public class Metodos {
	
	private static String mensajeFinOperacion = "\n  La operación se ha completado. Volviendo al menú principal.\n";

	public static void mostrarAgentes(Agente[] vAgentes) {

		for (Agente agente : vAgentes) {
			if (agente != null)
				System.out.println(agente.toString() + "\n");
		}
		
		System.out.println(mensajeFinOperacion);
	}

	public static void salarioAgentes(Agente vAgente[]) {

		System.out.print("  Introduce el salario mínimo que deseas buscar: > ");
		Scanner leer = new Scanner(System.in);
		float cantidad = leer.nextInt();
		int cont = 0;

		for (int i = 0; i < vAgente.length; i++) {
			if ((vAgente[i] != null) && (cantidad <= vAgente[i].getSalario())) {
				System.out.println(vAgente[i] + "\n");
				cont++;
			}
		}

		if (cont == 0) {
			System.out.println("\n  No se han encontrado resultados.");
		}
		
		System.out.println(mensajeFinOperacion);
	}

	public static void nuevaArmasoPiso(String ruta) {

		Scanner leer=new Scanner(System.in);
		String dato;

		if (ruta.equalsIgnoreCase("Pisos.txt")) {
			System.out.print("  Introduce el nombre del nuevo piso: > ");
		} else {
			System.out.print("  Introduce el nombre de la nueva arma: > ");
		}

		dato = leer.nextLine();
		
		IODatos.guardarPisoArma(dato, ruta);
		
		System.out.println(mensajeFinOperacion);
		
		}
	

	public static Agente[] nuevoAgente(Agente[] vAgentes, String ruta) {

		Scanner leerInput = new Scanner(System.in);
		int userInputInt = 0, pos = 0;
		boolean error = false;
		String nombreAgente = "", dirAgente = "";
		int edadAgente = 0;
		float salarioAgente = 0f;
		String vTiposAgente[] = { "Agente de espionaje", "Agente 007", "Superintendente" };

		System.out.println("  Especifica el tipo de agente que quieres dar de alta:");

		for (int i = 0; i < vTiposAgente.length; i++) {
			System.out.println("  " + (i + 1) + ". " + vTiposAgente[i]);
		}

		do {
			error = false;

			System.out.print("\n  Tipo de agente: > ");

			try {
				userInputInt = leerInput.nextInt();
			} catch (InputMismatchException e) {
				error = true;
				leerInput = new Scanner(System.in);
				System.out.println("  Opción no válida. Inténtalo de nuevo.\n");
			}

			if (userInputInt < 1 || userInputInt > vTiposAgente.length) {
				error = true;
			} else {
				error = false;
			}

		} while (error == true);

		System.out.println();

		Menus.pintarSubmenu(vTiposAgente[userInputInt - 1]);

		switch (userInputInt) {

		case 1:

			leerInput = new Scanner(System.in);
			System.out.print("  Introduce el nombre del nuevo agente: > ");
			nombreAgente = leerInput.nextLine();

			do {
				leerInput = new Scanner(System.in);
				System.out.print("  Introduce la edad del nuevo agente: > ");
				error = false;
				try {
					edadAgente = leerInput.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("  Edad no válida. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("! Se ha producido un error desconocido (E1). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			leerInput = new Scanner(System.in);
			System.out.print("  Introduce la dirección del nuevo agente: > ");
			dirAgente = leerInput.nextLine();

			do {
				leerInput = new Scanner(System.in);
				System.out.print("  Introduce el salario del nuevo agente: > ");
				error = false;
				try {
					salarioAgente = leerInput.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("  Salario no válido. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("! Se ha producido un error desconocido (E2). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			pos = encontrarHuecoVector(vAgentes);

			if (pos != -1) {
				vAgentes[pos] = new AEspionaje(nombreAgente, edadAgente, dirAgente, salarioAgente);
			} else {
				System.out.println("  Error al dar de alta el agente. No hay huecos libres.");
			}

			break;

		case 2:

			int muertesAgente = 0;

			leerInput = new Scanner(System.in);
			System.out.print("  Introduce el nombre del nuevo agente: > ");
			nombreAgente = leerInput.nextLine();

			do {
				leerInput = new Scanner(System.in);
				System.out.print("  Introduce la edad del nuevo agente: > ");
				error = false;
				try {
					edadAgente = leerInput.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("  Edad no válida. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("! Se ha producido un error desconocido (E11). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			leerInput = new Scanner(System.in);
			System.out.print("  Introduce la dirección del nuevo agente: > ");
			dirAgente = leerInput.nextLine();

			do {
				leerInput = new Scanner(System.in);
				System.out.print("  Introduce el salario del nuevo agente: > ");
				error = false;
				try {
					salarioAgente = leerInput.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("  Salario no válido. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("! Se ha producido un error desconocido (E12). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			do {
				leerInput = new Scanner(System.in);
				System.out.print("  Introduce el número de bajas del nuevo agente: > ");
				error = false;
				try {
					muertesAgente = leerInput.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("  Número no válido. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("! Se ha producido un error desconocido (E13). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			pos = encontrarHuecoVector(vAgentes);

			if (pos != -1) {
				vAgentes[pos] = new A007(nombreAgente, edadAgente, dirAgente, salarioAgente, muertesAgente);
			} else {
				System.out.println("  Error al dar de alta el agente. No hay huecos libres.");
			}

			break;

		case 3:
			int anosMandato = 0;

			leerInput = new Scanner(System.in);
			System.out.print("  Introduce el nombre del nuevo agente: > ");
			nombreAgente = leerInput.nextLine();

			do {
				leerInput = new Scanner(System.in);
				System.out.print("  Introduce la edad del nuevo agente: > ");
				error = false;
				try {
					edadAgente = leerInput.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("  Edad no válida. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("! Se ha producido un error desconocido (E11). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			leerInput = new Scanner(System.in);
			System.out.print("  Introduce la dirección del nuevo agente: > ");
			dirAgente = leerInput.nextLine();

			do {
				leerInput = new Scanner(System.in);
				System.out.print("  Introduce el salario del nuevo agente: > ");
				error = false;
				try {
					salarioAgente = leerInput.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("  Salario no válido. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("! Se ha producido un error desconocido (E12). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			do {
				leerInput = new Scanner(System.in);
				System.out.print("  Introduce los años de mandato del nuevo agente: > ");
				error = false;
				try {
					anosMandato = leerInput.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("  Número no válido. Inténtalo de nuevo.");
					error = true;
				} catch (Exception e) {
					System.out.println("! Se ha producido un error desconocido (E13). Inténtalo de nuevo.");
					error = true;
				}
			} while (error == true);

			pos = encontrarHuecoVector(vAgentes);

			if (pos != -1) {
				vAgentes[pos] = new ASuperintendente(nombreAgente, edadAgente, dirAgente, salarioAgente, anosMandato);
			} else {
				System.out.println("  Error al dar de alta el agente. No hay huecos libres.");
			}

			break;
		}

		IODatos.guardarAgentes(ruta, vAgentes);
		System.out.println(mensajeFinOperacion);
		return vAgentes;

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
