package es.dsinteresados.clases;

public abstract class Accion extends Cosa {
	public enum Tipo {
		Buscar, Liberar, Capturar, Matar
	}

	private Personaje autor;
	private Personaje objetivo;
	private Tipo tipoAccion;

	public Accion(String nombre, Personaje autor, Personaje objetivo, Tipo tipoAccion) {
		super(nombre);
		this.autor = autor;
		this.objetivo = objetivo;
		this.tipoAccion = tipoAccion;
	}

	public Personaje getAutor() {
		return autor;
	}

	public void setAutor(Personaje autor) {
		this.autor = autor;
	}

	public Personaje getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Personaje objetivo) {
		this.objetivo = objetivo;
	}

	public Tipo getTipoAccion() {
		return tipoAccion;
	}

	public void setTipoAccion(Tipo tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

}
