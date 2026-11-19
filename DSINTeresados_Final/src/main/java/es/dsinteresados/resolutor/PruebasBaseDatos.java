package es.dsinteresados.resolutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.dsinteresados.clases.Cosa;
import es.dsinteresados.parser.InputParser;

public class PruebasBaseDatos {
	public static void main(String[] args) {
		String textoObjetivo = "¿Puede Teseo liberar Andromeda?";

		String textoCondicionFavor = "Perseo tiene el favor de Atenea";
		String textoCondicionEnojo = "Casiopea tiene el enojo de Poseidon";
		String textoCondicionObjeto = "Perseo tiene Escudo Espejo";
		List<String> texto = new ArrayList<>();

		texto.add(textoObjetivo);
		texto.add("Condiciones:");
		texto.add(textoCondicionObjeto);
		texto.add(textoCondicionFavor);
		texto.add(textoCondicionEnojo);

		InputParser parser = new InputParser(texto);
		HashMap<String, Cosa> a = Main.obtenerBaseDatosAlterada(parser.getCondiciones());
		a.forEach((key,value) -> System.out.println(key + " = " + value));
	}
}
