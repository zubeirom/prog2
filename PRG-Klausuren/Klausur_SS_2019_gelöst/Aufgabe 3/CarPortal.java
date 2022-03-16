import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class CarPortal {
	private Map<Integer, Car> cars;

	public CarPortal() {
		cars = new LinkedHashMap<>();
	}

	public void add(Integer id, Car car) {
		cars.put(id, car);
	}

	public void remove(Integer id) {
		cars.remove(id);
	}

	public List<Car> getCarsSorted(Comparator<Car> c) {
		List<Car> list = new ArrayList<>();
		list.addAll(cars.values());
		int n = list.size();
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>0; j--) {
				if(c.compare(list.get(j-1), list.get(j)) > 0) {
					Car temp = list.get(j-1);
					list.set(j-1, list.get(j));
					list.set(j, temp);
				}
			}
		}
		return list;
	}

	public List<Car> getCarsFilteredAndSorted(Comparator<Car> c, Predicate<Car> p) {
		return cars.values().parallelStream().filter(p).sorted(c).collect(Collectors.toList());
	}

	public Map<String, List<Car>> getCarsFilteredAndGrouped(Predicate<Car> p) {
		return cars.values().parallelStream().filter(p).collect(Collectors.groupingBy(Car::getBrand));
	}

	public long countCars(Predicate<Car> p) {
		return cars.values().parallelStream().filter(p).count();	
	}
}