package es.dsinteresados.clases;

public abstract class Cosa {

	private String nombre;

	public Cosa(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
