package IODatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

	public static String[] cargarDatosTexto(String nombreFichero) {
	
		String vPisos[]=new String [20];
		int cont = 0;
		String ruta ="ficheros/" + nombreFichero;
		
		File f = new File(ruta);
		  
		
		if(!f.exists()) {
			  
			 try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  }
		
		FileReader fr = null;
		Scanner leer =null;
		
			try {
				fr= new FileReader(f);
				leer=new Scanner(fr);
				 
				while (leer.hasNext()) {
					vPisos[cont]=leer.nextLine();
					cont++;
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					fr.close();
					leer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		return vPisos;
	}
	
	

	
	
}
