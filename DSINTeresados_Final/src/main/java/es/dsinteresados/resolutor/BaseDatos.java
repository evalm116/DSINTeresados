package es.dsinteresados.resolutor;

import java.util.HashMap;

import es.dsinteresados.clases.*;
import es.dsinteresados.clases.Personaje.EstadoLibertad;
import es.dsinteresados.clases.Personaje.EstadoVida;

public class BaseDatos {

    public static HashMap<String, Cosa> inicializar() {
        HashMap<String, Cosa> bd = new HashMap<>();

        Habilidad vuelo = registrar(bd, new Habilidad("Capacidad De Vuelo"));
        Habilidad invisibilidad = registrar(bd, new Habilidad("Capacidad De Invisibilidad"));
        Habilidad espejo = registrar(bd, new Habilidad("Capacidad Espejo"));

        Dios zeus = registrar(bd, new Dios("Zeus", EstadoLibertad.Libre, EstadoVida.Vivo));
        Dios poseidon = registrar(bd, new Dios("Poseidon", EstadoLibertad.Libre, EstadoVida.Vivo));
        Dios doris = registrar(bd, new Dios("Doris", EstadoLibertad.Libre, EstadoVida.Vivo));
        Dios hades = registrar(bd, new Dios("Hades", EstadoLibertad.Libre, EstadoVida.Vivo));
        Dios hermes = registrar(bd, new Dios("Hermes", EstadoLibertad.Libre, EstadoVida.Vivo));
        Dios atenea = registrar(bd, new Dios("Atenea", EstadoLibertad.Libre, EstadoVida.Vivo));
        Dios hefesto = registrar(bd, new Dios("Hefesto", EstadoLibertad.Libre, EstadoVida.Vivo));

        Mortal andromeda = registrar(bd, new Mortal("Andromeda", EstadoLibertad.Libre, EstadoVida.Vivo));
        Mortal casiopea = registrar(bd, new Mortal("Casiopea", EstadoLibertad.Libre, EstadoVida.Vivo));
        Mortal minos = registrar(bd, new Mortal("Minos", EstadoLibertad.Libre, EstadoVida.Vivo));
        Mortal ariadna = registrar(bd, new Mortal("Ariadna", EstadoLibertad.Libre, EstadoVida.Vivo));
        Mortal icaro = registrar(bd, new Mortal("Icaro", EstadoLibertad.Libre, EstadoVida.Vivo));
        Mortal dedalo = registrar(bd, new Mortal("Dedalo", EstadoLibertad.Libre, EstadoVida.Vivo));

        Heroe perseo = registrar(bd, new Heroe("Perseo", EstadoLibertad.Libre, EstadoVida.Vivo));
        Heroe teseo = registrar(bd, new Heroe("Teseo", EstadoLibertad.Libre, EstadoVida.Vivo));
        Heroe heracles = registrar(bd, new Heroe("Heracles", EstadoLibertad.Libre, EstadoVida.Vivo));

        // Ceto, Kraken y Minotauro empiezan presos
        Criatura ceto = registrar(bd, new Criatura("Ceto", EstadoLibertad.Preso, EstadoVida.Vivo));
        Criatura kraken = registrar(bd, new Criatura("Kraken", EstadoLibertad.Preso, EstadoVida.Vivo));
        Criatura minotauro = registrar(bd, new Criatura("Minotauro", EstadoLibertad.Preso, EstadoVida.Vivo));

        Criatura medusa = registrar(bd, new Criatura("Medusa", EstadoLibertad.Libre, EstadoVida.Vivo));
        Criatura grayas = registrar(bd, new Criatura("Grayas", EstadoLibertad.Libre, EstadoVida.Vivo));
        Criatura ninfas = registrar(bd, new Criatura("Ninfas", EstadoLibertad.Libre, EstadoVida.Vivo));
        Criatura pegaso = registrar(bd, new Criatura("Pegaso", EstadoLibertad.Libre, EstadoVida.Vivo));

        crearEquipamiento(bd, "Escudo De Bronce", atenea, null, false);
        crearEquipamiento(bd, "Hoz De Acero", hermes, null, true);
        crearEquipamiento(bd, "Casco De Hades", hades, invisibilidad, false);
        crearEquipamiento(bd, "Zurron Magico", ninfas, null, false);
        crearEquipamiento(bd, "Sandalias Aladas", ninfas, vuelo, false);
        crearEquipamiento(bd, "Brida De Oro", hefesto, null, false);
        crearEquipamiento(bd, "Hilo De Ariadna", ariadna, null, false);

        // Objetos sin poseedor inicial
        crearEquipamiento(bd, "Escudo Espejo", null, espejo, false);
        crearEquipamiento(bd, "Alas De Icaro", null, vuelo, false);
        crearEquipamiento(bd, "Alas De Dedalo", null, vuelo, false);
        crearEquipamiento(bd, "Espejo De Mano", null, espejo, false);
        crearEquipamiento(bd, "Anillo De Invisibilidad", null, invisibilidad, false);
        crearEquipamiento(bd, "Conjuro De Vuelo", null, vuelo, false);

        ParteDeCriatura ojoGrayas = new ParteDeCriatura("Ojo Grayas", grayas, null, grayas);
        registrar(bd, ojoGrayas);
        grayas.addTieneObjetos(ojoGrayas);
        grayas.setOrigenDeParte(ojoGrayas);

        ParteDeCriatura cabezaMedusa = new ParteDeCriatura("Cabeza Medusa", null, null, medusa);
        registrar(bd, cabezaMedusa);
        medusa.setOrigenDeParte(cabezaMedusa);

        registrar(bd, new Material("Cera De Abejas", null));
        registrar(bd, new Material("Pluma De Aves", null));

        return bd;
    }

    //M�todos auxiliares

    private static <T extends Cosa> T registrar(HashMap<String, Cosa> bd, T elemento) {
        bd.put(elemento.getNombre().toLowerCase(), elemento);
        return elemento;
    }

    private static Equipamiento crearEquipamiento(
            HashMap<String, Cosa> bd,
            String nombre,
            Personaje poseedor,
            Habilidad habilidad,
            boolean esIndestructible) {

        Equipamiento eq = new Equipamiento(nombre, poseedor, habilidad, esIndestructible);
        registrar(bd, eq);

        if (poseedor != null) {
            poseedor.addTieneObjetos(eq);
        }
        if (habilidad != null) {
            habilidad.addEsPermitido(eq);
        }
        return eq;
    }
}