package es.dsinteresados.clases;

public class Criatura extends Personaje {
	
	private ParteDeCriatura origenDeParte;	
	
	public Criatura(String nombre, EstadoLibertad estadoLibertad, EstadoVida estadoVida) {
		super(nombre, estadoLibertad, estadoVida);
		// TODO Auto-generated constructor stub
	}
	
	public Criatura(String nombre, EstadoLibertad estadoLibertad, EstadoVida estadoVida, ParteDeCriatura origenDeParte) {
		super(nombre, estadoLibertad, estadoVida);
		// TODO Auto-generated constructor stub
		this.origenDeParte = origenDeParte;		
	}

	public ParteDeCriatura getOrigenDeParte() {
		return origenDeParte;
	}

	public void setOrigenDeParte(ParteDeCriatura origenDeParte) {
		this.origenDeParte = origenDeParte;
	}	
}
