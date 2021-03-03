package Main;
import java.util.ArrayList;

import IODatos.IODatos;
import agentesTIA.Agente;
import menus.Menus;
import menus.Metodos;

/**
 * Programa de gestión de agentes y recursos de la T.I.A.
 * @author Tomás Generelo
 * @author Silvia Montañés
 * @date 2021-03-01
 * @version 1.1
 */
public class Main {

	public static void main(String[] args) {
		
		String rutaCarpeta = "recursos/";
		
//		Vector de rutas de ficheros
		ArrayList<String>vRutas = new ArrayList<String>();
		vRutas.add(0, (rutaCarpeta + "Agentes.dat"));
		vRutas.add(1, (rutaCarpeta + "Pisos.txt"));
		vRutas.add(2, (rutaCarpeta + "Armas.txt"));
		vRutas.add(3, (rutaCarpeta + "Info.dat"));
		
		int userInput = 0;

		do {
			
//			Vectores vAgentes, vPisos y vArmas
			ArrayList<Agente> vAgentes = IODatos.cargarAgentes(vRutas.get(0));
			ArrayList<String> vPisos = IODatos.cargarDatosTexto(vRutas.get(1));
			ArrayList<String> vArmas = IODatos.cargarDatosTexto(vRutas.get(2));
			
//			MENÚ PRINCIPAL
			userInput = Menus.mostrarMenu();

			switch (userInput) {
			
//			MENÚ PRINCIPAL > MOSTRAR AGENTES
			case 1:
				Metodos.mostrarAgentes(vAgentes);
				break;
				
//			MENÚ PRINCIPAL > VER AGENTES POR SALARIO
			case 2:
				Metodos.salarioAgentes(vAgentes);
				break;
				
//			MENÚ PRINCIPAL > AÑADIR NUEVO PISO
			case 3:
				Metodos.nuevaArmasoPiso(vRutas.get(1));
				vPisos = IODatos.cargarDatosTexto(vRutas.get(1));
				break;
				
//			MENÚ PRINCIPAL > AÑADIR NUEVA ARMA
			case 4:
				Metodos.nuevaArmasoPiso(vRutas.get(2));
				vArmas = IODatos.cargarDatosTexto(vRutas.get(2));
				break;
				
//			MENÚ PRINCIPAL > DAR DE ALTA NUEVO AGENTE
			case 5:
				vAgentes = Metodos.nuevoAgente(vAgentes, vRutas.get(0));
				break;
				
//			MENÚ PRINCIPAL > ENCRIPTAR TODA LA INFORMACIÓN
			case 6:
				IODatos.encriptar(vRutas.get(3), vAgentes, vArmas, vPisos);
				break;
				
//			MENÚ PRINCIPAL > DESENCRIPTAR TODA LA INFORMACIÓN
			case 7:
				IODatos.desencriptar(vRutas, vAgentes, vArmas, vPisos);
				break;
			}
		} while (userInput != 8);

		Metodos.autodestruccion();
		
	}

}
