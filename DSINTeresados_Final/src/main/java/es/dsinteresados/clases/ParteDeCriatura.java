package es.dsinteresados.clases;

public final class ParteDeCriatura extends Objeto implements FuenteDeHabilidad {
	private Habilidad permiteHabilidad;
	private Criatura criaturaOrigen;

	public ParteDeCriatura(String nombre, Personaje poseedor, Habilidad permiteHabilidad, Criatura criaturaOrigen) {
		super(nombre, poseedor);
		this.permiteHabilidad = permiteHabilidad;
		this.criaturaOrigen = criaturaOrigen;
	}

	public Habilidad getPermiteHabilidad() {
		return permiteHabilidad;
	}

	public void setPermiteHabilidad(Habilidad permiteHabilidad) {
		this.permiteHabilidad = permiteHabilidad;
	}

	public Criatura getCriaturaOrigen() {
		return criaturaOrigen;
	}

	public void setCriaturaOrigen(Criatura criaturaOrigen) {
		this.criaturaOrigen = criaturaOrigen;
	}

}
