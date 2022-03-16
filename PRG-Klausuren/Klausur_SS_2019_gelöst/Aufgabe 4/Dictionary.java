import java.util.*;
import java.util.function.*;

public class Dictionary<K, V> {
	// Deklarieren Sie Ihre Datenstruktur hier:
	private Map<K, V> map;

	public Dictionary() {
		map = new TreeMap<>();
	}

	// public Dictionary(Comparator<K> c) {
	// 	map = new TreeMap<>(c);
	// }

	public boolean insert(K word, V translation)	{
		if(!map.containsKey(word)) {
			map.put(word, translation);
			return true;
		}
		return false;
	}

	public boolean insertAll(List<K> words, List<V> translations) {
		boolean allAdded = false;
		for(int i=0; i<words.size(); i++)
			allAdded = allAdded || insert(words.get(i), translations.get(i));
		return allAdded;
	}

	public V getTranslation(K word) {
		return map.get(word);
	}

	public void printAll() {
		map.forEach((k, v) -> System.out.println(k + ", " + v));
	}

	public void removeIf(Predicate<K> p) {
		// this external iterator should be safe to use for modification.
		// i.e. it is protected against ConcurrentModificationException
		Iterator<K> it = map.keySet().iterator();
		while(it.hasNext()) { 
			K key = it.next();
			if(p.test(key)) {
				map.remove(key);
			}
		} 
	}
}