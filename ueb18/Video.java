/**
 * Fachklasse zur erstellung von Video die von artikel erbt
 * 
 *
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */
public class Video extends Artikel {

    private String titel;
    private int spieldauer;
    private int jahr;

    public Video(int artikelNr, double preis) {
        super(artikelNr, ArtikelTypen.MEDIEN, preis);
    }

    public Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr) {
        super(artikelNr, ArtikelTypen.MEDIEN, bestand, preis);
        if (titel != null && !titel.trim().isEmpty()) {
            this.titel = titel;
        } else {
            throw new IllegalArgumentException("Titel muss angegeben werden");
        }
        if (spieldauer > 0) {
            this.spieldauer = spieldauer;
        } else {
            throw new IllegalArgumentException("Spieldauer muss größer als 0 sein");
        }
        if (jahr >= 1950 || jahr <= 2020) {
            this.jahr = jahr;
        } else {
            throw new IllegalArgumentException("Jahr muss zwischen 1950 und 2020 sein");
        }
    }

    /**
     * Geerbte Methode, gibt den titel zurück
     * 
     * @return Beschreibung des artikels
     */
    @Override
    public String getBeschreibung() {
        return titel;
    }

    /**
     * Gibt titel zurück
     * 
     * @return titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Setzt neues titel
     * 
     * @param titel neuer titel wert
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }

    /**
     * Gibt spieldauer zurück
     * 
     * @return spieldauer
     */
    public int getSpieldauer() {
        return spieldauer;
    }

    /**
     * Setzt neues spieldauer
     * 
     * @param spieldauer neuer spieldauer wert
     */
    public void setSpieldauer(int spieldauer) {
        this.spieldauer = spieldauer;
    }

    /**
     * Gibt jahr zurück
     * 
     * @return jahr
     */
    public int getJahr() {
        return jahr;
    }

    /**
     * Setzt neues jahr
     * 
     * @param jahr neuer jahr wert
     */
    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    /**
     * Methode gibt Attribute zurück
     * 
     * @return Zeichenkette der Attribute
     */
    public String toString() {
        return "Artikelnummer: " + getArtikelNr() + " Bezeichnung: " + getArt() + " Bestand: " + getBestand()
                + " Preis: " + getPreis() + " Titel: " + titel + " Spieldauer: " + spieldauer + " Erscheinungsjahr: "
                + jahr;
    }

}
