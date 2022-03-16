


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
/**
 * Beschreiben Sie hier die Klasse Dictionary.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public class Dictionary<K,V>
{
    Map<K,V> map;
    public Dictionary()
    {
        map=new HashMap<K,V>();        
    }

    public void insert(K eintrag, V value)
    {
        map.put(eintrag,value);
    }

    public boolean insertAll(List<K> kList, List<V> vList)
    {
        boolean ergebnis = true;
        for(int i=0; i<kList.size();i++)
        {
            map.put(kList.get(i),vList.get(i));
            if(map.get(kList.get(i)) != vList.get(i))
            {
                ergebnis= false;
            }
        }
        return ergebnis ;
    }

    public V getTranslation(K eintrag)
    {
        return map.get(eintrag);
    }

    public void printAll()
    {
        Iterator<Map.Entry<K,V>> itr = map.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<K,V> ent =itr.next();
            System.out.println(ent.getKey()+" : "+ent.getValue());
        }
    }

    public void removeIf(Predicate<K> p)
    {
       Iterator<K> itr= map.keySet().iterator();
       while(itr.hasNext())
       {
          K key =itr.next();
          if(p.test(key))
          {
             map.remove(key);
          }
       }
    }
    
    public String toString()
    {
        String s="";
       return s+ map;
    }
    
}
