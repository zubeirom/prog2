/**
 * Fachklasse zur erstellung von CD die von artikel erbt
 * 
 *
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */
public class CD extends Artikel {

    private String interpret;
    private String titel;
    private int anzahlTitel;

    public CD(int artikelNr, double preis) {
        super(artikelNr, ArtikelTypen.MEDIEN, preis);
    }

    public CD(int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel) {
        super(artikelNr, ArtikelTypen.MEDIEN, bestand, preis);
        if (titel != null && !titel.trim().isEmpty()) {
            this.titel = titel;
        } else {
            throw new IllegalArgumentException("Titel muss angegeben werden");
        }
        if (interpret != null && !interpret.trim().isEmpty()) {
            this.interpret = interpret;
        } else {
            throw new IllegalArgumentException("Interpret muss angegeben werden");
        }
        if (anzahlTitel > 0) {
            this.anzahlTitel = anzahlTitel;
        } else {
            throw new IllegalArgumentException("Titelanzahl muss 0 sein");
        }
    }

    /**
     * Geerbte Methode, gibt den interpret und titel zurück
     * 
     * @return Beschreibung des artikels
     */
    @Override
    public String getBeschreibung() {
        return interpret + ": " + titel;
    }

    /**
     * Gibt interpret zurück
     * 
     * @return interpret
     */
    public String getInterpret() {
        return interpret;
    }

    /**
     * Setzt neues interpret
     * 
     * @param interpret neuer interpret wert
     */
    public void setInterpret(String interpret) {
        this.interpret = interpret;
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
     * Gibt titelanzahl zurück
     * 
     * @return titelanzahl
     */
    public int getAnzahlTitel() {
        return anzahlTitel;
    }

    /**
     * Setzt titelanzahl titel
     * 
     * @param anzahlTitel neuer titelanzahl wert
     */
    public void setAnzahlTitel(int anzahlTitel) {
        this.anzahlTitel = anzahlTitel;
    }

    /**
     * Methode gibt Attribute zurück
     * 
     * @return Zeichenkette der Attribute
     */
    public String toString() {
        return "Artikelnummer: " + getArtikelNr() + " Bezeichnung: " + getArt() + " Bestand: " + getBestand()
                + " Preis: " + getPreis() + " Interpret: " + interpret + " Titel: " + titel + " TitelAnzahl: "
                + anzahlTitel;
    }

}
