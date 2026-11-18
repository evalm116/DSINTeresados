package es.dsinteresados.clases;

import java.util.ArrayList;
import java.util.List;

public final class Heroe extends Mortal implements FuenteDeHabilidad {
	private List<Habilidad> tieneHabilidad;

	public Heroe(String nombre, EstadoLibertad estadoLibertad, EstadoVida estadoVida) {
		super(nombre, estadoLibertad, estadoVida);
		this.tieneHabilidad = new ArrayList<>();
	}

	public boolean addTieneHabilidad(Habilidad mortal) {
		return this.tieneHabilidad.add(mortal);
	}

	public boolean rmTieneHabilidad(Habilidad mortal) {
		return this.tieneHabilidad.remove(mortal);
	}

	public boolean containsTieneHabilidad(Habilidad mortal) {
		return this.tieneHabilidad.contains(mortal);
	}

}
