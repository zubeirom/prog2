public class Test {

    public static void main(String[] args) {
        System.out.println(new GgtIterativ().berechneGgt(28, 32));
        System.out.println(new GgtRekursiv().berechneGgt(28, 32));
        new PalindromRekursiv().initialize("Otto");
        new PalindromRekursiv().initialize("IO");
        new PalindromRekursiv().initialize("Paap");
        new PalindromRekursiv().initialize("TestFile.txt");

        new PalindromIterativ().initialize("Otto");
        new PalindromIterativ().initialize("IO");
        new PalindromIterativ().initialize("Paap");
        new PalindromIterativ().initialize("TestFile.txt");
    }
}
