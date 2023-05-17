package controller;

import database.AfdelingDAO;
import database.DBaccess;
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
        DBaccess dBaccess = new DBaccess("Bedrijf", "userBedrijf", "userBedrijfPW");
        dBaccess.openConnection();

        AfdelingDAO afdelingDAO = new AfdelingDAO(dBaccess);
        afdelingDAO.slaAfdelingOp(new Afdeling("HR", "Hilversum"));

        for (Afdeling afdeling : afdelingDAO.geefAfdelingen()) {
            System.out.println(afdeling);
        }

        dBaccess.closeConnection();
    }

    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdien %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }
}
