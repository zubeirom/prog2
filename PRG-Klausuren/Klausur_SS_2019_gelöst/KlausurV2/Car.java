
/**
 * Beschreiben Sie hier die Klasse c.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Car {
    private String color, brand;
    private int horsePower;
    public Car(String color, String brand, int horsePower)
    {
        this.color = color;
        this.brand = brand;
        this.horsePower = horsePower;
    }

    public String getColor()
    { 
        return this.color; 
    }

    public String getBrand()
    {
        return this.brand;
    }

    public int horsePower()
    {
        return this.horsePower;
    }
    
    public String toString()
    {
      return "["+color+", "+brand+", "+horsePower+"]";
    }
}