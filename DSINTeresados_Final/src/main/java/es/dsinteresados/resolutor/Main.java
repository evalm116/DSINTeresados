package es.dsinteresados.resolutor;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import es.dsinteresados.clases.*;
import es.dsinteresados.parser.Condicion;
import es.dsinteresados.parser.InputParser;

public class Main {
	public static void main(String[] args) throws IOException {
		
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		
		// Directorio de entrada y procesado de archivos
		
		String directorioEntrada = "TODO";
		String directorioSalida = "TODO";
		String prefijoEscenario = "TODO";
		String extension = ".txt";
		
		DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directorioEntrada), prefijoEscenario + "*");
		
		for (Path path: stream) {
			if (Files.isRegularFile(path) && path.toString().endsWith(extension)) {
				
				/*// Inicializar el dominio
				HashMap<String, Cosa> baseDatosInicial = inicializarBaseDatos();*/
				
				// Leer archivo entrada
				System.out.println("Descripción escenario");
				List<String> lineas = Files.readAllLines(path);
				lineas.forEach(System.out::println);
				System.out.println("Fin Descripción escenario");
				
				//Parser
				InputParser parser = new InputParser(lineas);
				
				//
				
			}
		}
	}

	private static HashMap<String, Cosa> inicializarBaseDatos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static HashMap<String, Cosa> obtenerBaseDatosAlterada(List<Condicion> condiciones){
		
	}
}
