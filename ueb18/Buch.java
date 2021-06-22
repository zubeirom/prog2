/**
 * Fachklasse zur erstellung von Buch die von artikel erbt
 * 
 *
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */
public class Buch extends Artikel {
    private String titel;
    private String autor;
    private String verlag;

    public Buch(int artikelNr, double preis) {
        super(artikelNr, ArtikelTypen.MEDIEN, preis);
    }

    public Buch(int artikelNr, int bestand, double preis, String autor, String titel, String verlag) {
        super(artikelNr, ArtikelTypen.MEDIEN, bestand, preis);
        if (titel != null && !titel.trim().isEmpty()) {
            this.titel = titel;
        } else {
            throw new IllegalArgumentException("Titel muss angegeben werden");
        }
        if (autor != null && !autor.trim().isEmpty()) {
            this.autor = autor;
        } else {
            throw new IllegalArgumentException("Autor muss angegeben werden");
        }
        if (verlag != null && !verlag.trim().isEmpty()) {
            this.verlag = verlag;
        } else {
            throw new IllegalArgumentException("Verlag muss angegeben werden");
        }
    }

    /**
     * Geerbte Methode, gibt den titel und autor zurück
     * 
     * @return Beschreibung des artikels
     */
    @Override
    public String getBeschreibung() {
        return autor + ": " + titel;
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
     * Gibt autor zurück
     * 
     * @return autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Setzt neues autor
     * 
     * @param autor neuer autor wert
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Gibt verlag zurück
     * 
     * @return verlag
     */
    public String getVerlag() {
        return verlag;
    }

    /**
     * Setzt neues verlag
     * 
     * @param verlag neuer verlag wert
     */
    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    /**
     * Methode gibt Attribute zurück
     * 
     * @return Zeichenkette der Attribute
     */
    public String toString() {
        return "Artikelnummer: " + getArtikelNr() + " Bezeichnung: " + getArt() + " Bestand: " + getBestand()
                + " Preis: " + getPreis() + " Titel: " + titel + " Autor: " + autor + " Verlag: " + verlag;
    }
}
