// A full implementaion should be provided in the exam.
// This is just a sample to make things work. 

public class Translation implements Comparable<Translation> {
	private String language;
	private String value;

	public Translation(String lang, String val) {
		language = lang;
		value = val;
	}

	public Translation(String val) {
		this("UnknownLanguage", val);
	}

	public int compareTo(Translation t) {
		return language.compareToIgnoreCase(t.language);
	}

	public String language() {
		return language;
	}

	public String toString() {
		return language + ", " + value;
	}
}