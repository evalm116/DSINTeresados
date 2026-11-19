package es.dsinteresados.parser;

import org.apache.poi.util.NotImplemented;

public class Condicion {
	public enum Tipo {
		Favor, Enojo, Objeto
	}

	private String sujeto;
	private Tipo tipo;
	private String predicado;

	public Condicion(String sujeto, Tipo tipo, String predicado) {
		super();
		this.sujeto = sujeto;
		this.tipo = tipo;
		this.predicado = predicado;
	}

	public Condicion(String linea) {

		String[] a = linea.split("tiene");
		this.sujeto = a[0].strip();

		if (a[1].strip().startsWith("el enojo de")) {
			this.tipo = Tipo.Enojo;
			this.predicado = a[1].replace("el enojo de", "").strip();
		} else if (a[1].strip().startsWith("el favor de")) {
			this.tipo = Tipo.Favor;
			this.predicado = a[1].replace("el favor de", "").strip();
		} else {
			this.tipo = Tipo.Objeto;
			this.predicado = a[1].strip();
		}
	}

	public String getSujeto() {
		return sujeto;
	}

	public void setSujeto(String sujeto) {
		this.sujeto = sujeto;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getPredicado() {
		return predicado;
	}

	public void setPredicado(String predicado) {
		this.predicado = predicado;
	}

	@Override
	public String toString() {
		return "Condicion [sujeto=" + sujeto + ", tipo=" + tipo + ", predicado=" + predicado + "]";
	}
	
	

}
