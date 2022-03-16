
/**
 * Beschreiben Sie hier die Klasse c.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
public class CarPortal
{
    private Map<Integer, Car> cars;
    public CarPortal()
    {
        cars=new HashMap<Integer,Car>();
    }

    public void add(Integer id, Car car)
    {
        cars.put(id,car);
    }

    public void remove(Integer id)
    {
        cars.remove(id);  
    }

    public List<Car> getCarsSorted(Comparator<Car> c)
    {
        Car temp ;
        List<Car> list= new ArrayList<Car>();
        Car[] tab= cars.values().toArray(Car[]::new);
        for(int i=1;i<tab.length;i++)
        {
            for(int j=0;i<tab.length-i;j++)
            {
                if(c.compare(tab[i],tab[j])==1)
                {
                    temp=tab[j];
                    tab[j]=tab[j+1];
                    tab[j+1]=temp;
                }
            }
        }
        for(int i=0;i<tab.length;i++)
        {
            list.add(tab[i]);
        }
        return list ;
    }

    public List<Car> getCarsFilteredAndSorted(Comparator<Car> c, Predicate<Car> p)
    {
        return cars.values().stream().filter(p).sorted(c).collect(Collectors.toList());
    }

    public Map<String, List<Car>> getCarsFilteredAndGrouped (Predicate<Car> p)
    {
        return cars.values().stream().filter(p).collect(Collectors.groupingBy(a->a.getBrand()));
    }

    public long countCars(Predicate<Car> p)
    {
        return cars.values().stream().filter(p).collect(Collectors.toList()).size();
    }

}
