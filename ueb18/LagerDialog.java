import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programm zum testen von Lager
 * 
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */
public class LagerDialog {

    Lager lager;
    private Scanner input = new Scanner(System.in);

    // Klassenkonstanten
    private static final int ARTIKELANLEGEN = 1;
    private static final int ZUGANGBUCHEN = 2;
    private static final int ABGANGBUCHEN = 3;
    private static final int LAGERGROESSE = 5;
    private static final int ENTFERNEARTIKEL = 8;
    private static final int PREISEBEARBEITEN = 9;
    private static final int BESTANDAUSGEBEN = 10;
    private static final int LAGERANLEGEN = 11;
    private static final int ARTIKELANZAHL = 12;
    private static final int ALLEARTIKEL = 13;
    private static final int ENDE = 0;

    /**
     * Hier wird eine neues Artikel angelegt
     * 
     * @return neues Artikel
     */

    private Artikel artikelAnlegen() {
        System.out.println();
        System.out.print("Artikelnummer: ");
        int artikelNr = input.nextInt();
        input.nextLine();

        System.out.println("Artikelart: ");
        String art = input.nextLine().trim();

        System.out.print("Preis: ");
        double preis = input.nextDouble();
        input.nextLine();

        System.out.println("Bestand (Drücke Enter, falls nicht vorhanden): ");
        String eingabe = input.nextLine();
        int bestand = eingabe.isEmpty() ? 0 : Integer.parseInt(eingabe);

        Artikel neuerArtikel;

        if (bestand == 0) {
            neuerArtikel = new Artikel(artikelNr, art, preis);
        } else {
            neuerArtikel = new Artikel(artikelNr, art, bestand, preis);
        }

        System.out.println();

        System.out.println(
                "Welchen Artikel wollen sie erstellen? \n 1: Artikel \n 2: CD \n 3: Video \n 4: Buch \n ---->  ");
        int artikelWahl = input.nextInt();
        input.nextLine();

        switch (artikelWahl) {
            case 1:
                return neuerArtikel;
            case 2:
                return cdAnlegen(neuerArtikel);
            case 3:
                return videoAnlegen(neuerArtikel);
            case 4:
                return buchAnlegen(neuerArtikel);
            default:
                throw new IllegalArgumentException("Bitte wählen sie eine Nummer");
        }

    }

    /**
     * CD Anlegen
     * 
     * @param basis Artikel mit basis werten
     * @return Neue CD
     */
    private CD cdAnlegen(Artikel basis) {
        System.out.println("-----CD----");
        System.out.print("Titel: ");
        String titel = input.nextLine().trim();

        System.out.print("Interpret: ");
        String interpret = input.nextLine().trim();

        System.out.print("Titelanzahl: ");
        int anzahlTitel = input.nextInt();

        System.out.println();

        return new CD(basis.getArtikelNr(), basis.getBestand(), basis.getPreis(), interpret, titel, anzahlTitel);
    }

    /**
     * Video Anlegen
     * 
     * @param basis Artikel mit basis werten
     * @return Neue Video
     */
    private Video videoAnlegen(Artikel basis) {
        System.out.println("-----Video----");
        System.out.print("Titel: ");
        String titel = input.nextLine().trim();

        System.out.print("Spieldauer: ");
        int spieldauer = input.nextInt();

        System.out.print("Jahr: ");
        int jahr = input.nextInt();

        System.out.println();

        return new Video(basis.getArtikelNr(), basis.getBestand(), basis.getPreis(), titel, spieldauer, jahr);
    }

    /**
     * Buch Anlegen
     * 
     * @param basis Artikel mit basis werten
     * @return Neue Buch
     */
    private Buch buchAnlegen(Artikel basis) {
        System.out.println("-----Buch----");
        System.out.print("Titel: ");
        String titel = input.nextLine().trim();

        System.out.print("Autor: ");
        String autor = input.nextLine().trim();

        System.out.print("Verlag: ");
        String verlag = input.nextLine().trim();

        System.out.println();

        return new Buch(basis.getArtikelNr(), basis.getBestand(), basis.getPreis(), titel, autor, verlag);
    }

    /**
     * Neues lager erstellen
     * 
     * @return neues lager
     */
    private Lager lagerAnlegen() {
        input.nextLine();
        System.out.println("Lagergrösse (Drücke Enter um Standardgröße 10 zu verwenden): ");
        String eingabe = input.nextLine();
        int größe = eingabe.isEmpty() ? 10 : Integer.parseInt(eingabe);
        return new Lager(größe);
    }

    /**
     * Einzelne befehle werden hier angezeigt
     * 
     * @return Ganzzahl eingabe des benutzer
     */

    private int einleseFunktion() {
        System.out.println("--------- Lager System ---------");
        if (lager == null) {
            System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
        }
        System.out.print(ARTIKELANLEGEN + ": Artikel anlegen; \n" + ZUGANGBUCHEN + ": Bestand des artikels erhöhen; \n"
                + ABGANGBUCHEN + ": Bestand des Artikels verringern; \n" + LAGERGROESSE + ": Lagergrösse anzeigen; \n"
                + ENTFERNEARTIKEL + ": Entferne artikel; \n" + PREISEBEARBEITEN + ": Preise nach prozen bearbeiten; \n"
                + BESTANDAUSGEBEN + ": Bestand des Lagers ausgeben; \n" + LAGERANLEGEN + ": Lager anlegen; \n"
                + ARTIKELANZAHL + ": Artikel anzahl; \n" + ALLEARTIKEL + ": Alle artikel zeigen; \n" + ENDE
                + ": beenden -> ");
        return input.nextInt();
    }

    /**
     * Hier erhalten wird den Bestand
     * 
     * @return Ganzzahl eingabe vom benutzer
     */

    private int bestandEingabe() {
        System.out.println("Bestand: ");
        return input.nextInt();
    }

    /**
     * Hier wird abhängig vom benutzer die richtige artikel methode ausgeführt
     * 
     * @param funktion Befehl des benutzer
     */
    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
            case LAGERANLEGEN:
                lager = lagerAnlegen();
                break;
            case ARTIKELANLEGEN:
                if (lager == null) {
                    System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
                    break;
                }
                Artikel artikel = artikelAnlegen();
                lager.legeAnArtikel(artikel);
                break;
            case ZUGANGBUCHEN:
                if (lager == null) {
                    System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
                    break;
                }
                System.out.println("Artikelnummer: ");
                int artikelNr = input.nextInt();
                lager.bucheZugang(artikelNr, bestandEingabe());
                break;
            case ABGANGBUCHEN:
                if (lager == null) {
                    System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
                    break;
                }
                System.out.println("Artikelnummer: ");
                int artikelNr1 = input.nextInt();
                lager.bucheZugang(artikelNr1, bestandEingabe());
                break;
            case LAGERGROESSE:
                if (lager == null) {
                    System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
                    break;
                }
                System.out.println("Die Lagergrösse ist " + lager.getLagerGroesse());
                break;
            case ENTFERNEARTIKEL:
                if (lager == null) {
                    System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
                    break;
                }
                System.out.println("Artikelnummer: ");
                int artikelNr2 = input.nextInt();
                lager.entferneArtikel(artikelNr2);
                break;
            case PREISEBEARBEITEN:
                if (lager == null) {
                    System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
                    break;
                }
                System.out.println("Prozent: ");
                Double prozent = input.nextDouble();
                lager.aenderePreisAllerArtikel(prozent);
                break;
            case ARTIKELANZAHL:
                if (lager == null) {
                    System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
                    break;
                }
                System.out.println("Die Artikelanzahl lautet " + lager.getArtikelAnzahl());
                break;
            case BESTANDAUSGEBEN:
                if (lager == null) {
                    System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
                    break;
                }
                lager.ausgebenBestandsListe();
                break;
            case ALLEARTIKEL:
                if (lager == null) {
                    System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
                    break;
                }
                System.out.println(lager.toString());
                break;
            case ENDE:
                System.out.println("Programmende");
                break;
            default:
                System.out.println("Falsche Funktion!");
                break;
        }
    }

    /**
     * Hauptschleife des Testprogramms
     */
    public void start() {
        lager = null;
        int funktion = -1;

        while (funktion != ENDE) {
            try {
                funktion = einleseFunktion();
                ausfuehrenFunktion(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (NullPointerException e) {
                System.out.println("Lager oder Artikel exestiert nicht! Bitte erstellen sie diese zuerst.");
            } catch (InputMismatchException e) {
                System.out.println(e + " Falsche Eingabe!");
                input.nextLine();
            } catch (Exception e) {
                System.out.println(e + " Programm beendet");
                funktion = ENDE;
            }
        }
    }

    /**
     * Main methode
     * 
     * @param args
     */

    public static void main(String[] args) {
        new LagerDialog().start();
    }
}
