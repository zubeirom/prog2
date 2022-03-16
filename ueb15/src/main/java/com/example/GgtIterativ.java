package com.example;

public class GgtIterativ implements GgT {

    @Override
    public long berechneGgt(long a, long b) {
        int ggt = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if(a % i == 0 && b % i == 0) {
                ggt = i;
            }
        }
        return ggt;
    }
    
}
