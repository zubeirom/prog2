package com.example;

public class App {

    public static void main(String[] args) {
        System.out.println(new GgtIterativ().berechneGgt(28, 32));
        System.out.println(new GgtRekursiv().berechneGgt(28, 32));
        PalindromRekursiv rekursiv = new PalindromRekursiv();
        PalindromIterativ iterative = new PalindromIterativ();
        rekursiv.initialize("Otto");
        rekursiv.initialize("IO");
        rekursiv.initialize("Paap");
        rekursiv.initialize("TestFile.txt");

        iterative.initialize("Otto");
        iterative.initialize("IO");
        iterative.initialize("Paap");
        iterative.initialize("TestFile.txt");
    }
}
