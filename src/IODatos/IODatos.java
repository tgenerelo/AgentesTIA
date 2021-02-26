package IODatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import agentesTIA.Agente;

public class IODatos {

	public static String[] cargarDatosTexto(String nombreFichero) {

		String vItems[] = new String[20];
		int cont = 0;
		String ruta = "ficheros/" + nombreFichero;

		File f = new File(ruta);

		if (!f.exists()) {

			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		FileReader fr = null;
		Scanner leer = null;

		try {
			fr = new FileReader(f);
			leer = new Scanner(fr);

			while (leer.hasNext()) {
				vItems[cont] = leer.nextLine();
				cont++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	public static String encriptar(String ruta, Agente vAgentes[], String vArmas[], String vPisos[]) {

		
		ruta = "ficheros/" + ruta;
		File f = new File(ruta);

		if (!f.exists()) {
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

			for (int i = 0; i < vAgentes.length; i++) {
				if (vAgentes[i] != null) {
					escribir.writeObject(vAgentes);
					escribir.writeObject(vArmas);
					escribir.writeObject(vPisos);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return ruta;
	}

public static void nuevaArmasoPiso (String ruta) { 		//  opcion 3 y 4
		
		ruta = "ficheros/" + ruta;
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
				
				if (ruta.equalsIgnoreCase("ficheros/Pisos.txt")) {
					System.out.println("Dime el piso para guardar");
				}else {
					System.out.println("Dime el arma para guardar");
				}
				dato = leer.nextLine();
				pw.print("\n" + dato);
				
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}	
	
	public static void desencriptar(String ruta, Agente[] vAgentes, String[] vArmas, String[] vPisos) {

		ruta="ficheros/" + ruta;
		File f = new File(ruta);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		FileInputStream fi = null;
		ObjectInputStream leer = null;

		try {
			fi = new FileInputStream(ruta);
			leer = new ObjectInputStream(fi);

			vAgentes = (Agente[]) leer.readObject();
			vArmas = (String[]) leer.readObject();
			vPisos = (String[]) leer.readObject();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Agente[] cargarAgentes(String ruta) {

		File f = new File("ficheros/" + ruta);
		Agente[] vAgentes = new Agente[20];
		int cont = 0;

		if (f.exists()) {

			try (FileInputStream fi = new FileInputStream(f); ObjectInputStream leer = new ObjectInputStream(fi)) {

				while (true) {
					vAgentes[cont] = (Agente) leer.readObject();
					cont++;
				}

			} catch (Exception e) {

			}
		}

		return vAgentes;
	}

	public static void guardarAgentes(String ruta, Agente[] vAgentes) {
		File f = new File("ficheros/" + ruta);

		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("Hubo un error durante la creación del fichero " + ruta + ".");
			}

		try (FileOutputStream fo = new FileOutputStream(f); ObjectOutputStream escribir = new ObjectOutputStream(fo)) {

			for (Agente agente : vAgentes) {
				escribir.writeObject(agente);
			}

		} catch (IOException e) {

		}
	}

}
