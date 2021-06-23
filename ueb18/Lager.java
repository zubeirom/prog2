import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * eine Klasse, die ein Lager für Artikel definiert
 * 
 * 
 *
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */
public class Lager {

    private Artikel[] lager;

    public Lager(int dimension) {
        if (dimension > 0) {
            this.lager = new Artikel[dimension];
        } else {
            throw new IllegalArgumentException("Dimension muss größer als null sein");
        }
    }

    public Lager() {
        this.lager = new Artikel[10];
    }

    /**
     * Sort using bubble sort with custom criteria
     * @return artikel array
     */
    public Artikel[] getSorted(BiPredicate<Artikel, Artikel> predicate) {
        return sort(predicate, this.lager);
    }

    /**
     * Apply function to each article
     * @param func functional interface
     */
    public void applyToArticles(Function<Artikel, Artikel> operation) {
        for (Artikel artikel : lager) {
            artikel = operation.apply(artikel);
        }
    }

    
    /**
     * Filter articles by criteria
     * @param predicate will determine if criteria applies
     * @return new article array
     */
    public Artikel[] filter(Predicate<Artikel> predicate) {
        return (Artikel[]) Arrays.stream(this.lager).filter(predicate).toArray();
    }

    /**
     * Apply operation to filtered article by criteria
     * @param predicate Criteria in which we filter the articles;
     * @param operation Operation in which we apply the filtered articles
     */
    public void applyToSomeArticles(Predicate<Artikel> predicate, Function<Artikel, Artikel> operation) {
        for (Artikel artikel : this.lager) {
            if(predicate.test(artikel)) {
                artikel = operation.apply(artikel);
            }
        }
    }

    /**
     * Search article by criteria and return sorted by criteria
     * @param search search criteria
     * @param sort sort operation
     * @return search and sorted array
     */
    public Artikel[] getArticles(Predicate<Artikel> search, BiPredicate<Artikel, Artikel> sort) {
        Artikel[] filtered = filter(search);
        return sort(sort, filtered);
    }

    /**
     * Run multiple filters on lager and return it;
     * @param predicates list of predicates
     * @return filtered articles
     */
    public Artikel[] filterAll(List<Predicate<Artikel>> predicates) {
        return (Artikel[]) Arrays.stream(this.lager).filter(
            predicates.stream().reduce(x -> true, Predicate::and)
        ).toArray();
    }
 
    /**
     * Gibt artikelanzahl zurück
     *
     * @return artikelanzahl
     */
    public int getArtikelAnzahl() {
        int counter = 0;
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * gibt lagergrösse zurück
     * 
     * @return lager
     */
    public int getLagerGroesse() {
        return lager.length;
    }

    /**
     * Lege neues artikel in das lager
     * 
     * @param artikel artikel objekt
     */
    public void legeAnArtikel(Artikel artikel) {
        int index = searchEmptySpace();
        if (index >= 0) {
            lager[index] = artikel;
        } else {
            throw new IndexOutOfBoundsException("Lager ist voll");
        }
    }

    /**
     * Entferne artikelnummer von lager
     * 
     * @param artikelNr Artikelnummer
     */
    public void entferneArtikel(int artikelNr) {
        for (int i = 0; i < lager.length; i++) {
            if (artikelNr == lager[i].getArtikelNr()) {
                lager[i] = null;
                break;
            }
        }
    }

    /**
     * Mit der Methode wird der Bestand um eine bestimmte Menge erhöht
     * 
     * @param menge Die menge die dazu addiert wird
     */
    public void bucheZugang(int artikelNr, int menge) {
        Artikel artikel = filterNachArtikelnummer(artikelNr);
        if (artikel != null) {
            artikel.bucheZugang(menge);
        }
    }

    /**
     * Mit der Methode wird der Bestand um eine bestimmte Menge vermindert
     * 
     * @param menge Die menge die den Bestand vermindert
     */
    public void bucheAbgang(int artikelNr, int menge) {
        Artikel artikel = filterNachArtikelnummer(artikelNr);
        if (artikel != null) {
            artikel.bucheZugang(menge);
        } else {
            throw new NullPointerException("Artikel exestiert nicht");
        }
    }

    /**
     * Aendere preisartikel nach prozent
     * 
     * @param prozent Prozent
     */
    public void aenderePreisAllerArtikel(double prozent) {
        for (int i = 0; i < lager.length; i++) {
            double preis = lager[i].getPreis();
            double ergebnis = (5 / 100) * preis;
            lager[i].setPreis(preis + ergebnis);
        }
    }

    /**
     * Bekomme artikel vom lager nach ort
     * 
     * @param index Ort im lager
     * @return Artikel objekt
     */
    public Artikel getArtikel(int index) {
        if (index >= 0 && index < lager.length) {
            return lager[index];
        }
        throw new IndexOutOfBoundsException("Position exestiert nicht im Lager");
    }

    /**
     * Gibt gesamtpreis zurück
     * 
     * @return gesamtpreis
     */
    public double getGesamtPreis() {
        double sum = 0;
        for (Artikel artikel : lager) {
            if (artikel != null) {
                sum += artikel.getGesamtPreis();
            }
        }
        return sum;
    }

    /**
     * Gibt bestand als liste zurück
     */
    public void ausgebenBestandsListe() {
        System.out.println("ArtNr Beschreibung                                      Preis  Bestand       Gesamt");
        System.out.println("--------------------------------------------------------------------------------------");
        for (Artikel artikel : lager) {
            if (artikel != null) {
                System.out.println(artikel.getArtikelNr() + " " + artikel.getBeschreibung() + "     "
                        + String.format("%.2f", artikel.getPreis()) + "  " + artikel.getBestand() + "       "
                        + String.format("%.2f", artikel.getGesamtPreis()));
            }
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Gesamtwert:                                                                  "
                + String.format("%.2f", getGesamtPreis()));
    }

    /**
     * Gibt lager information
     * 
     * @return lager liste
     */
    public String toString() {
        String list = new String();
        for (Artikel artikel : lager) {
            if (artikel != null) {
                list += artikel.toString() + "\n";
            }
        }

        return list;
    }

    /**
     * Suche lager nach artikelnummer
     * 
     * @param artikelNr Artikelnummer
     * @return Artikel
     */
    private Artikel filterNachArtikelnummer(int artikelNr) {
        for (int i = 0; i < lager.length; i++) {
            if (artikelNr == lager[i].getArtikelNr()) {
                return lager[i];
            }
        }
        return null;
    }

    /**
     * Suche leeren ort im lager
     * 
     * @return index
     */
    private int searchEmptySpace() {
        return Arrays.asList(lager).indexOf(null);
    }

    /**
     * generic bubble sort operation to use for article lists
     * @param predicate sort criteria
     * @param artikel article list
     * @return sorted article array
     */
    private Artikel[] sort(BiPredicate<Artikel, Artikel> predicate, Artikel[] artikel) {
        for (int i = 0; i < artikel.length; i++)
            for (int j = 0; j < artikel.length-i-1; j++)
                if (artikel[j] != null && artikel[j+1] != null && predicate.test(artikel[j], artikel[j+1])) {
                    Artikel temp = artikel[j];
                    artikel[j] = artikel[j+1];
                    artikel[j+1] = temp;
                }

        return artikel;
    }

}
