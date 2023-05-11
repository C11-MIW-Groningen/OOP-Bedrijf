package controller;

import model.Persoon;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Bestuur ons bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        System.out.println(Persoon.aantalPersonen);
        Persoon baas = new Persoon("Mark", "Den Haag", 10000);
        System.out.println(Persoon.aantalPersonen);
        System.out.println(baas.personeelsNummer);
        Persoon medewerker = new Persoon("Caroline", "Delft", 4000);
        System.out.println(Persoon.aantalPersonen);
        System.out.println(medewerker.personeelsNummer);
    }
}
