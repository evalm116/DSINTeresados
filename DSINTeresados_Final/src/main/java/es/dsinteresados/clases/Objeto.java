package es.dsinteresados.clases;

public abstract class Objeto extends Cosa {
	private Personaje poseedor;

	public Objeto(String nombre, Personaje poseedor) {
		super(nombre);
		this.poseedor = poseedor;
	}

	public Personaje getPoseedor() {
		return poseedor;
	}

	public void setPoseedor(Personaje poseedor) {
		this.poseedor = poseedor;
	}

}
