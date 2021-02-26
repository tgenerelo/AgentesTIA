package menus;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

import IODatos.IODatos;
import agentesTIA.A007;
import agentesTIA.AEspionaje;
import agentesTIA.ASuperintendente;
import agentesTIA.Agente;

public class Metodos {

	public static void mostrarAgentes(Agente[] vAgentes) { 		// opcion 1
		for (Agente agente : vAgentes) {
			if (agente != null)
				System.out.println(agente.toString() + "\n");
		}
	}
	
	
	public static void salarioAgentes(Agente vAgente[]) { 		// opcion 2
			
			System.out.println("Introduce el salario minimo");
			Scanner leer=new Scanner(System.in);
			float cantidad =leer.nextInt();
			int cont=0;
		
			
			
			
			
			
			for(int i=0; i<vAgente.length;i++) {
				if((vAgente[i]!=null) && (cantidad<=vAgente[i].getSalario())){
					System.out.println(vAgente[i]);
					cont++;
				}
			}
			
			if (cont==0) {
				System.out.println("no se han encontrado resultados");
			}
		}
	
	
	public static void nuevaArmasoPiso (String ruta) { 		//  opcion 3 y 4
		
		Scanner leer=new Scanner(System.in);
		
		File f = new File(ruta);
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		 
		try (FileWriter fw = new FileWriter(f,true);PrintWriter pw = new PrintWriter(fw) ){
		
				String dato;
				
				if (ruta.equalsIgnoreCase("ficheros/pisos.txt")) {
					System.out.println("Dime el piso para guardar");
				}else {
					System.out.println("Dime el arma para guardar");
				}
				dato = leer.nextLine();
				pw.println(dato);
				
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}	
	

	private static int encontrarHuecoVector(Agente[] vAgentes) {

		for (int i = 0; i < vAgentes.length; i++) {
			if (vAgentes[i] == null) {
				return i;
			}
		}

		return -1;
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

		Menus.pintarSubmenu(vTiposAgente[userInputInt - 1]);

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
	


}
