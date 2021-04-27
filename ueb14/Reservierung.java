
public class Reservierung {

    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;

    private Mitarbeiter mitarbeiter;
    private Raum raum;

    public Reservierung(Uhrzeit beginn, Uhrzeit ende) {
        int bCon = beginn.getConcatinated();
        int eCon = ende.getConcatinated();
        if (eCon <= bCon) {
            throw new IllegalArgumentException("Ende ist kleiner als Beginn");
        }
        this.beginn = beginn;
        this.ende = ende;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

    public void setRaum(Raum raum) {
        this.raum = raum;
    }

    public Raum getRaum() {
        return raum;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public Uhrzeit getBeginn() {
        return beginn;
    }

    public Uhrzeit getEnde() {
        return ende;
    }

    @Override
    public String toString() {
        return "Reservierung [beginn=" + beginn + ", bemerkung=" + bemerkung + ", ende=" + ende + ", mitarbeiter="
                + mitarbeiter + ", raum=" + raum + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reservierung other = (Reservierung) obj;
        if (beginn == null) {
            if (other.beginn != null)
                return false;
        } else if (!beginn.equals(other.beginn))
            return false;
        if (bemerkung == null) {
            if (other.bemerkung != null)
                return false;
        } else if (!bemerkung.equals(other.bemerkung))
            return false;
        if (ende == null) {
            if (other.ende != null)
                return false;
        } else if (!ende.equals(other.ende))
            return false;
        if (mitarbeiter == null) {
            if (other.mitarbeiter != null)
                return false;
        } else if (!mitarbeiter.equals(other.mitarbeiter))
            return false;
        if (raum == null) {
            if (other.raum != null)
                return false;
        } else if (!raum.equals(other.raum))
            return false;
        return true;
    }

}