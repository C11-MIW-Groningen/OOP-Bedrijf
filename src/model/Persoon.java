package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Een persoon binnen ons bedrijf
 */
public class Persoon {
    public static int aantalPersonen = 0;

    public int personeelsNummer;
    public String naam;
    public String woonplaats;
    public double maandSalaris;

    public Persoon(String naam, String woonplaats, double maandSalaris) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.maandSalaris = maandSalaris;
        this.personeelsNummer = ++aantalPersonen;
    }
}
