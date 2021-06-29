import java.util.ArrayList;
import java.util.Arrays;
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

    List liste;
    Type type;
    private Scanner input = new Scanner(System.in);

    // Klassenkonstanten
    private static final int SIZE = 1;
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
    private static final int REMOVEBYINDEX = 15;
    private static final int INDEXOF = 16;
    private static final int CREATE = 17;
    private static final int SHOW = 18;
    private static final int ENDE = 0;

    public void createLinkedList() {
        System.out.println();
        System.out.println("Wähle Datentyp - defaults to integer");
        System.out.println("1: String \n" + "2: Integer \n" + "3: Double \n");
        System.out.print("Eingabe: ");
        int value = input.nextInt();
        switch (value) {
            case 1:
                liste = new DoppelVerketteteListe<String>();
                type = Type.STRING;
                break;
            case 2:
                liste = new DoppelVerketteteListe<Integer>();
                type = Type.INTEGER;
                break;
            case 3:
                liste = new DoppelVerketteteListe<Double>();
                type = Type.DOUBLE;
                break;
            default:
                liste = new DoppelVerketteteListe<Integer>();
                break;
        }

    }

    /**
     * Print size of list
     */
    public void printSize() {
        System.out.println();
        System.out.println("Grösse: " + liste.size());
    }

    /**
     * Print if list is empty or not
     */
    public void printIsEmpty() {
        System.out.println();
        if (liste.isEmpty())
            System.out.println("Liste ist leer");
        else
            System.out.println("Liste ist nicht leer");
    }

    /**
     * Print if list contains
     */
    public void printContains() {
        System.out.println();
        System.out.println("Eingabe: ");
        Object o = typeSafeInput();

        System.out.println();
        System.out.println("Ergebnis: " + liste.contains(o));
    }

    /**
     * Print array of list;
     */
    public void printArray() {
        System.out.println();
        if(type == Type.STRING) {
            String[] s = new String[liste.size()];
            System.out.println(Arrays.toString(
                liste.toArray(s)
            ));
        }
        if(type == Type.INTEGER) {
            Integer[] s = new Integer[liste.size()];
            System.out.println(Arrays.toString(
                liste.toArray(s)
            ));
        }
        if(type == Type.DOUBLE) {
            Double[] s = new Double[liste.size()];
            System.out.println(Arrays.toString(
                liste.toArray(s)
            ));
        }
    }

    /**
     * Add to end of list
     */
    public void add() {
        System.out.println();
        System.out.print("Eingabe: ");
        Object o = typeSafeInput();

        liste.add(o);
        show();
    }

    /**
     * Show list
     */
    public void show() {
        System.out.println();
        System.out.println(liste);
        System.out.println();
    }

    /**
     * Remove by value
     */
    public void removeByValue() {
        System.out.println();
        System.out.println("Eingabe: ");
        Object o = typeSafeInput();

        liste.remove(o);
        show();
    }

    /**
     * Append list
     * Static functionality due to laziness
     */
    public void addAll() {
        List l;

        if (type == Type.INTEGER) {
            l = new ArrayList<Integer>();
            l.add(555);
            l.add(666);
            l.add(777);
        } else if (type == Type.DOUBLE) {
            l = new ArrayList<Double>();
            l.add(54.6);
            l.add(66.6);
            l.add(77.7);
        } else {
            l = new ArrayList<Double>();
            l.add("AAA");
            l.add("BBB");
            l.add("CCC");
        }
        liste.addAll(l);
        show();
    }

    /**
     *  Clear list
     */
    public void clear(){
        liste.clear();
        show();
    }

    /**
     * get value
     */
    public void get() {
        System.out.println();
        System.out.print("Index: ");
        int index = input.nextInt();
        System.out.println("Ergebnis: " + liste.get(index));
    }

    /**
     * set value
     */
    public void set() {
        System.out.println();
        System.out.print("Index: ");
        int index = input.nextInt();
        System.out.println("Ersetze durch: ");
        Object o = typeSafeInput();
        liste.set(index, o);
        show();
    }

    /**
     * Add to list by index
     */
    public void addByIndex() {
        System.out.println();
        System.out.print("Index: ");
        int index = input.nextInt();
        System.out.println("Wert: ");
        Object o = typeSafeInput();
        liste.add(index, o);
        show();
    }


    /**
     * remove to list by index
     */
    public void removeByIndex() {
        System.out.println();
        System.out.print("Index: ");
        int index = input.nextInt();
        liste.remove(index);
        show();
    }

    /**
     * Get index by value
     */
    public void indexOf() {
        System.out.println();
        System.out.print("Wert: ");
        Object o = typeSafeInput();
        System.out.println("Ergebnis: " + liste.indexOf(o));
    }

    /**
     * 
     * @return Object 
     */
    private Object typeSafeInput() {
        Object o;
        if (type == Type.INTEGER) {
            o = input.nextInt();
        } else if (type == Type.DOUBLE) {
            o = input.nextDouble();
        } else {
            o = input.next();
        }
        return  o;
    }

    /**
     * Einzelne befehle werden hier angezeigt
     * 
     * @return Ganzzahl eingabe des benutzer
     */
    private int einleseFunktion() {
        System.out.println("--------- Liste System ---------");
        if (liste == null) {
            System.out.println("Keine Liste vorhanden! Bitte erstellen sie ein Liste, geben sie 17 ein\n");
        }
        System.out.print(SIZE + ": size(); \n" + ISEMPTY + ": isEmpty(); \n" + CONTAINS
                + ": contains(); \n" + TOARRAY + ": toArray(); \n" + ADD
                + ": add(); \n" + REMOVE + ": remove() by value; \n" + ADDALL
                + ": addAll(); \n" + CLEAR + ": clear(); \n" + SET
                + ": set(); \n" + GET + ": get(); \n"
                + ADDBYINDEX + ": add() by index; \n" + REMOVEBYINDEX
                + ": remove() by index; \n" + INDEXOF + ": indexOf(); \n" + CREATE
                + ": Erstelle Verkettete Liste; \n" + SHOW + ": List anzeigen; \n" + ENDE + ": beenden -> ");
        return input.nextInt();
    }

    /**
     * Hier wird abhängig vom benutzer die richtige artikel methode ausgeführt
     * 
     * @param funktion Befehl des benutzer
     */
    private void ausfuehrenFunktion(int funktion) {
        if (funktion != CREATE && liste == null) {
            System.out.println("Keine Liste vorhanden! Bitte erstellen sie ein Liste, geben sie 17 ein\n");
            return;
        }
        switch (funktion) {
            case CREATE:
                createLinkedList();
                break;
            case SIZE:

                printSize();
                break;
            case ISEMPTY:

                printIsEmpty();
                break;
            case CONTAINS:

                printContains();
                break;
            case TOARRAY:

                printArray();
                break;
            case ADD:

                add();
                break;
            case SHOW:
                show();
                break;
            case REMOVE:
                removeByValue();
                break;
            case ADDALL:
                addAll();
                break;
            case CLEAR:
                clear();
                break;
            case GET:
                get();
                break;
            case SET:
                set();
                break;
            case ADDBYINDEX:
                addByIndex();
                break;
            case REMOVEBYINDEX:
                removeByIndex();
                break;
            case INDEXOF:
                indexOf();
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
                ausfuehrenFunktion(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (NullPointerException e) {
                System.out.println("Liste exestiert nicht! Bitte erstellen sie diese zuerst.");
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
        new Dialog().start();
    }
}
