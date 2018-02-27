package org.mvpigs.arnold;

import java.util.Arrays;

import org.mvpigs.arnold.logica.*;

public class ArnoldEnumType {
    public static void main(String [] args) {
        double pesoHumano = 175;
        for (Planeta planeta: Planeta.values()) {
            System.out.println("Your weight on " + planeta.name() + " is: " + String.format("%.6f", planeta.pesoSuperficie(pesoHumano)));
        }
        Planeta[] planetasTerrestres = Planeta.getPlanetasTerrestres();
        Planeta[] gigantesGaseosos = Planeta.getGigantesGaseosos();

        System.out.println("\n Terrestrial planets: \n" + Arrays.toString(planetasTerrestres));
        System.out.println("\n Gas giant planets: \n" + Arrays.toString(gigantesGaseosos));
        

    }
}