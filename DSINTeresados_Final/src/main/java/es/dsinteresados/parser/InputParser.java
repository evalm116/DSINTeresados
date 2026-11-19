package es.dsinteresados.parser;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
	private Objetivo meta;
	private List<Condicion> condiciones;

	public InputParser(List<String> lineas) {
		super();

		/* Inicializar variables internas */

		parseFile(lineas);
	}

	private void parseFile(List<String> lineas) {
		if (lineas.size() < 0) {
			return;
		}

		this.meta = Objetivo.parsear(lineas.get(0));

		if (lineas.size() > 2 && lineas.get(1).equals("Condiciones:"))
			this.condiciones = lineas.subList(2, lineas.size() - 1).stream().map(a -> new Condicion(a)).toList();
		else
			this.condiciones = new ArrayList<>();

	}

	@Override
	public String toString() {
		return "InputParser [meta=" + meta + ", condiciones=" + condiciones + "]";
	}

	public Objetivo getMeta() {
		return meta;
	}

	public List<Condicion> getCondiciones() {
		return condiciones;
	}

	
}
