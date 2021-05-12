package com.example;

public class PalindromIterativ extends Palindrom {


    PalindromIterativ() {
        super("iterative");
    }

    @Override
    public boolean istPalindrom(String wort) {
        int a = 0;
        int b = wort.length() - 1;
        while(a < b) {
            if(wort.charAt(a) != wort.charAt(b)) {
                return false;
            }
            a++;
            b--;
        }
        return true;
    }
    
}
