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
	private List<Personaje> tieneFavorDe;
	private List<Personaje> tieneEnojoDe;
	private List<Personaje> otorgaFavorA;
	private List<Personaje> otorgaEnojoA;

	public Personaje(String nombre, EstadoLibertad estadoLibertad, EstadoVida estadoVida) {
		super(nombre);
		this.estadoLibertad = estadoLibertad;
		this.estadoVida = estadoVida;
		this.conoceUbicacion = new ArrayList<>();
		this.tieneObjetos = new ArrayList<>();
		this.tieneFavorDe = new ArrayList<>();
		this.tieneEnojoDe = new ArrayList<>();
		this.otorgaFavorA = new ArrayList<>();
		this.otorgaEnojoA = new ArrayList<>();
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

	public boolean addTieneFavorDe(Personaje personaje) {
		return this.tieneFavorDe.add(personaje);
	}

	public boolean rmTieneFavorDe(Personaje personaje) {
		return this.tieneFavorDe.remove(personaje);
	}

	public boolean containsTieneFavorDe(Personaje personaje) {
		return this.tieneFavorDe.contains(personaje);
	}

	public boolean addTieneEnojoDe(Personaje personaje) {
		return this.tieneEnojoDe.add(personaje);
	}

	public boolean rmTieneEnojoDe(Personaje personaje) {
		return this.tieneEnojoDe.remove(personaje);
	}

	public boolean containsTieneEnojoDe(Personaje personaje) {
		return this.tieneEnojoDe.contains(personaje);
	}

	public boolean addOtorgaFavorA(Personaje personaje) {
		return this.otorgaFavorA.add(personaje);
	}

	public boolean rmOtorgaFavorA(Personaje personaje) {
		return this.otorgaFavorA.remove(personaje);
	}

	public boolean containsOtorgaFavorA(Personaje personaje) {
		return this.otorgaFavorA.contains(personaje);
	}

	public boolean addOtorgaEnojoA(Personaje personaje) {
		return this.otorgaEnojoA.add(personaje);
	}

	public boolean rmOtorgaEnojoA(Personaje personaje) {
		return this.otorgaEnojoA.remove(personaje);
	}

	public boolean containsOtorgaEnojoA(Personaje personaje) {
		return this.otorgaEnojoA.contains(personaje);
	}
}