import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class CarPortalTest {
	public static void main(String[] args) {
		CarPortal portal = new CarPortal();
		String[] colors = {"black", "red", "green", "blue", "yellow"};
		String[] brands = {"Farrari", "Lamborghini", "Bugatti", "Maserati", "Pagani"};
		java.util.Random ran = new java.util.Random();

		for(int i=0; i<100; i++) {
			portal.add(i, new Car(colors[ran.nextInt(5)], 
								  brands[ran.nextInt(5)], 
								  100*ran.nextInt(300)));
		}

		long countLamborghinis = portal.countCars(c -> c.getBrand().equals("Lamborghini"));
		
		List<Car> sortedFerraris = 
		portal.getCarsFilteredAndSorted(
					(c1, c2) -> Integer.compare(c1.horsePower(), c2.horsePower()), 
					c -> c.getBrand().equals("Farrari"));

		System.out.println("\nLamborghinis-Anzahl: " + countLamborghinis);
		System.out.println("\nErsten 10 Ferraris Sortiert nach horsePower:");
		sortedFerraris.stream().limit(10).forEach(System.out::println);
	}
}