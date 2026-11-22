package es.dsinteresados.clases;

public class Accion extends Cosa {
	public enum Tipo {
		Buscar, Liberar, Capturar, Matar
	}

	private Personaje autor;
	private Personaje objetivo;
	private Tipo tipo;

	public Accion(String nombre, Personaje autor, Personaje objetivo, Tipo tipoAccion) {
		super(nombre);
		this.autor = autor;
		this.objetivo = objetivo;
		this.tipo = tipoAccion;
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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipoAccion) {
		this.tipo = tipoAccion;
	}

	@Override
	public String toString() {
		return "Accion [autor=" + autor.getNombre() + ", objetivo=" + objetivo.getNombre() + ", tipo=" + tipo + "]";
	}

	
	
}
