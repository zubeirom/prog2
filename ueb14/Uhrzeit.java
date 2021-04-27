public class Uhrzeit {
    
    private int stunde;
    private int minute;

    public Uhrzeit(int stunde, int minute) {
        if(stunde < 0 || stunde > 23) {
            throw new IllegalArgumentException("Stunde muss zwischen 0 und 23 sein");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Stunde muss zwischen 0 und 23 sein");
        }
        this.stunde = stunde;
        this.minute = minute;
    }

    public int getStunde() {
        return stunde;
    }

    public int getMinute() {
        return minute;
    }

    public int getConcatinated() {
        String s1 = Integer.toString(stunde);
        String s2 = Integer.toString(minute);

        return Integer.parseInt(s1+s2);
    }

    @Override
    public String toString() {
        String s = new String();
        if(stunde < 10) {
            s = "0";
        }
        s += stunde + ":";

        if(minute < 10) {
            s += "0";
        }
        s += minute + " Uhr";
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
        Uhrzeit other = (Uhrzeit) obj;
        if (minute != other.minute)
            return false;
        if (stunde != other.stunde)
            return false;
        return true;
    }

}