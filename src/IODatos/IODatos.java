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

	/**
	 * El mensaje que se mostrará al terminar la ejecución de cada método.
	 */
	private static String mensajeFinOperacion = "\n  La operación se ha completado. Volviendo al menú principal.\n";
	
	/**
	 * Carga todas las líneas del fichero especificado y las devuelve en forma de vector de String.
	 * @param ruta El fichero de donde se cargará la información.
	 * @return Devuelve un vector de String.
	 */
	public static String[] cargarDatosTexto(String ruta) {

		String vItems[] = new String[20];
		int cont = 0;

		File f = new File(ruta);

		if (!f.exists()) {

			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("! Hubo un error durante la creación del fichero " + ruta);
			}
		}

		try (FileReader fr = new FileReader(f); Scanner leer = new Scanner(fr)) {
			while (leer.hasNext()) {
				vItems[cont] = leer.nextLine();
				cont++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("! No se ha encontrado el archivo " + ruta);
		} catch (IOException e) {
			System.out.println("! Hubo un error durante la lectura de " + f.getPath());
		}
		return vItems;
	}

	/**
	 * Guarda un dato de tipo String en la última línea del fichero de texto indicado.
	 * @param dato String que se guardará en el fichero.
	 * @param ruta Ruta del fichero de destino.
	 */
	public static void guardarPisoArma(String dato, String ruta) {

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

	/**
	 * Carga una serie de objetos de tipo Agente en el fichero especificado y los devuelve en forma de vector.
	 * @param ruta La ruta del archivo.
	 * @return Devuelve un vector de Agente[].
	 */
	public static Agente[] cargarAgentes(String ruta) {

		File f = new File(ruta);
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

	/**
	 * Recibe un vector de objetos de tipo Agente y los guarda, uno a uno, en el archivo indicado.
	 * @param ruta La ruta del archivo donde se guardarán los datos.
	 * @param vAgentes El vector con los objetos de tipo Agente que se quieren guardar.
	 */
	public static void guardarAgentes(String ruta, Agente[] vAgentes) {
		File f = new File(ruta);

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

	/**
	 * Guarda en un fichero .dat la información de los vectores recibidos.
	 * @param ruta La ruta del fichero donde se guardará la información.
	 * @param vAgentes Vector de objetos de clase Agente.
	 * @param vArmas Vector de armas en formato String.
	 * @param vPisos Vector de pisos en formato String.
	 */
	public static void encriptar(String ruta, Agente vAgentes[], String vArmas[], String vPisos[]) {

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

	/**
	 * Recibe la ruta de un archivo y restaura varios ficheros contenidos en él.
	 * @param vRutas Vector con las rutas de los archivos que se restaurarán.
	 * @param vAgentes Vector donde se guardarán los datos de tipo Agente.
	 * @param vArmas Vector donde se guardarán las armas en formato String.
	 * @param vPisos Vector donde se guardarán los pisos en formato String.
	 */
	public static void desencriptar(String[] vRutas, Agente[] vAgentes, String[] vArmas, String[] vPisos) {

		String rutaAgentes = vRutas[0];
		String rutaPisos = vRutas[1];
		String rutaArmas = vRutas[2];
		String rutaCrypt = vRutas[3];

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
