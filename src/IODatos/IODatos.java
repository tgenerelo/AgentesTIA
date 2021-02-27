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

	private static String mensajeFinOperacion = "\n  La operación se ha completado. Volviendo al menú principal.\n";
	
	public static String[] cargarDatosTexto(String nombreFichero) {

		String vItems[] = new String[20];
		int cont = 0;
		String ruta = "ficheros/" + nombreFichero;

		File f = new File(ruta);

		if (!f.exists()) {

			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("! Hubo un error durante la creación del fichero " + nombreFichero);
			}
		}

		try (FileReader fr = new FileReader(f); Scanner leer = new Scanner(fr)) {
			while (leer.hasNext()) {
				vItems[cont] = leer.nextLine();
				cont++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("! No se ha encontrado el archivo " + nombreFichero);
		} catch (IOException e) {
			System.out.println("! Hubo un error durante la lectura de " + f.getPath());
		}
		return vItems;
	}

	public static void guardarPisoArma(String dato, String ruta) {

		ruta = "ficheros/" + ruta;
		File f = new File(ruta);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("! Hubo un error durante la creación del fichero " + ruta);
			}
		}

		try (FileWriter fw = new FileWriter(f, true); PrintWriter pw = new PrintWriter(fw)) {
			pw.print(dato + "\n");
		} catch (IOException e) {
			System.out.println("! Hubo un error durante la escritura del fichero " + ruta);
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
				System.out.println("! Hubo un error durante la creación del fichero " + ruta + ".");
			}

		try (FileOutputStream fo = new FileOutputStream(f); ObjectOutputStream escribir = new ObjectOutputStream(fo)) {
			for (Agente agente : vAgentes) {
				escribir.writeObject(agente);
			}
		} catch (IOException e) {
		}
	}

	public static void encriptar(String ruta, Agente vAgentes[], String vArmas[], String vPisos[]) {

		ruta = "ficheros/" + ruta;
		File f = new File(ruta);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e1) {
				System.out.println("! Hubo un error al crear " + ruta);
			}
		}

		try (FileOutputStream fo = new FileOutputStream(f); ObjectOutputStream escribir = new ObjectOutputStream(fo)) {
			for (int i = 0; i < vAgentes.length; i++) {
				if (vAgentes[i] != null) {
					escribir.writeObject(vAgentes);
					escribir.writeObject(vArmas);
					escribir.writeObject(vPisos);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("! Hubo un error durante la escritura del fichero " + ruta);
		} catch (IOException e) {
		}
		
		System.out.println(mensajeFinOperacion);
	}

	public static void desencriptar(String[] vRutas, Agente[] vAgentes, String[] vArmas, String[] vPisos) {

		String rutaAgentes = "ficheros/" + vRutas[0];
		String rutaPisos = "ficheros/" + vRutas[1];
		String rutaArmas = "ficheros/" + vRutas[2];
		String rutaCrypt = "ficheros/" + vRutas[3];

		File fCrypt = new File(rutaCrypt);
		File fAgentes = new File(rutaAgentes);
		File fPisos = new File(rutaPisos);
		File fArmas = new File(rutaArmas);

		if (fCrypt.exists()) {

			try (FileInputStream fi = new FileInputStream(rutaCrypt);
					ObjectInputStream leer = new ObjectInputStream(fi)) {
				vAgentes = (Agente[]) leer.readObject();
				vArmas = (String[]) leer.readObject();
				vPisos = (String[]) leer.readObject();

			} catch (FileNotFoundException e) {
				System.out.println("! No se ha encontrado el archivo " + fCrypt.getPath());
			} catch (IOException e) {
				System.out.println("! Hubo un error durante la lectura de " + fCrypt.getPath());
			} catch (ClassNotFoundException e) {
				System.out.println("! Se ha producido un error ClassNotFound en " + fCrypt.getPath());
			}

			if (!fAgentes.exists()) {
				try {
					fAgentes.createNewFile();
					IODatos.guardarAgentes(vRutas[0], vAgentes);
				} catch (IOException e) {
					System.out.println("! Se ha producido un error al crear el archivo " + fAgentes);
				}
			}

			if (!fArmas.exists()) {
			try {
				fArmas.createNewFile();
				for (String arma : vArmas) {
					if (arma != null) {
						IODatos.guardarPisoArma(arma, vRutas[2]);
					}
				}
			} catch (IOException e) {
				System.out.println("! Se ha producido un error al crear el archivo " + fArmas);
			}
			}

			if (!fPisos.exists()) {
			try {
				fPisos.createNewFile();
				for (String piso : vPisos) {
					if (piso != null) {
						IODatos.guardarPisoArma(piso, vRutas[1]);
					}
				}
			} catch (IOException e) {
				System.out.println("! Se ha producido un error al crear el archivo " + fPisos);
			}
			}
		}
		
		System.out.println(mensajeFinOperacion);
	}
	
	
}
