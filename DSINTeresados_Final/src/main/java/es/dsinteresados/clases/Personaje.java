package es.dsinteresados.clases;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje extends Cosa {

	public enum EstadoLibertad {
		Libre, Preso
	};

	public enum EstadoVida {
		Vivo, Muerto
	};

	private List<Personaje> conoceUbicacion;
	private EstadoLibertad estadoLibertad = EstadoLibertad.Libre;
	private EstadoVida estadoVida = EstadoVida.Vivo;
	private List<Objeto> tieneObjetos;

	public Personaje(String nombre, EstadoLibertad estadoLibertad, EstadoVida estadoVida) {
		super(nombre);
		this.estadoLibertad = estadoLibertad;
		this.estadoVida = estadoVida;
		this.conoceUbicacion = new ArrayList<>();
		this.tieneObjetos = new ArrayList<>();
	}

	public boolean addConoceUbicacion(Personaje personaje) {
		return this.conoceUbicacion.add(personaje);
	}

	public boolean rmConoceUbicacion(Personaje personaje) {
		return this.conoceUbicacion.remove(personaje);
	}

	public boolean containsConoceUbicacion(Personaje personaje) {
		return this.conoceUbicacion.contains(personaje);
	}

	public boolean addTieneObjetos(Objeto objeto) {
		return this.tieneObjetos.add(objeto);
	}

	public boolean rmTieneObjetos(Objeto objeto) {
		return this.tieneObjetos.remove(objeto);
	}

	public boolean containsTieneObjetos(Objeto objeto) {
		return this.tieneObjetos.contains(objeto);
	}

	public EstadoLibertad getEstadoLibertad() {
		return estadoLibertad;
	}

	public void setEstadoLibertad(EstadoLibertad estadoLibertad) {
		this.estadoLibertad = estadoLibertad;
	}

	public EstadoVida getEstadoVida() {
		return estadoVida;
	}

	public void setEstadoVida(EstadoVida estadoVida) {
		this.estadoVida = estadoVida;
	}
}
