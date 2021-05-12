import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Palindrom implements IPalindrom {

    
    static String DATA_FILE = "PerformanceData.txt";
    private String RESULT = "result";
    private String WORD_LENGTH = "wordLength";
    private String DURATION = "duration";
    private String TYPE = "type";
    private String WORD = "word";
    private String algorithmType;

    Palindrom(String algorithmType) {
        this.algorithmType = algorithmType;
    }
    
    public abstract boolean istPalindrom(String wort);

    public List<Map<String, String>> initialize(String value) {
        // File f = new File(value);
        // value = value.trim().toLowerCase();
        // if (f.isFile()) {
        //     return withFile(f, algorithmType);
        // }

        return withWord(value);
    }

    public void register(List<Map<String, String>> data) {
        try {
            File dataFile = new File(DATA_FILE);
            if (!dataFile.isFile()) {
                dataFile.createNewFile();
            }
            BufferedWriter writer  = new BufferedWriter(new FileWriter(DATA_FILE, true));
            for (Map<String, String> map : data) {
                String s = map.get(RESULT) + ", " + map.get(WORD_LENGTH) + ", " + map.get(DURATION) + ", "
                        + map.get(TYPE) + ", " + map.get(WORD) + "\n";
                writer.write(s);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getDuration(long startTime, long endTime) {
        return (endTime - startTime);
    }

    // public List<Map<String,String>> withFile(File f, String algorithmType) {
        
    // }

    public List<Map<String, String>> withWord(String wort) {
        long startTime = System.nanoTime();
        boolean result = istPalindrom(wort);
        long endTime = System.nanoTime();
        Map<String, String> data = new HashMap<String, String>() {
            {
                put(RESULT, String.valueOf(result));
                put(WORD_LENGTH, String.valueOf(wort.length()));
                put(DURATION, String.valueOf(getDuration(startTime, endTime)));
                put(TYPE, algorithmType);
                put(WORD, wort);
            }
        };
        return new ArrayList<Map<String, String>>() {
            {
                add(data);
            }
        };
    }
}
