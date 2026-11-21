package es.dsinteresados.resolutor;

import java.util.HashMap;

import es.dsinteresados.clases.*;
import es.dsinteresados.clases.Personaje.EstadoLibertad;
import es.dsinteresados.clases.Personaje.EstadoVida;

public class BaseDatos {

    public static HashMap<String, Cosa> inicializar() {
        HashMap<String, Cosa> bd = new HashMap<>();

        Habilidad vuelo = registrar(bd, new Habilidad("Vuelo"));
        Habilidad invisibilidad = registrar(bd, new Habilidad("Invisibilidad"));
        Habilidad espejo = registrar(bd, new Habilidad("Espejo"));

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
        
        Heroe ariadna = registrar(bd, new Heroe("Ariadna", EstadoLibertad.Libre, EstadoVida.Vivo));
        Heroe icaro = registrar(bd, new Heroe("Icaro", EstadoLibertad.Libre, EstadoVida.Vivo));
        Heroe dedalo = registrar(bd, new Heroe("Dedalo", EstadoLibertad.Libre, EstadoVida.Vivo));
        Heroe perseo = registrar(bd, new Heroe("Perseo", EstadoLibertad.Libre, EstadoVida.Vivo));
        Heroe teseo = registrar(bd, new Heroe("Teseo", EstadoLibertad.Libre, EstadoVida.Vivo));
        Heroe heracles = registrar(bd, new Heroe("Heracles", EstadoLibertad.Libre, EstadoVida.Vivo));

        // Ceto, Kraken y Minotauro empiezan presos
        Criatura ceto = registrar(bd, new Criatura("Ceto", EstadoLibertad.Preso, EstadoVida.Vivo));
        Criatura kraken = registrar(bd, new Criatura("Kraken", EstadoLibertad.Preso, EstadoVida.Vivo));
        Criatura minotauro = registrar(bd, new Criatura("Minotauro", EstadoLibertad.Preso, EstadoVida.Vivo));

        Criatura medusa = registrar(bd, new Criatura("Medusa", EstadoLibertad.Libre, EstadoVida.Vivo));
        Criatura grayas = registrar(bd, new Criatura("las Grayas", EstadoLibertad.Libre, EstadoVida.Vivo));
        Criatura ninfas = registrar(bd, new Criatura("las Ninfas", EstadoLibertad.Libre, EstadoVida.Vivo));
        Criatura pegaso = registrar(bd, new Criatura("Pegaso", EstadoLibertad.Libre, EstadoVida.Muerto));

        crearEquipamiento(bd, "Escudo de Bronce", atenea, null, false);
        crearEquipamiento(bd, "Hoz de Acero", hermes, null, true);
        crearEquipamiento(bd, "Casco de Hades", hades, invisibilidad, false);
        crearEquipamiento(bd, "Zurron Magico", ninfas, null, false);
        crearEquipamiento(bd, "Sandalias Aladas", ninfas, vuelo, false);
        crearEquipamiento(bd, "Bridas de Oro", hefesto, null, false);
        crearEquipamiento(bd, "Hilo de Ariadna", ariadna, null, false);
        crearEquipamiento(bd, "Espada de Teseo", poseidon, null, true);
        
        // Objetos sin poseedor inicial
        crearEquipamiento(bd, "Espejo de Mano", null, espejo, false);
        crearEquipamiento(bd, "Anillo de Invisibilidad", null, invisibilidad, false);
        crearEquipamiento(bd, "Conjuro de Vuelo", null, vuelo, false);

        ParteDeCriatura ojoGrayas = new ParteDeCriatura("ojo/diente", grayas, null, grayas);
        registrar(bd, ojoGrayas);
        grayas.addTieneObjetos(ojoGrayas);
        grayas.setOrigenDeParte(ojoGrayas);

        ParteDeCriatura cabezaMedusa = new ParteDeCriatura("cabeza de Medusa", medusa, null, medusa);
        registrar(bd, cabezaMedusa);
        medusa.addTieneObjetos(cabezaMedusa);
        medusa.setOrigenDeParte(cabezaMedusa);
        
        ParteDeCriatura cabezaMinotauro = new ParteDeCriatura("cabeza del Minotauro", minotauro, null, minotauro);
        registrar(bd, cabezaMinotauro);
        minotauro.addTieneObjetos(cabezaMinotauro);
        minotauro.setOrigenDeParte(cabezaMinotauro);

        ParteDeCriatura cuernoMinotauro = new ParteDeCriatura("Cuerno del Minotauro", minotauro, null, minotauro);
        registrar(bd, cuernoMinotauro);
        minotauro.addTieneObjetos(cuernoMinotauro);

        ParteDeCriatura cabezaCeto = new ParteDeCriatura("cabeza de Ceto", ceto, null, ceto);
        registrar(bd, cabezaCeto);
        ceto.addTieneObjetos(cabezaCeto);
        ceto.setOrigenDeParte(cabezaCeto);
        
        ParteDeCriatura cabezaKraken = new ParteDeCriatura("cabeza de Kraken", kraken, null, kraken);
        registrar(bd, cabezaKraken);
        kraken.addTieneObjetos(cabezaKraken);
        kraken.setOrigenDeParte(cabezaKraken);

        registrar(bd, new Material("Cera de Abejas", null));
        registrar(bd, new Material("Plumas", null));

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