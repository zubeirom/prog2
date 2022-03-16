
/**
 * Beschreiben Sie hier die Klasse v.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class CarPortalTest {
    public static void main(String[] args) 
    {
        CarPortal portal = new CarPortal();
        String[] colors = {"black", "red", "green", "blue", "yellow"};
        String[] brands = {"Farrari", "Lamborghini", "Bugatti", "Maserati","Pagani"};
        java.util.Random ran = new java.util.Random();
        for(int i=0; i<100; i++)
        {
            portal.add(i, new Car(colors[ran.nextInt(5)], brands[ran.nextInt(5)], 100*ran.nextInt(300)));
        }
        System.out.println(portal.countCars(a->a.getColor()=="yellow"));
        System.out.println(portal.getCarsFilteredAndSorted((o1,o2)->(o1.horsePower())>(o2.horsePower()) ? 1:-1 ,a->a.getBrand()=="Farrari"));
    }
    
}

