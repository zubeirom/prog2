package com.example;

public class PalindromRekursiv extends Palindrom {

    PalindromRekursiv() {
        super("recursive");
    }


    @Override
    public boolean istPalindrom(String wort) {
        wort = wort.trim().toLowerCase();
        
        return recursiveCheck(wort, 0, wort.length() -1);
    }

    private boolean recursiveCheck(String wort, int anfang, int ende) {
        if(anfang == ende) {
            return true;
        }

        if(wort.charAt(anfang) != wort.charAt(ende)) {
            return false;
        }

        if( anfang < ende + 1) {
            return recursiveCheck(wort, anfang + 1, ende - 1);
        }
        
        return true;
    }

}
