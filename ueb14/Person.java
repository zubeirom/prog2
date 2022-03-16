public class Person {
    
    private String vorname;
    private String nachname;
    
    public Person(String vorname, String nachname) {
        if(vorname == null || vorname.isEmpty()) {
            throw new IllegalArgumentException("Vorname ist nicht definiert");
        }
        if(nachname == null || nachname.isEmpty()) {
            throw new IllegalArgumentException("Vorname ist nicht definiert");
        }
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    @Override
    public String toString() {
        return "Person [nachname=" + nachname + ", vorname=" + vorname + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (nachname == null) {
            if (other.nachname != null)
                return false;
        } else if (!nachname.equals(other.nachname))
            return false;
        if (vorname == null) {
            if (other.vorname != null)
                return false;
        } else if (!vorname.equals(other.vorname))
            return false;
        return true;
    }

}
