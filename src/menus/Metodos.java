package menus;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

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
			int cantidad =leer.nextInt();
			
			for(int i=0; i<vAgente.length;i++) {
				if((vAgente[i]!=null) && (cantidad<=vAgente[i].getSalario())){
					System.out.println(vAgente[i]);
				}
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
				
				if (ruta.equalsIgnoreCase("pisos.txt")) {
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
