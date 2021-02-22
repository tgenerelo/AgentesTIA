package agentesTIA;

public class Menu {

	public static int mostrarMenu() {

		int userInput = 0;
		String titulo = "MENÚ PRINCIPAL";
		String[] vOpciones = { "1. Ver todos los agentes", "2. Ver agentes según sueldo", "3. Dar de alta nuevo piso",
				"4. Dar de alta nueva arma", "5. Dar de alta nuevo agente", "6. Encriptar todo", "7. Desencriptar todo", "8. Salir" };
		int opcionMasLarga = calcularAnchoMenu(vOpciones);
		
		for (int i=0; i<vOpciones.length; i++) {
			
			while (vOpciones[i].length()<opcionMasLarga) {
				vOpciones[i] += " ";
			}
		}
		
		int anchoTotal = (opcionMasLarga * 2) + 5;
		
		
		
		pintarTituloMenu(anchoTotal, titulo);
		
		System.out.print("┌");
		for (int i=0; i<anchoTotal; i++) {
			System.out.print("─");
		}
		
		System.out.println("┐");
		
		System.out.println("│ " + vOpciones[0] + " │ " + vOpciones[4] + " │");
		System.out.println("│ " + vOpciones[1] + " │ " + vOpciones[5] + " │");
		System.out.println("│ " + vOpciones[2] + " │ " + vOpciones[6] + " │");
		System.out.println("│ " + vOpciones[3] + " │ " + vOpciones[7] + " │");
		
		System.out.print("└");
		for (int i=0; i<anchoTotal; i++) {
			System.out.print("─");
		}
		
		System.out.println("┘");
		
		
		
		return userInput;
	}
	
	private static void pintarTituloMenu (int anchoTotal, String titulo) {
		for (int i=0; i<((anchoTotal-titulo.length())/2); i++) {
			System.out.print(" ");
		}
		
		System.out.print("╔");
		
		for (int i=0; i<titulo.length()+2; i++) {
			System.out.print("═");
		}
		
		System.out.println("╗");
		
		for (int i=0; i<((anchoTotal-titulo.length())/2); i++) {
			System.out.print(" ");
		}

		System.out.println("║ " + titulo + " ║");
		
		for (int i=0; i<((anchoTotal-titulo.length())/2); i++) {
			System.out.print(" ");
		}
		
		System.out.print("╚");
		
		for (int i=0; i<titulo.length()+2; i++) {
			System.out.print("═");
		}
		
		System.out.println("╝");
	}

	private static int calcularAnchoMenu(String[] vOpciones) {

		int ancho = 0;

		for (String opcion : vOpciones) {
			if (opcion.length() > ancho)
				ancho = opcion.length();
		}
		
		return ancho;

	}

}
