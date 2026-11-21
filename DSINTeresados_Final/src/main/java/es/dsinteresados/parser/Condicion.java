package es.dsinteresados.parser;

public class Condicion {
	public enum Tipo {
		Favor, Enojo, Objeto, NoObjeto, NoPresente
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
		if (linea.contains("no esta presente")) {
			String[] a = linea.split("no esta presente");
			this.sujeto = a[0].trim();
			this.tipo = Tipo.NoPresente;
			this.predicado = null;

		} else if (linea.contains("no tienen") || linea.contains("no tiene")) {
			String separador = linea.contains("no tienen") ? "no tienen" : "no tiene";
			String[] a = linea.split(separador);
			this.sujeto = a[0].trim();
			this.tipo = Tipo.NoObjeto;
			this.predicado = a[1].trim();

		} else {
			String separador = linea.contains("tienen") ? "tienen" : "tiene";
			String[] a = linea.split(separador);
			this.sujeto = a[0].trim();
			String resto = a[1].trim();

			if (resto.startsWith("el enojo de")) {
				this.tipo = Tipo.Enojo;
				this.predicado = resto.replace("el enojo de", "").trim();
			} else if (resto.startsWith("el favor de")) {
				this.tipo = Tipo.Favor;
				this.predicado = resto.replace("el favor de", "").trim();
			} else {
				this.tipo = Tipo.Objeto;
				this.predicado = resto;
			}
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