package org.mvpigs.arnold.logica;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public enum Planeta {
    MERCURY (3.303e+23, 2.4397e6, true),     
    VENUS   (4.869e+24, 6.0518e6, true),     
    EARTH   (5.976e+24, 6.37814e6, true),     
    MARS    (6.421e+23, 3.3972e6, true),     
    JUPITER (1.9e+27,   7.1492e7, false),     
    SATURN  (5.688e+26, 6.0268e7, false),     
    URANUS  (8.686e+25, 2.5559e7, false),     
    NEPTUNE (1.024e+26, 2.4746e7, false);



    private Double masa;
    private Double radio;
    private boolean terrestre;
    public static final Double G = 6.67300E-11;

    private Planeta (Double masa, Double radio, boolean terrestre) {
        this.masa = masa;
        this.radio = radio;
        this.terrestre = terrestre;
    }

    public Double getRadio() {
        return this.radio;
    }

    public Double getMasa(){
        return this.masa;
    }
   
    private double gravedadSuperficie() {
        return G * getMasa() / (Math.pow(getRadio(), 2));
    }

    private double tuMasa (Double pesoHumano) {
        return pesoHumano / EARTH.gravedadSuperficie();
    }

    public double pesoSuperficie(Double pesoHumano) {
        return tuMasa(pesoHumano) * gravedadSuperficie();
    }

    public boolean esTerrestre(){
        return this.terrestre;
    }

    public static Planeta[] getPlanetasTerrestres(){
        return Arrays.stream(Planeta.values()).filter(planeta -> planeta.esTerrestre()).toArray(Planeta[]::new);
    }

    public static Planeta[] getGigantesGaseosos(){
        return Arrays.stream(Planeta.values()).filter(planeta -> !(planeta.esTerrestre())).toArray(Planeta[]::new);
    }


    
}