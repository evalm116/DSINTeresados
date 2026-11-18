package es.dsinteresados.clases;

public final class Equipamiento extends Objeto implements FuenteDeHabilidad {
	
	private Habilidad permiteHabilidad;
	private boolean esIndestructible;
	
	
	public Equipamiento(String nombre, Personaje poseedor, Habilidad permiteHabilidad, boolean esIndestructible) {
		super(nombre, poseedor);
		this.permiteHabilidad = permiteHabilidad;
		this.esIndestructible = esIndestructible;
	}
	
	public Equipamiento(String nombre, Personaje poseedor, Habilidad permiteHabilidad) {
		this(nombre, poseedor, permiteHabilidad, false);
	}

	public Habilidad getPermiteHabilidad() {
		return permiteHabilidad;
	}

	public void setPermiteHabilidad(Habilidad permiteHabilidad) {
		this.permiteHabilidad = permiteHabilidad;
	}

	public boolean isEsIndestructible() {
		return esIndestructible;
	}

	public void setEsIndestructible(boolean esIndestructible) {
		this.esIndestructible = esIndestructible;
	}	
	
}
