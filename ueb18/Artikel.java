/**
 * eine Klasse, die einen Artikel, der 3 Attribute (artikelNr, art, bestand)
 * hat,nimmt.
 * 
 * 
 *
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */

public class Artikel {

    private int artikelNr;
    private String art;
    private int bestand;
    private double preis;

    public Artikel(int artikelNr, String art, int bestand, double preis) {
        if (artikelNr > 999 && artikelNr < 10000) {
            this.artikelNr = artikelNr;
        } else {
            throw new IllegalArgumentException("Artikelnummer muss 4-stellig sein");
        }
        if (!art.isEmpty()) {
            this.art = art;
        } else {
            throw new IllegalArgumentException("Artikelart muss angegeben werden");
        }
        if (bestand > 0) {
            this.bestand = bestand;
        } else {
            throw new IllegalArgumentException("Bestand darf nicht kleiner als null sein");
        }
        if (preis > 0) {
            this.preis = preis;
        } else {
            throw new IllegalArgumentException("Preis darf nicht kleiner als null sein");
        }
    }

    public Artikel(int artikelNr, String art, double preis) {
        if (artikelNr > 999 && artikelNr < 10000) {
            this.artikelNr = artikelNr;
        } else {
            throw new IllegalArgumentException("Artikelnummer muss 4-stellig sein");
        }
        if (art != null) {
            this.art = art;
        } else {
            throw new IllegalArgumentException("Artikelart muss angegeben werden");
        }
        if (preis > 0) {
            this.preis = preis;
        } else {
            throw new IllegalArgumentException("Preis darf nicht kleiner als null sein");
        }
    }

    /**
     * Mit der Methode bekommen wir die artikelNr
     * 
     * @return Artikelnummer
     */
    public int getArtikelNr() {
        return artikelNr;
    }

    /**
     * Mit der Methode bekommen wir die Art eines Artikel
     * 
     * @return Art des Artikels
     */
    public String getArt() {
        return art;
    }

    /**
     * Mit der Methode setzen wir eine neue Art für den Artikel
     * 
     * @param art Art des Artikels
     */
    public void setArt(String art) {
        this.art = art;
    }

    /**
     * Mit der Methode bekommen wir den Bestand des Artikels
     * 
     * @return Bestand des artikels
     */
    public int getBestand() {
        return bestand;
    }

    /**
     * Setzen mit Methode den bestand neu
     * 
     * @param bestand Bestand des Artikels
     */
    public void setBestand(int bestand) {
        if (bestand > 0) {
            this.bestand = bestand;
        } else {
            System.out.println("Bestand muss größer als 0 sein");
        }
    }

    /**
     * Mit der Methode bekommen wir den preis des Artikels
     * 
     * @return Bestand des artikels
     */
    public double getPreis() {
        return preis;
    }

    /**
     * Setzen mit Methode den preis neu
     * 
     * @param bestand Bestand des Artikels
     */
    public void setPreis(double preis) {
        if (preis > 0) {
            this.preis = preis;
        } else {
            System.out.println("Preis muss größer als 0 sein");
        }
    }

    /**
     * Mit der Methode wird der Bestand um eine bestimmte Menge erhöht
     * 
     * @param menge Die menge die dazu addiert wird
     */
    public void bucheZugang(int menge) {
        if (bestand > 0) {
            this.bestand = bestand + menge;
        } else {
            System.out.println("Bestand muss größer als 0 sein");
        }
    }

    /**
     * Mit der Methode wird der Bestand um eine bestimmte Menge vermindert
     * 
     * @param menge Die menge die den Bestand vermindert
     */
    public void bucheAbgang(int menge) {
        if (bestand - menge > 0) {
            this.bestand = bestand - menge;
        } else {
            System.out.println("Bestand muss größer als 0 sein");
        }
    }

    /**
     * Mit der methode geben wir die beschreibung des artikels zurück
     * 
     * @return Beschreibung des artikels
     */
    public String getBeschreibung() {
        return art;
    }

    /**
     * Mit der methode erhalten wir den Gesamtpreis multipliziert den Bestands
     * 
     * @return den gesamtpreis des artikels
     */
    public double getGesamtPreis() {
        return preis * bestand;
    }

    /**
     * Methode gibt Artikelnummer, Artikelart und Bestand zurück
     * 
     * @return Zeichenkette der Attribute artikelnr, art und bestand
     */
    public String toString() {
        return "Artikel: " + artikelNr + " Bezeichnung: " + art + " Bestand: " + bestand + " Preis: " + preis;
    }
}
