
/**
 * Beschreiben Sie hier die Klasse FindRA.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class SubstringFinder {
    public boolean findRecursive(String haystack, String needle) 
    {
        if(needle.length()>haystack.length())
        {
            return false; 
        }

        else if(haystack.substring(0,needle.length()).equals(needle))
        {
            return true;
        }
        else 
        {
            return findRecursive(haystack.substring(1,haystack.length()),needle);
        }
    }

    public boolean findIterative(String haystack, String needle)
    {
        int length=haystack.length();
        for(int i =0;i<length;i++)
        {
            if(needle.length()>haystack.length())
            {
                return false; 
            }
            if(haystack.substring(0,needle.length()).equals(needle))
            {
                return true;
            }
            haystack=haystack.substring(1,haystack.length());
        }
        return false;
    } 

    public static void main(String[] args) {
        String s1 = "Weaewrerwali";
        String s2 = "alis";
        System.out.println("Haystack: " + s1);
        System.out.println("Needle: " + s2);
        System.out.println("findRecursive: " + new SubstringFinder().findRecursive(s1, s2));
        System.out.println("findIterative: " + new SubstringFinder().findIterative(s1, s2));
    }
}

