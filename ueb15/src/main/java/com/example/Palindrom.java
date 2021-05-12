package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Palindrom implements IPalindrom {

    static String DATA_FILE = "PerformanceData.txt";
    private String RESULT = "result";
    private final String WORD_LENGTH = "wordLength";
    private final String DURATION = "duration";
    private final String TYPE = "type";
    private final String WORD = "word";
    private final String algorithmType;

    Palindrom(String algorithmType) {
        this.algorithmType = algorithmType;
    }

    public abstract boolean istPalindrom(String wort);

    /**
     * Initialize Fun
     */
    public void initialize(String value) {
        try {
            File f = new File("src/main/java/com/example/" + value);
            final String s = value;
            if (f.isFile()) {
                register(withFile(f));
            } else {
                
                register(new ArrayList<Map<String, String>>() {
                    {
                        add(withWord(s));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void register(List<Map<String, String>> data) {
        try {
            File dataFile = new File(DATA_FILE);
            boolean newFile = false;
            if (!dataFile.isFile()) {
                newFile = true;
                dataFile.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE, true));
            if (newFile || dataFile.length() == 0) {
                writer.write("Word length, Duration, IsPalindrom, AlgorithmType, Word\n");
            }
            for (Map<String, String> map : data) {
                String s = map.get(WORD_LENGTH) + ", " + map.get(DURATION) + ", " + map.get(RESULT) + ", "
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

    private long getDuration(long startTime, long endTime) {
        return (endTime - startTime);
    }

    private List<Map<String, String>> withFile(File f) throws Exception {
        BufferedReader reader;
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();

        reader = new BufferedReader(new FileReader(f));
        String line = reader.readLine();
        while (line != null) {
            data.add(withWord(line));
            line = reader.readLine();
        }
        reader.close();
        return data;
    }

    private Map<String, String> withWord(String wort) {
        final long startTime = System.nanoTime();
        final String clean = wort.trim().toLowerCase();
        final boolean result = istPalindrom(clean);
        final long endTime = System.nanoTime();
        final String s = wort;

        return new HashMap<String, String>() {
            {
                put(RESULT, String.valueOf(result));
                put(WORD_LENGTH, String.valueOf(s.length()));
                put(DURATION, String.valueOf(getDuration(startTime, endTime)));
                put(TYPE, algorithmType);
                put(WORD, s);
            }
        };
    }

    public void buildGraph() {
        File file = new File(DATA_FILE);
        if(!file.isFile() || file.length() == 0){
            throw new NullPointerException("You have no data, please run initialize");
        }

        
    }
}
