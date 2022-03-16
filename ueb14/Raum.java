import java.util.ArrayList;
import java.util.List;

public class Raum {

    private int geb;
    private int etage;
    private int raum;

    private List<Reservierung> reservierungen = new ArrayList<Reservierung>();

    public Raum(int geb, int etage, int raum) {
        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
    }

    public int getGeb() {
        return geb;
    }

    public int getEtage() {
        return etage;
    }

    public int getRaum() {
        return raum;
    }

    public void addReservierung(Reservierung reservierung) throws Exception {
        if (isAvailable(reservierung)) {
            reservierungen.add(reservierung);
        } else {
            throw new Exception("Raum " + reservierung.getRaum().getRaumOnly() + " ist nicht verfügbar zum Zeitpunkt " + reservierung.getBeginn().toString() + " bis "
                    + reservierung.getEnde().toString());
        }
    }

    public boolean isAvailable(Reservierung reservierung) {
        int beginnCon = reservierung.getBeginn().getConcatinated();
        int endeCon = reservierung.getEnde().getConcatinated();

        for (Reservierung res : reservierungen) {
            int b = res.getBeginn().getConcatinated();
            int e = res.getEnde().getConcatinated();

            if (endeCon < e && endeCon >= b) {
                return false;
            }

            if (beginnCon > b && beginnCon <= e) {
                return false;
            }
        }
        return true;
    }

    public Reservierung getReservierung(int index) {
        return reservierungen.get(index);
    }

    public int getAnzahlReservierung() {
        return reservierungen.size();
    }

    public String getRaumOnly() {
        return geb + "-" + etage + "." + raum;
    }

    @Override
    public String toString() {
        String s = new String();
        s = getRaumOnly() + "\n";
        for (Reservierung reservierung : reservierungen) {
            s += "gebucht von " + reservierung.getMitarbeiter().toString() + " von "
                    + reservierung.getBeginn().toString() + " bis " + reservierung.getEnde().toString() + " für "
                    + reservierung.getBemerkung() + "\n";
        }
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Raum other = (Raum) obj;
        if (etage != other.etage)
            return false;
        if (geb != other.geb)
            return false;
        if (raum != other.raum)
            return false;
        return true;
    }

}
