package controller;

import model.Afdeling;
import model.Persoon;
import model.Werknemer;
import model.Zzper;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Bestuur ons bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        Afdeling[] afdelingen = {
                new Afdeling("Uitvoering", "Hilversum"),
                new Afdeling("Support", "Amsterdam"),
                new Afdeling("Management", "Almere"),
                new Afdeling("Documentatie", "Gouda")
        };

        Werknemer baas = new Werknemer("Mark", "Den Haag", afdelingen[2], 10000);
        Werknemer medewerker = new Werknemer("Caroline", "Delft", afdelingen[1], 4000);
        Zzper assistent = new Zzper("Klaas", "Diemen", afdelingen[3], 50.0);
        Zzper projectleider = new Zzper("Ronald", "Zaandam", afdelingen[0], 80);

        assistent.huurIn(160);
        projectleider.huurIn(320);

        Persoon[] personen = {baas, medewerker, assistent, projectleider};

        System.out.printf("Het aantal personen in het bedrijf is %d\n", Persoon.getAantalPersonen());
        for (int persoon = 0; persoon < personen.length; persoon++) {
            System.out.println(personen[persoon]);
        }
        System.out.println();

        for (int persoon = 0; persoon < personen.length; persoon++) {
            toonJaarInkomen(personen[persoon]);
        }
    }

    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdien %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }
}
