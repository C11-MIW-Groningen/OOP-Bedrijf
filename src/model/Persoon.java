package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Een persoon binnen ons bedrijf
 */
public class Persoon {
    private static final String DEFAULT_WOONPLAATS = "Onbekend";
    private static final int DEFAULT_MAAND_SALARIS = 0;
    private static final String DEFAULT_NAAM = "Onbekend";
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

    public Persoon(String naam) {
        this.naam = naam;
        this.woonplaats = DEFAULT_WOONPLAATS;
        this.maandSalaris = DEFAULT_MAAND_SALARIS;
        this.personeelsNummer = ++aantalPersonen;
    }

    public Persoon() {
        this.naam = DEFAULT_NAAM;
        this.woonplaats = DEFAULT_WOONPLAATS;
        this.maandSalaris = DEFAULT_MAAND_SALARIS;
        this.personeelsNummer = ++aantalPersonen;
    }

    public double berekenJaarInkomen() {
        return 12 * maandSalaris;
    }
}
