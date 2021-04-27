public class Mitarbeiter extends Person {
    private String email;

    public Mitarbeiter(String vorname, String nachname, String email) {
        super(vorname, nachname);

        if(email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email ist nicht definiert");
        }

        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung) throws Exception {
        Reservierung reservierung= new Reservierung(beginn, ende);
        reservierung.setBemerkung(bemerkung);
        reservierung.setRaum(raum);
        reservierung.setMitarbeiter(this);

        raum.addReservierung(reservierung);
    }

    @Override
    public String toString() {
        return getVorname() + " " + getNachname() + " (" + email + ")";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mitarbeiter other = (Mitarbeiter) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    
    
}
