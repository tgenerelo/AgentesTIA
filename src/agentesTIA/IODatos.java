package agentesTIA;

import java.util.Scanner;

public class IODatos {

	
	
	public static void salario_agentes(Agente vAgente[]) {
		
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
