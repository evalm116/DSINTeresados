package es.dsinteresados.parser;

import es.dsinteresados.clases.Accion;
import es.dsinteresados.clases.Accion.Tipo;

public class Objetivo {
	private Accion.Tipo tipoAccion;
	private String autor;
	private String objetivo;

	public Objetivo(Tipo tipoAccion, String autor, String objetivo) {
		super();
		this.tipoAccion = tipoAccion;
		this.autor = autor;
		this.objetivo = objetivo;
	}

	public Accion.Tipo getTipoAccion() {
		return tipoAccion;
	}

	public void setTipoAccion(Accion.Tipo tipoAccion) {
		this.tipoAccion = tipoAccion;
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

	public boolean VerificarMeta(Accion accion) {
		if (!this.tipoAccion.equals(accion.getTipoAccion())) {
			return false;
		}

		if (!this.autor.equals(accion.getAutor().getNombre())) {
			return false;
		}

		return this.objetivo.equals(accion.getObjetivo().getNombre());
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
		return "Objetivo [tipoAccion=" + tipoAccion + ", autor=" + autor + ", objetivo=" + objetivo + "]";
	}
	

}
