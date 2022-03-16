public class SubstringFinder {
  public boolean findRecursive(String haystack, String needle) {
  	int n = haystack.length();
  	int m = needle.length();
  	if(n < m)
  		return false;
  	if(m == 0)
  		return true;
  	
  	if(haystack.substring(0, m).equals(needle)) {
  		return true;
  	} else {
  		return findRecursive(haystack.substring(1, n), needle);
  	}
  }

  public boolean findIterative(String haystack, String needle) {
  	if(needle.length() == 0)
  		return true;
    int i=0, j=0;
    int count = 0;
    while(i < haystack.length() && j < needle.length()) {
      if(haystack.charAt(i) == needle.charAt(j)) {
		count++;
		i++;
		j++;
      } else {
		count = 0;
		i -= j-1;
		j = 0;
      }
    }
    return count == needle.length();
  }

  public static void main(String[] args) {
    String s1 = "abcde";
    String s2 = "cd";
    System.out.println("Haystack: " + s1);
    System.out.println("Needle: " + s2);
    System.out.println("findRecursive: " + new SubstringFinder().findRecursive(s1, s2));
    System.out.println("findIterative: " + new SubstringFinder().findIterative(s1, s2));
  }
}
