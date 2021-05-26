import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialog {
    NumberCrunch numberCrunch;
    private Scanner input = new Scanner(System.in);
    String[] operations;

    // Klassenkonstanten
    private static final int NUMBERCRUNCH_ERSTELLEN = 1;
    private static final int OPERATIONEN_ERSTELLEN = 2;
    private static final int LISTE_ANZEIGEN = 3;
    private static final int OPERATIONEN_ANZEIGEN = 4;
    private static final int OPERATIONEN_AUSFUEHREN = 5;
    private static final int ENDE = 0;

    /**
     * Einzelne befehle werden hier angezeigt
     * 
     * @return Ganzzahl eingabe des benutzer
     */

    private int einleseFunktion() {
        System.out.println("--------- System ---------");
        System.out.print(NUMBERCRUNCH_ERSTELLEN + ": Numbercrunch erstellen; \n" + OPERATIONEN_ERSTELLEN
                + ": Operationen eingeben; \n" + LISTE_ANZEIGEN + ": Liste anzeigen; \n" + OPERATIONEN_ANZEIGEN
                + ": Operationen anzeigen; \n" + OPERATIONEN_AUSFUEHREN + ": Operationen ausführen; \n" + ENDE
                + ": beenden -> ");
        return input.nextInt();
    }

    /**
     * Methode zum erstellen eines numbercrunch
     * 
     * @return Numbercrunch anonym oder toplevel
     */
    public NumberCrunch numberCrunchErstellen() {
        System.out.println("--------- Numbercrunch erstellen ---------");

        System.out.print("Welche Art: \n");
        System.out.println("0: Anonym");
        System.out.println("1: Toplevel");
        System.out.print("Eingabe: ");
        int type = input.nextInt();
        if (type != 0 && type != 1) {
            throw new IllegalArgumentException("Bitte geben sie 0 oder 1 ein");
        }
        System.out.println();

        System.out.print(
                "Welche Werte - Beispieleingabe: 2.5 3 56.1 - Drücken sie enter um automatisch zu generieren: \n");
        input.nextLine();
        String eingabe = input.nextLine();
        float[] f;
        f = eingabe.isEmpty() ? Helper.generateRandomFloatArray() : Helper.convertToFloat(eingabe);

        return type == 0 ? new NumberCruncherAnonym(f) : new NumberCruncherTopLevel(f);
    }

    /**
     * Operationen erstellen
     * 
     * @return Liste von operationen
     */
    public String[] operationenErstellen() {
        System.out.println("--------- Operationen erstellen ---------\n");
        System.out.println("0: " + Operations.SUM);
        System.out.println("1: " + Operations.SWIRL);
        System.out.println("2: " + Operations.DIVIDE);
        System.out.println("3: " + Operations.SUBSTRACT);
        System.out.println("4: " + Operations.AVERAGE + "\n");

        System.out.println("Beispieleingabe: sum divide swirl \n");
        input.nextLine();
        System.out.print("Eingabe: ");
        String s = input.nextLine();
        return s.split(" ");
    }

    /**
     * Operationen ausführen
     */
    public void operationenAusfuehren() {
        numberCrunch.crunch(operations);
    }

    /**
     * Hier wird abhängig vom benutzer die richtige methode ausgeführt
     * 
     * @param funktion Befehl des benutzer
     * @throws Exception
     */
    private void ausfuehrenFunktion(int funktion) throws Exception {
        switch (funktion) {
            case NUMBERCRUNCH_ERSTELLEN:
                numberCrunch = numberCrunchErstellen();
                System.out.println("Numbercrunch erfolgreich erstellt! \n");
                break;
            case OPERATIONEN_ERSTELLEN:
                if (numberCrunch == null) {
                    System.out.println("Bitte erstellen sie erst einen numbercrunch");
                } else {
                    operations = operationenErstellen();
                    System.out.println("Operationen erfolgreich erstellt! \n");
                }
                break;
            case LISTE_ANZEIGEN:
                if (numberCrunch == null) {
                    System.out.println("Bitte erstellen sie erst einen numbercrunch");
                } else {
                    System.out.println(Arrays.toString(numberCrunch.getNumbers()));
                }
                break;
            case OPERATIONEN_ANZEIGEN:
                if (numberCrunch == null) {
                    System.out.println("Bitte erstellen sie erst einen numbercrunch");
                } else if (operations == null || operations.length == 0) {
                    System.out.println("Bitte erstellen sie operationen");
                } else {
                    System.out.println(Arrays.toString(operations));
                }
                break;
            case OPERATIONEN_AUSFUEHREN:
                if (numberCrunch == null) {
                    System.out.println("Bitte erstellen sie erst einen numbercrunch");
                } else if (operations == null || operations.length == 0) {
                    System.out.println("Bitte erstellen sie operationen");
                } else {
                    numberCrunch.crunch(operations);
                }
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
