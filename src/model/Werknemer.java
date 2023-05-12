package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Purpose of the program
 */
public class Werknemer extends Persoon {
    private static final double GRENSWAARDE_BONUS = 4500.0;

    private static final int DEFAULT_MAAND_SALARIS = 0;
    private static final int MAANDEN_PER_JAAR = 12;

    private double maandSalaris;

    public Werknemer(String naam, String woonplaats, Afdeling afdeling, double maandSalaris) {
        super(naam, woonplaats, afdeling);
        this.maandSalaris = maandSalaris;
    }

    public Werknemer(String naam) {
        super(naam);
        this.maandSalaris = DEFAULT_MAAND_SALARIS;
    }

    public Werknemer() {
        super();
        this.maandSalaris = DEFAULT_MAAND_SALARIS;
    }

    public boolean heeftRechtOpBonus() {
        return maandSalaris >= GRENSWAARDE_BONUS;
    }

    @Override
    public double berekenJaarInkomen() {
        double jaarInkomen = MAANDEN_PER_JAAR * maandSalaris;

        if (heeftRechtOpBonus()) {
            jaarInkomen += maandSalaris;
        }

        return jaarInkomen;
    }

    @Override
    public String toString() {
        return String.format("%s en is een werknemer %s recht op een bonus",
                super.toString(), heeftRechtOpBonus() ? "met" : "zonder");
    }

    public void setMaandSalaris(double maandSalaris) {
        if (maandSalaris < 0) {
            System.err.println("Het maandsalaris moet 0 of groter zijn");
            this.maandSalaris = DEFAULT_MAAND_SALARIS;
        } else {
            this.maandSalaris = maandSalaris;
        }
    }
}
