package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Bestuur ons bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();
        File afdelingBestand = new File("resources/Afdelingen.txt");

        try (Scanner afdelingenScanner = new Scanner(afdelingBestand)) {
            while (afdelingenScanner.hasNextLine()) {
                String afdelingsNaam = afdelingenScanner.nextLine();
                String afdelingsPlaats = afdelingenScanner.nextLine();
                afdelingen.add(new Afdeling(afdelingsNaam, afdelingsPlaats));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het is niet gelukt om het afdelingen bestand te openen.");
        }

        ArrayList<Persoon> personen = new ArrayList<>();
        File personenBestand = new File("resources/Personen.csv");

        try (Scanner personenScanner = new Scanner(personenBestand)) {
            while (personenScanner.hasNextLine()) {
                String[] persoonsInformatie = personenScanner.nextLine().split(",");
                String typePersoon = persoonsInformatie[0];
                String naam = persoonsInformatie[1];
                String woonplaats = persoonsInformatie[2];
                int afdelingsIndex = Integer.parseInt(persoonsInformatie[3]);
                double ietsMetGeld = Double.parseDouble(persoonsInformatie[4]);

                switch (typePersoon) {
                    case "Werknemer":
                        personen.add(new Werknemer(naam, woonplaats, afdelingen.get(afdelingsIndex), ietsMetGeld));
                        break;
                    case "Zzper":
                        personen.add(new Zzper(naam, woonplaats, afdelingen.get(afdelingsIndex), ietsMetGeld));
                        break;
                    case "Vrijwilliger":
                        personen.add(new Vrijwilliger(naam, woonplaats, afdelingen.get(afdelingsIndex)));
                        break;
                    default:
                        System.out.printf("Ik weet niet wat ik met persoonstype %s moet doen\n", typePersoon);
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het is niet gelukt om het personen bestand te openen");
        }

        File uitvoerBestand = new File("resources/PersonenPerAfdeling.txt");
        try (PrintWriter printWriter = new PrintWriter(uitvoerBestand)) {
            for (Afdeling afdeling : afdelingen) {
                printWriter.printf("Afdeling: %s\n", afdeling.getAfdelingsNaam());

                for (Persoon persoon : personen) {
                    if (persoon.getAfdeling().equals(afdeling)) {
                        printWriter.printf("-- %s\n", persoon);
                    }
                }

                printWriter.println();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het is niet gelukt het uitvoer bestand te maken/openen");
        }
    }

    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdien %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }
}
