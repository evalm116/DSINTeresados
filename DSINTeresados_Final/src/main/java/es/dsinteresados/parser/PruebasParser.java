package es.dsinteresados.parser;

import java.util.ArrayList;
import java.util.List;

public class PruebasParser {

	public static void main(String[] args) {
		String textoObjetivo= "¿Puede Teseo liberar Andromeda?";
		
		String textoCondicionFavor = "Perseo tiene el favor de Atenea";
		String textoCondicionEnojo = "Casiopea tiene el enojo de Poseidon";
		String textoCondicionObjeto = "Perseo tiene Ovillo de Lana"; 
		List<String> texto = new ArrayList<>();
		
		
		texto.add(textoObjetivo);
		texto.add("Condiciones:");
		texto.add(textoCondicionObjeto);
		texto.add(textoCondicionFavor);
		texto.add(textoCondicionEnojo);
		
		InputParser parser = new InputParser(texto);
		
		System.out.println(parser);
	}
}
