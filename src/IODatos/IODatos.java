package IODatos;

import java.util.Scanner;

import agentesTIA.Agente;

public class IODatos {



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
