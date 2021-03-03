package menus;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import IODatos.IODatos;
import agentesTIA.A007;
import agentesTIA.AEspionaje;
import agentesTIA.ASuperintendente;
import agentesTIA.Agente;

/**
 * Esta clase contiene los métodos que son invocados desde el menú del programa.
 * 
 * @author Tomás Generelo
 * @author Silvia Montañés
 * @date 2021-03-01
 * @version 1.3
 */
public class Metodos {

	/**
	 * Opción del menú principal para mostrar por pantalla la información de todos
	 * los agentes contenidos en el vector que recibe.
	 * 
	 * @param vAgentes El vector con los datos de tipo agente.
	 */
	public static void mostrarAgentes(ArrayList<Agente> vAgentes) {

		imprimirAgentes(vAgentes);

		System.out.println(mensajeFinOperacion);
	}

	/**
	 * Pide al usuario una cantidad y muestra la información de todos los agentes
	 * cuyo salario es mayor.
	 * 
	 * @param vAgente El vector con los datos de tipo Agente.
	 */
	public static void salarioAgentes(ArrayList<Agente> vAgente) {

		boolean error = false;
		float cantidad = 0f;

		do {
			error = false;
			System.out.print("  Introduce el salario mínimo que deseas buscar: > ");
			Scanner leer = new Scanner(System.in);

			try {
				cantidad = leer.nextFloat();
			} catch (InputMismatchException e) {
				System.out.println("  Cantidad no válida. Inténtalo de nuevo.");
				leer = new Scanner(System.in);
				error = true;
			}

			System.out.println();

		} while (error == true);

		ArrayList<Agente> agentesSueldo = new ArrayList<Agente>();

		for (Agente agente : vAgente) {
			if (agente.getSalario() >= cantidad) {
				agentesSueldo.add(agente);
			}
		}

		if (agentesSueldo.size() == 0) {
			System.out.println("  No se han encontrado resultados.");
		} else {
			imprimirAgentes(agentesSueldo);
		}

		System.out.println(mensajeFinOperacion);
	}

	/**
	 * Pide al usuario un arma o piso en formato String que se añadirá a un fichero
	 * en la ruta especificada.
	 * 
	 * @param ruta Ruta del fichero donde se guardará la información.
	 */
	public static void nuevaArmasoPiso(String ruta) {

		Scanner leer = new Scanner(System.in);
		String dato;

		if (ruta.equalsIgnoreCase("recursos/Pisos.txt")) {
			System.out.print("  Introduce el nombre del nuevo piso: > ");
		} else {
			System.out.print("  Introduce el nombre de la nueva arma: > ");
		}

		dato = leer.nextLine();

		IODatos.guardarPisoArma(dato, ruta);

		System.out.println(mensajeFinOperacion);

	}

	/**
	 * Permite al usuario crear un nuevo objeto de cualquiera de las subclases de
	 * Agente. El nuevo objeto se añadirá al vector recibido y a un archivo en la
	 * ruta especificada.
	 * 
	 * @param vAgentes El vector donde se guardará el nuevo objeto.
	 * @param ruta     La ruta donde se guardará el nuevo objeto.
	 * @return El vector de Agentes actualizado con el nuevo objeto.
	 */
	public static ArrayList<Agente> nuevoAgente(ArrayList<Agente> vAgentes, String ruta) {

		Scanner leerInput = new Scanner(System.in);
		int userInputInt = 0;
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

			vAgentes.add(new AEspionaje(nombreAgente, edadAgente, dirAgente, salarioAgente));

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

			vAgentes.add(new A007(nombreAgente, edadAgente, dirAgente, salarioAgente, muertesAgente));

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

			vAgentes.add(new ASuperintendente(nombreAgente, edadAgente, dirAgente, salarioAgente, anosMandato));

			break;
		}

		IODatos.guardarAgentes(ruta, vAgentes);
		System.out.println(mensajeFinOperacion);
		return vAgentes;

	}

	/**
	 * El mensaje que se mostrará al terminar la ejecución de cada método.
	 */
	private static String mensajeFinOperacion = "\n  La operación se ha completado. Volviendo al menú principal.\n";

	/**
	 * Imprime por pantalla la información de todos los agentes contenidos en el
	 * vector que recibe.
	 * 
	 * @param vAgentes El vector con los datos de tipo Agente.
	 */
	private static void imprimirAgentes(ArrayList<Agente> vAgentes) {

		for (Agente agente : vAgentes) {
			System.out.println(agente.toString() + "\n");
		}

	}

	public static void autodestruccion() {
		System.out.print(
				"  Gracias por utilizar Operative System T.I.A. v1.1. by Saturnino Bacterio.\n  El programa se cerrará ahora y se autodestruirá en ");

		for (int i = 10; i > 0; i--) {
			System.out.print(i + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			if (i < 3/* Francisco Ibáñez */)
				i++;
		}
	}

}
