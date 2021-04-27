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
        System.out.print(MITARBEITEREINSTELLEN + ": Mitarbeiter anstellen; \n" + RAUMBAUEN
                + ": Neuen raum erstellen; \n" + RAUMRESERVIEREN + ": Raum reservieren; \n" + MITARBEITERLISTE
                + ": Liste der Mitarbeiter; \n" + RAUMLISTE + ": Liste der Räume; \n" + RESERVIERUNGENFUERRAUM
                + ": Reservierung für einen Raum; \n" + ENDE + ": beenden -> ");
        return input.nextInt();
    }

    /**
     * Methode zum erstellen eines mitarbeiter
     * 
     * @return Mitarbeiter
     */
    public Mitarbeiter mitarbeiterErstellen() {
        System.out.println("--------- Neuer Mitarbeiter ---------");
        System.out.print("Vorname: ");
        input.nextLine();
        String vorname = input.nextLine();
        System.out.print("Nachname: ");
        String nachname = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        if(emailExists(email)) {
            System.out.println("cdsc");
            throw new IllegalArgumentException("Mitarbeiter exestiert schon");
        }
        return new Mitarbeiter(vorname, nachname, email);
    }

    public boolean emailExists(String email) {
        for (Mitarbeiter mitarbeiter : mitarbeiterListe) {
            if(mitarbeiter.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Liste der Mitarbeiter in die konsole drucken
     */
    public void printMitarbeiter() {
        System.out.println("--------- List der Mitarbeiter ---------");
        for (int i = 0; i < mitarbeiterListe.size(); i++) {
            System.out.println(i + ": " +  mitarbeiterListe.get(i));
        }
    }

    /**
     * Methode zum erstellen eines Raumes
     * 
     * @return Raum
     */
    public Raum raumErstellen() {
        System.out.println("--------- Neuer Raum ---------");
        System.out.print("Gebäudenummer: ");
        int geb = input.nextInt();
        input.nextLine();
        System.out.print("EtagenNummer: ");
        int etage = input.nextInt();
        input.nextLine();
        System.out.print("Raumnummer: ");
        int raum = input.nextInt();
        input.nextLine();

        return new Raum(geb, etage, raum);
    }

    /**
     * Liste der Raeume in die konsole drucken
     */
    public void printRaeume() {
        System.out.println("--------- List der Räume ---------");
        for (int i = 0; i < raumListe.size(); i++) {
            System.out.println(i + ": " +  raumListe.get(i).getRaumOnly());
        }
    }

    /**
     * Hier wird abhängig vom benutzer die richtige artikel methode ausgeführt
     * 
     * @param funktion Befehl des benutzer
     */
    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
        case MITARBEITEREINSTELLEN:
            mitarbeiterListe.add(mitarbeiterErstellen());
            break;
        case MITARBEITERLISTE:
            printMitarbeiter();
            break;
        case RAUMBAUEN:
            raumListe.add(raumErstellen());
            break;
        case RAUMLISTE:
            printRaeume();
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
        int funktion = -1;

        while (funktion != ENDE) {
            try {
                funktion = einleseFunktion();
                System.out.println();
                ausfuehrenFunktion(funktion);
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
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
        new Dialog().start();
    }
}
