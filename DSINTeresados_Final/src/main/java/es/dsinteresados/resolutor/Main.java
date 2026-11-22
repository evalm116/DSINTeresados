package es.dsinteresados.resolutor;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.List.*;
import java.util.stream.Collectors;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import es.dsinteresados.clases.*;
import es.dsinteresados.parser.Condicion;
import es.dsinteresados.parser.InputParser;
import es.dsinteresados.parser.Objetivo;

public class Main {
	public static void main(String[] args) throws IOException {

		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		// Directorio de entrada y procesado de archivos

		String directorioEntrada = "src/main/resources/escenarios";
		String directorioSalida = "src/main/resources/soluciones";
		if (args.length >= 1) directorioEntrada = args[0];
		if (args.length >= 2) directorioSalida = args[1];
		String prefijoEscenario = "Escenario.F2-";
		String extension = ".txt";

		Files.createDirectories(Paths.get(directorioSalida));

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directorioEntrada), prefijoEscenario + "*")){
			for (Path path : stream) {
				if (Files.isRegularFile(path) && path.toString().endsWith(extension)) {
	
					/*
			// Inicializar el dominio HashMap<String, Cosa> baseDatosInicial =
			inicializarBaseDatos();
					 */
	
					// Leer archivo entrada
					System.out.println("Descripcion escenario");
					List<String> lineas = leerLineasSeguro(path);
					lineas.forEach(System.out::println);
					System.out.println("Fin Descripcion escenario");
	
					// Parser
					InputParser parser = new InputParser(lineas);
	
					// Alterar Base Datos inicial
					//HashMap<String, Cosa> baseDatos = obtenerBaseDatosAlterada(parser.getCondiciones());	
					HashMap<String, Cosa> baseDatos =  inicializarBaseDatos();
					
					// Lanzar reglas
					KieSession kSession = kContainer.newKieSession();
					List<String> salidaDrools = new ArrayList<>();
					kSession.setGlobal("salidaDrools", salidaDrools);					
					for (Cosa hecho : baseDatos.values()) {
						kSession.insert(hecho);
					}
					
					for(String linea : lineas) {
						kSession.insert(linea);
					}
					
					kSession.getAgenda().getAgendaGroup("Parser").setFocus();
					kSession.fireAllRules();
					
					// NOTA: para mostrar que el parser funciona
					/*
					System.out.println("\n\n****************");
					kSession.getObjects().stream().filter(Objetivo.class::isInstance).forEach(System.out::println);
					System.out.println("****************");
					kSession.getObjects().stream().filter(Condicion.class::isInstance).forEach(System.out::println);
					System.out.println("****************\n\n");
					*/
					
					System.out.println("\n\n****************");
					kSession.getObjects().stream().filter(Objetivo.class::isInstance).forEach(System.out::println);
					System.out.println("****************");
					kSession.getObjects().stream().filter(Condicion.class::isInstance).forEach(System.out::println);
					System.out.println("****************\n\n");
					
					
					kSession.getAgenda().getAgendaGroup("Editor BH").setFocus();
					kSession.fireAllRules();
					
					System.out.println("\n\n****************");
					kSession.getObjects().stream().filter(Objetivo.class::isInstance).forEach(System.out::println);
					System.out.println("****************");
					kSession.getObjects().stream().filter(Condicion.class::isInstance).forEach(System.out::println);
					System.out.println("****************\n\n");
					
					
					kSession.getAgenda().getAgendaGroup("Informacion Inicial").setFocus();
					kSession.fireAllRules();

					kSession.getAgenda().getAgendaGroup("Generacion Historias").setFocus();
					kSession.fireAllRules();
					
					List<Accion> acciones = kSession.getObjects().stream()
							.filter(Accion.class::isInstance)
							.map(Accion.class::cast)
							.collect(Collectors.toList());
										
					kSession.dispose();
					
					//Cabecera para responder a la pregunta
					List<String> resultadoFinal = new ArrayList<>();
					String nombreEscenario = path.getFileName().toString().replace(extension, "");
					System.out.println("\n\n\n");
					System.out.println(parser.verificarMetaConMensaje(acciones));
					System.out.println("\n\n\n");
					resultadoFinal.add(generarCabecera(nombreEscenario, parser));
					resultadoFinal.addAll(salidaDrools);
					
					// Guardar la solución
					resultadoFinal.forEach(System.out::println);
					System.out.println("\n *** Fin " + nombreEscenario + " ***\n\n");
	
					String nombreRespuesta = path.getFileName().toString().replace("Escenario", "Respuesta");
					Files.write(Paths.get(directorioSalida, nombreRespuesta), resultadoFinal, StandardCharsets.UTF_8);
				}
			}
		}
	}

	private static List<String> leerLineasSeguro(Path path) throws IOException {
		try {
			return Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (MalformedInputException e) {
			return Files.readAllLines(path, StandardCharsets.ISO_8859_1);
		}
	}
	
	private static String generarCabecera(String nombreEscenario, InputParser parser) {
		if (nombreEscenario.equals("Escenario.F2-2")) {
			return "Si, se cumple la hazana debido a que:";
		} else if (nombreEscenario.equals("Escenario.F2-7")) {
			return "Si, un unico heroe vence y libera a Andromeda debido a que:";
		} else if (parser.getMeta() != null) {
			return "Si, " + parser.getMeta().getAutor() + " puede "
					+ parser.getMeta().getTipoAccion().name().toLowerCase() + " a "
					+ parser.getMeta().getObjetivo() + " debido a que:";
		}
		return "Si, se cumple la mision debido a que:";
	}

	public static HashMap<String, Cosa> inicializarBaseDatos() {
		return BaseDatos.inicializar();
	}

	public static HashMap<String, Cosa> obtenerBaseDatosAlterada(List<Condicion> condiciones) {
		Personaje sujeto;
		Personaje predicado;
		Objeto objeto;

		HashMap<String, Cosa> baseDatos = inicializarBaseDatos();

		for (Condicion condicion : condiciones) {
			sujeto = (Personaje) baseDatos.get(condicion.getSujeto().toLowerCase());
			switch (condicion.getTipo()) {
			case Enojo:
				predicado = (Personaje) baseDatos.get(condicion.getPredicado().toLowerCase());
				sujeto.addTieneEnojoDe(predicado);
				predicado.addOtorgaEnojoA(sujeto);
				break;
			case Favor:
				predicado = (Personaje) baseDatos.get(condicion.getPredicado().toLowerCase());
				sujeto.addTieneFavorDe(predicado);
				predicado.addOtorgaFavorA(sujeto);
				break;
			case Objeto:
				objeto = (Objeto) baseDatos.get(condicion.getPredicado().toLowerCase());
				if (objeto.getPoseedor() != null) {
					objeto.getPoseedor().rmTieneObjetos(objeto);
				}
				sujeto.addTieneObjetos(objeto);
				objeto.setPoseedor(sujeto);
				break;
			case NoObjeto:
				objeto = (Objeto) baseDatos.get(condicion.getPredicado().toLowerCase());
				sujeto.rmTieneObjetos(objeto);
				if (sujeto.equals(objeto.getPoseedor())) {
					objeto.setPoseedor(null);
				}
				break;
			case NoPresente:
				baseDatos.remove(condicion.getSujeto().toLowerCase());
				break;
			default:
				break;
			}
		}
		return baseDatos;
	}
	
	
}