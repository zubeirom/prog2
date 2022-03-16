import java.util.*;

public class DictionaryTest {
	public static void main(String[] args) {		
		// h
		Dictionary<String, Set<Translation>> dictionary = new Dictionary<>();
		
		// i
		String word = "Hallo";
		Set<Translation> translations = new TreeSet<>();
		translations.add(new Translation("French", "Salut"));
		translations.add(new Translation("English", "Hello"));
		dictionary.insert(word, translations);

		// j
		dictionary.getTranslation(word).stream()
										.filter(c -> c.language().equals("French"))
										.forEach(System.out::println);

		// k
		dictionary.removeIf(w -> w.startsWith("H"));
	}
}