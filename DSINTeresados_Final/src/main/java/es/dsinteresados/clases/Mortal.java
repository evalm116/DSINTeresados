package es.dsinteresados.clases;

import java.util.ArrayList;
import java.util.List;

public class Mortal extends Personaje {
	private List<Dios> tieneFavorDe;
	private List<Dios> tieneEnojoDe;
		
	
	public Mortal(String nombre, EstadoLibertad estadoLibertad, EstadoVida estadoVida) {
		super(nombre, estadoLibertad, estadoVida);
		this.tieneFavorDe = new ArrayList<>();
		this.tieneEnojoDe = new ArrayList<>();
	}

	public boolean addTieneFavorDe(Dios mortal) {
		return this.tieneFavorDe.add(mortal);
	}
	
	public boolean rmTieneFavorDe(Dios mortal) {
		return this.tieneFavorDe.remove(mortal);
	}
	
	public boolean containsTieneFavorDe(Dios mortal) {
		return this.tieneFavorDe.contains(mortal);
	}
	
	public boolean addTieneEnojoDe(Dios mortal) {
		return this.tieneEnojoDe.add(mortal);
	}
	
	public boolean rmTieneEnojoDe(Dios mortal) {
		return this.tieneEnojoDe.remove(mortal);
	}
	
	public boolean containsTieneEnojoDe(Dios mortal) {
		return this.tieneEnojoDe.contains(mortal);
	}
}
