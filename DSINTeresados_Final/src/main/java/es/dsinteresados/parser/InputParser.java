package es.dsinteresados.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import es.dsinteresados.clases.Accion;

public class InputParser {
	private Objetivo meta;
	private List<Condicion> condiciones;

	public InputParser(List<String> lineas) {
		super();

		/* Inicializar variables internas */

		parseFile(lineas);
	}

	private void parseFile(List<String> lineas) {
		if (lineas.isEmpty()) {
			return;
		}

		this.meta = Objetivo.parsear(lineas.get(0));

		if (lineas.size() > 2 && lineas.get(1).equals("Condiciones:"))
			this.condiciones = lineas.subList(2, lineas.size()).stream()
					.filter(a -> !a.trim().isEmpty())
					.map(a -> new Condicion(a))
					.collect(Collectors.toList());
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

	public boolean verificarMeta(List<Accion> acciones) {		
		return acciones.stream().anyMatch(o -> this.meta.verificarMeta(o));
	}
	
	public String verificarMetaConMensaje(List<Accion> acciones) {
		return this.meta.mensajeVerificacion(verificarMeta(acciones));
	}
}
