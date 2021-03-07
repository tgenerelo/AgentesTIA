package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import IODatos.IODatos;

class TestIODatos {

	ArrayList<String> vArmas = new ArrayList<String>();
	
	@BeforeEach
	void test() {
		vArmas.clear();
		vArmas.add("Pistola soporífera");
		vArmas.add("Sulfato atómico");
		vArmas.add("Granada magnética");
		vArmas.add("Cañón \"Servando\"");
		vArmas.add("Mechero lanzallamas");
		vArmas.add("Rayo perforador");
	}
	
	@Test
	void testCargarArmas() throws Exception {
		assertEquals(vArmas, IODatos.cargarDatosTexto("recursos/Armas.txt"));
	}
	
	@Test
	void testCargarArmasErrorVector() throws Exception {
		vArmas.add("Nueva arma");
		assertNotEquals(vArmas, IODatos.cargarDatosTexto("recursos/Armas.txt"));
	}
	
	@Test
	void testCargarArmasErrorFichero() throws Exception {
		assertNotEquals(vArmas, IODatos.cargarDatosTexto("recursos/Pisos.txt"));
	}
	
	@Test
	void testExcepcionLectura() throws Exception {
		try {
			IODatos.cargarDatosTexto("con.txt");
		} catch (Exception e) {
			fail("El método arrojó una excepción no controlada.");
		}
	}
	
}
