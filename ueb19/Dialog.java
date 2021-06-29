import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Programm zum testen von Lager
 * 
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */
public class Dialog {

    List lager;
    private Scanner input = new Scanner(System.in);

    // Klassenkonstanten
    private static final int GROESSE = 1;
    private static final int ISEMPTY = 2;
    private static final int CONTAINS = 3;
    private static final int TOARRAY = 5;
    private static final int ADD = 8;
    private static final int REMOVE = 9;
    private static final int ADDALL = 10;
    private static final int CLEAR = 11;
    private static final int SET = 12;
    private static final int GET = 13;
    private static final int ADDBYINDEX = 14;
    private static final int REMOVEBYINDEX = 14;
    private static final int INDEXOF = 14;
    private static final int ENDE = 0;

    // private int einleseFunktion() {
    //     System.out.println("--------- Lager System ---------");
    //     if (lager == null) {
    //         System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
    //     }
    //     System.out.print(ARTIKELANLEGEN + ": Artikel anlegen; \n" + ZUGANGBUCHEN + ": Bestand des artikels erhöhen; \n"
    //             + ABGANGBUCHEN + ": Bestand des Artikels verringern; \n" + LAGERGROESSE + ": Lagergrösse anzeigen; \n"
    //             + ENTFERNEARTIKEL + ": Entferne artikel; \n" + PREISEBEARBEITEN + ": Preise nach prozen bearbeiten; \n"
    //             + BESTANDAUSGEBEN + ": Bestand des Lagers ausgeben; \n" + LAGERANLEGEN + ": Lager anlegen; \n"
    //             + ARTIKELANZAHL + ": Artikel anzahl; \n" + ALLEARTIKEL + ": Alle artikel zeigen; \n" + APPLY + ": Apply; \n" + ENDE
    //             + ": beenden -> ");
    //     return input.nextInt();
    // }

    // /**
    //  * Hier erhalten wird den Bestand
    //  * 
    //  * @return Ganzzahl eingabe vom benutzer
    //  */

    // private int bestandEingabe() {
    //     System.out.println("Bestand: ");
    //     return input.nextInt();
    // }

    // /**
    //  * Hier wird abhängig vom benutzer die richtige artikel methode ausgeführt
    //  * 
    //  * @param funktion Befehl des benutzer
    //  */
    // private void ausfuehrenFunktion(int funktion) {
    //     switch (funktion) {
    //         case LAGERANLEGEN:
    //             lager = lagerAnlegen();
    //             break;
    //         case ARTIKELANLEGEN:
    //             if (lager == null) {
    //                 System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
    //                 break;
    //             }
    //             Artikel artikel = artikelAnlegen();
    //             lager.legeAnArtikel(artikel);
    //             break;
    //         case ZUGANGBUCHEN:
    //             if (lager == null) {
    //                 System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
    //                 break;
    //             }
    //             System.out.println("Artikelnummer: ");
    //             int artikelNr = input.nextInt();
    //             lager.bucheZugang(artikelNr, bestandEingabe());
    //             break;
    //         case ABGANGBUCHEN:
    //             if (lager == null) {
    //                 System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
    //                 break;
    //             }
    //             System.out.println("Artikelnummer: ");
    //             int artikelNr1 = input.nextInt();
    //             lager.bucheZugang(artikelNr1, bestandEingabe());
    //             break;
    //         case LAGERGROESSE:
    //             if (lager == null) {
    //                 System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
    //                 break;
    //             }
    //             System.out.println("Die Lagergrösse ist " + lager.getLagerGroesse());
    //             break;
    //         case ENTFERNEARTIKEL:
    //             if (lager == null) {
    //                 System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
    //                 break;
    //             }
    //             System.out.println("Artikelnummer: ");
    //             int artikelNr2 = input.nextInt();
    //             lager.entferneArtikel(artikelNr2);
    //             break;
    //         case PREISEBEARBEITEN:
    //             if (lager == null) {
    //                 System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
    //                 break;
    //             }
    //             System.out.println("Prozent: ");
    //             Double prozent = input.nextDouble();
    //             lager.aenderePreisAllerArtikel(prozent);
    //             break;
    //         case ARTIKELANZAHL:
    //             if (lager == null) {
    //                 System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
    //                 break;
    //             }
    //             System.out.println("Die Artikelanzahl lautet " + lager.getArtikelAnzahl());
    //             break;
    //         case BESTANDAUSGEBEN:
    //             if (lager == null) {
    //                 System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
    //                 break;
    //             }
    //             lager.ausgebenBestandsListe();
    //             break;
    //         case ALLEARTIKEL:
    //             if (lager == null) {
    //                 System.out.println("Kein Lager vorhanden! Bitte erstellen sie ein Lager, geben sie 11 ein");
    //                 break;
    //             }
    //             System.out.println(lager.toString());
    //             break;
    //         case APPLY:
    //             apply();
    //             lager.toString();
    //         case ENDE:
    //             System.out.println("Programmende");
    //             break;
    //         default:
    //             System.out.println("Falsche Funktion!");
    //             break;
    //     }
    // }

    // /**
    //  * Hauptschleife des Testprogramms
    //  */
    // public void start() {
    //     int funktion = -1;

    //     while (funktion != ENDE) {
    //         try {
    //             funktion = einleseFunktion();
    //             ausfuehrenFunktion(funktion);
    //         } catch (IllegalArgumentException e) {
    //             System.out.println(e);
    //         } catch (NullPointerException e) {
    //             System.out.println("Lager oder Artikel exestiert nicht! Bitte erstellen sie diese zuerst.");
    //         } catch (InputMismatchException e) {
    //             System.out.println(e + " Falsche Eingabe!");
    //             input.nextLine();
    //         } catch (Exception e) {
    //             System.out.println(e + " Programm beendet");
    //             funktion = ENDE;
    //         }
    //     }
    // }


    /**
     * Main methode
     * 
     * @param args
     */
    public static void main(String[] args) {
        // new Dialog().start();

        List<Integer> dll = new DoppelVerketteteListe<>();
        dll.add(1);
        dll.add(4);
        dll.add(5);

        System.out.println(dll.indexOf(9));
    }
}
