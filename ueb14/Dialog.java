import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Dialog {
    List<Mitarbeiter> mitarbeiterListe = new ArrayList<Mitarbeiter>();
    List<Raum> raumListe = new ArrayList<Raum>();
    private Scanner input = new Scanner(System.in);

    // Klassenkonstanten
    private static final int MITARBEITEREINSTELLEN = 1;
    private static final int RAUMBAUEN = 2;
    private static final int RAUMRESERVIEREN = 3;
    private static final int MITARBEITERLISTE = 4;
    private static final int RAUMLISTE = 5;
    private static final int RESERVIERUNGENFUERRAUM = 6;
    private static final int ENDE = 0;

    /**
     * Einzelne befehle werden hier angezeigt
     * 
     * @return Ganzzahl eingabe des benutzer
     */

    private int einleseFunktion() {
        System.out.println("--------- System ---------");
        System.out.print(MITARBEITEREINSTELLEN + ": Mitarbeiter einstellen; \n" + RAUMBAUEN
                + ": Neuen raum erstellen; \n" + RAUMRESERVIEREN + ": Raum reservieren; \n" + MITARBEITERLISTE
                + ": Liste der Mitarbeiter; \n" + RAUMLISTE + ": Liste der Mitarbeiter; \n" + RESERVIERUNGENFUERRAUM
                + ": Reservierung für einen Raum; \n" + ENDE + ": beenden -> ");
        return input.nextInt();
    }

    /**
     * Hier wird abhängig vom benutzer die richtige artikel methode ausgeführt
     * 
     * @param funktion Befehl des benutzer
     */
    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
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

    public static void main(String[] args) throws Exception {
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        Mitarbeiter m2 = new Mitarbeiter("John", "Doe", "john@htwsaar.de");
        Raum r1 = new Raum(18,0,1);
        Raum r2 = new Raum(2,1,9);
        Raum r3 = new Raum(2,1,10);
        m1.reserviere(r1, new Uhrzeit(12, 30), new Uhrzeit(14, 30), "VOOP");
        m1.reserviere(r2, new Uhrzeit(14, 30), new Uhrzeit(16, 30), "WebTech");
        m2.reserviere(r2, new Uhrzeit(12, 30), new Uhrzeit(13, 15), "Prog II");
        m2.reserviere(r2, new Uhrzeit(9, 0), new Uhrzeit(11, 45), "Prog III");
        m2.reserviere(r2, new Uhrzeit(9, 15), new Uhrzeit(11, 45), "Prog III");

        m2.reserviere(r3, new Uhrzeit(9, 3), new Uhrzeit(11,30), "ITM");

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        // new Dialog().start();
    }
}
