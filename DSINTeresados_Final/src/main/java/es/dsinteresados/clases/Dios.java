package es.dsinteresados.clases;

import java.util.ArrayList;
import java.util.List;

public class Dios extends Personaje {

	private List<Mortal> otorgaFavorA;
	private List<Mortal> otorgaEnojoA;
	
	
	public Dios(String nombre, EstadoLibertad estadoLibertad, EstadoVida estadoVida) {
		super(nombre, estadoLibertad, estadoVida);
		this.otorgaFavorA = new ArrayList<>();
		this.otorgaEnojoA = new ArrayList<>();
	}
	
	public boolean addOtorgaEnojoA(Mortal mortal) {
		return this.otorgaEnojoA.add(mortal);
	}
	
	public boolean rmOtorgaEnojoA(Mortal mortal) {
		return this.otorgaEnojoA.remove(mortal);
	}
	
	public boolean containsOtorgaEnojoA(Mortal mortal) {
		return this.otorgaEnojoA.contains(mortal);
	}
	
	public boolean addOtorgaFavorA(Mortal mortal) {
		return this.otorgaFavorA.add(mortal);
	}
	
	public boolean rmOtorgaFavorA(Mortal mortal) {
		return this.otorgaFavorA.remove(mortal);
	}
	
	public boolean containsOtorgaFavorA(Mortal mortal) {
		return this.otorgaFavorA.contains(mortal);
	}
}
