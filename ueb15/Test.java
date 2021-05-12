public class Test {

    public static void main(String[] args) {
        System.out.println(new GgtIterativ().berechneGgt(28, 32));
        System.out.println(new GgtRekursiv().berechneGgt(28, 32));

        var p = new PalindromRekursiv();
        var d = p.initialize("Zubeir");
        p.register(d);
    }
}
