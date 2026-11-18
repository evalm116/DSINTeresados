package es.dsinteresados.clases;

import java.util.ArrayList;
import java.util.List;

public class Habilidad extends Cosa {
	public List<FuenteDeHabilidad> esPermitido;

	public Habilidad(String nombre) {
		super(nombre);
		this.esPermitido = new ArrayList<>();
	}

	public boolean addEsPermitido(FuenteDeHabilidad fuente) {
		return this.esPermitido.add(fuente);
	}

	public boolean rmEsPermitido(FuenteDeHabilidad fuente) {
		return this.esPermitido.remove(fuente);
	}

}
