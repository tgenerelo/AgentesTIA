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
import java.util.ArrayList;
import java.util.Scanner;

import agentesTIA.Agente;

/**
 * Esta clase recoge todos los métodos que realizan operaciones de lectura y
 * escritura en disco.
 * 
 * @author Tomás Generelo
 * @author Silvia Montañés
 * @date 2021-03-01
 * @version 1.1
 */
public class IODatos {

	/**
	 * El mensaje que se mostrará al terminar la ejecución de cada método.
	 */
	private static String mensajeFinOperacion = "\n  La operación se ha completado. Volviendo al menú principal.\n";

	/**
	 * Carga todas las líneas del fichero especificado y las devuelve en forma de
	 * vector de String.
	 * 
	 * @param ruta El fichero de donde se cargará la información.
	 * @return Devuelve un vector de String.
	 */
	public static ArrayList<String> cargarDatosTexto(String ruta) {

		ArrayList<String> vItems = new ArrayList<>();

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
				vItems.add(leer.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("! No se ha encontrado el archivo " + ruta);
		} catch (IOException e) {
			System.out.println("! Hubo un error durante la lectura de " + f.getPath());
		}
		return vItems;
	}

	/**
	 * Guarda un dato de tipo String en la última línea del fichero de texto
	 * indicado.
	 * 
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
	 * Carga una serie de objetos de tipo Agente en el fichero especificado y los
	 * devuelve en forma de vector.
	 * 
	 * @param ruta La ruta del archivo.
	 * @return Devuelve un vector de Agente[].
	 */
	public static ArrayList<Agente> cargarAgentes(String ruta) {

		File f = new File(ruta);
		ArrayList<Agente> vAgentes = new ArrayList<>();

		if (f.exists()) {
			try (FileInputStream fi = new FileInputStream(f); ObjectInputStream leer = new ObjectInputStream(fi)) {
				while (true) {
					vAgentes.add((Agente) leer.readObject());
				}
			} catch (Exception e) {
			}
		}

		return vAgentes;
	}

	/**
	 * Recibe un vector de objetos de tipo Agente y los guarda, uno a uno, en el
	 * archivo indicado.
	 * 
	 * @param ruta     La ruta del archivo donde se guardarán los datos.
	 * @param vAgentes El vector con los objetos de tipo Agente que se quieren
	 *                 guardar.
	 */
	public static void guardarAgentes(String ruta, ArrayList<Agente> vAgentes) {
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
	 * 
	 * @param ruta     La ruta del fichero donde se guardará la información.
	 * @param vAgentes Vector de objetos de clase Agente.
	 * @param vArmas   Vector de armas en formato String.
	 * @param vPisos   Vector de pisos en formato String.
	 */
	public static void encriptar(String ruta, ArrayList<Agente> vAgentes, ArrayList<String> vArmas,
			ArrayList<String> vPisos) {

		File f = new File(ruta);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e1) {
				System.out.println("! Hubo un error al crear " + ruta);
			}
		}

		try (FileOutputStream fo = new FileOutputStream(f); ObjectOutputStream escribir = new ObjectOutputStream(fo)) {
			for (int i = 0; i < vAgentes.size(); i++) {
				escribir.writeObject(vAgentes);
				escribir.writeObject(vArmas);
				escribir.writeObject(vPisos);
			}
		} catch (FileNotFoundException e) {
			System.out.println("! Hubo un error durante la escritura del fichero " + ruta);
		} catch (IOException e) {
		}

		System.out.println(mensajeFinOperacion);
	}

	/**
	 * Recibe la ruta de un archivo y restaura varios ficheros contenidos en él.
	 * 
	 * @param vRutas   Vector con las rutas de los archivos que se restaurarán.
	 * @param vAgentes Vector donde se guardarán los datos de tipo Agente.
	 * @param vArmas   Vector donde se guardarán las armas en formato String.
	 * @param vPisos   Vector donde se guardarán los pisos en formato String.
	 */
	public static void desencriptar(ArrayList<String> vRutas, ArrayList<Agente> vAgentes, ArrayList<String> vArmas,
			ArrayList<String> vPisos) {

		String rutaAgentes = vRutas.get(0);
		String rutaPisos = vRutas.get(1);
		String rutaArmas = vRutas.get(2);
		String rutaCrypt = vRutas.get(3);

		File fCrypt = new File(rutaCrypt);
		File fAgentes = new File(rutaAgentes);
		File fPisos = new File(rutaPisos);
		File fArmas = new File(rutaArmas);

		if (fCrypt.exists()) {

			try (FileInputStream fi = new FileInputStream(rutaCrypt);
					ObjectInputStream leer = new ObjectInputStream(fi)) {
				vAgentes = (ArrayList<Agente>) leer.readObject();
				vArmas = (ArrayList<String>) leer.readObject();
				vPisos = (ArrayList<String>) leer.readObject();

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
					IODatos.guardarAgentes(rutaAgentes, vAgentes);
				} catch (IOException e) {
					System.out.println("! Se ha producido un error al crear el archivo " + fAgentes);
				}
			}

			if (fArmas.exists())
				fArmas.delete();

			try {
				fArmas.createNewFile();
				for (String arma : vArmas) {
					IODatos.guardarPisoArma(arma, rutaArmas);
				}
			} catch (IOException e) {
				System.out.println("! Se ha producido un error al crear el archivo " + fArmas);
			}

			if (fPisos.exists())
				fPisos.delete();

			try {
				fPisos.createNewFile();
				for (String piso : vPisos) {
					IODatos.guardarPisoArma(piso, rutaPisos);
				}
			} catch (IOException e) {
				System.out.println("! Se ha producido un error al crear el archivo " + fPisos);
			}
		}

		System.out.println(mensajeFinOperacion);
	}

}
