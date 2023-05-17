package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
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

        System.out.println(afdelingen);
    }

    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdien %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }
}
