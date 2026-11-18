package es.dsinteresados.clases;

public sealed interface FuenteDeHabilidad permits Heroe, Equipamiento, ParteDeCriatura{
	String getNombre();
}
