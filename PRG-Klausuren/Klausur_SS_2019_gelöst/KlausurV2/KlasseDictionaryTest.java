
/**
 * Beschreiben Sie hier die Klasse KlasseDictionaryTest.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.lang.Math.*;
import java.util.*;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.stream.Stream;
import java.util.stream.Collectors;
public class KlasseDictionaryTest
{
    public static void main(String[]args)
    {
        Dictionary<String,Map<String,Translation>> di =new Dictionary<String,Map<String,Translation>>();
        Translation t1=new Translation("hello");
        Translation t2=new Translation("salut");
        Map<String,Translation> map=new HashMap<String,Translation>();
        map.put("English",t1);
        map.put("Franzoesisch",t2);
        di.insert("Hallo",map);
        System.out.println(di);
        System.out.println(di.getTranslation("Hallo").values().stream().filter(a->a.get()=="salut").map(a->a.get().toUpperCase()).collect(Collectors.toList()));
        di.removeIf(a->a.startsWith("H"));
        System.out.println(di);
    }
}
