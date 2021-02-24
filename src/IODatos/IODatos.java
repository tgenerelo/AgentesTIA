package IODatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import agentesTIA.Agente;

public class IODatos {

	
	public static String[] cargarDatosTexto(String nombreFichero) {
	
		String vItems[]=new String [20];
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
					vItems[cont]=leer.nextLine();
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
		return vItems;
	}
	

	

	

	
	
}
