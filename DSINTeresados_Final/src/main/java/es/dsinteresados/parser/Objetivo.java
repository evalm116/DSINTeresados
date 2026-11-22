package es.dsinteresados.parser;

import es.dsinteresados.clases.Accion;
import es.dsinteresados.clases.Accion.Tipo;

public class Objetivo {
	private Accion.Tipo tipo;
	private String autor;
	private String objetivo;

	public Objetivo(Tipo tipoAccion, String autor, String objetivo) {
		super();
		this.tipo = tipoAccion;
		this.autor = autor;
		this.objetivo = objetivo;
	}

	public Accion.Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Accion.Tipo tipoAccion) {
		this.tipo = tipoAccion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public boolean verificarMeta(Accion accion) {
		if (!this.tipo.equals(accion.getTipo())) {
			return false;
		}

		if (!this.autor.equals(accion.getAutor().getNombre())) {
			return false;
		}

		return this.objetivo.equals(accion.getObjetivo().getNombre());
	}
	
	public String mensajeVerificacion(boolean condicion) {
		return (condicion)? "Si"
				: "No";					
	}

	public static Accion.Tipo parsearTipo(String str) {
		switch (str.toLowerCase()) {
		case "liberar":
			return Accion.Tipo.Liberar;
		case "matar":
			return Accion.Tipo.Matar;
		case "capturar":
			return Accion.Tipo.Capturar;
		case "buscar":
			return Accion.Tipo.Buscar;
		default:
			return Accion.Tipo.Liberar;
		}
	}

	public static Objetivo parsear(String linea) {
		String limpia = linea.replaceAll("(\\?|¿|Puede|\\ba\\b|\\bal\\b)", "").trim();
		String[] partes = limpia.split("\\s+");
		if (partes.length < 3) {
			return null;
		}
		return new Objetivo(parsearTipo(partes[1]), partes[0], partes[2]);
	}

	@Override
	public String toString() {
		return "Objetivo [tipoAccion=" + tipo + ", autor=" + autor + ", objetivo=" + objetivo + "]";
	}
	

}
