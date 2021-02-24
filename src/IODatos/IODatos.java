package IODatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
	
	
	public static void encriptar(Agente vAgente[]) {
		
		File f =new File("ficheros/info.dat");
		
		if (!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		FileOutputStream fo = null;
		ObjectOutputStream escribir = null;
						
		
		try {
			fo = new FileOutputStream(f);
			escribir = new ObjectOutputStream(fo);
			
			 for (int i=0;i<vAgente.length;i++) {
				 if(vAgente[i]!=null) {
					 escribir.writeObject(vAgente);
				 }
			 }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
}
