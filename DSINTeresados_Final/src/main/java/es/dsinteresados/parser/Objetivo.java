package es.dsinteresados.parser;

import es.dsinteresados.clases.Accion;

public class Objetivo {
	private Accion.Tipo tipoAccion;
	private String autor;
	private String objetivo;

	public boolean VerificarMeta(Accion accion) {
		if (!this.tipoAccion.equals(accion.getTipoAccion()) ) {
			return false;
		}
		
		if (!this.autor.equals(accion.getAutor().getNombre())){
			return false;
		}
		
		return this.objetivo.equals(accion.getObjetivo().getNombre());
	}
}
