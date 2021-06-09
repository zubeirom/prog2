public class Main extends ApplyAndPrint {
    public static void main(String[] args) {
        Main m = new Main();
        m.applyAndPrint(2, 10, Lambda.powerOf2);
        m.applyAndPrint(2, 10, Lambda.powerOf2);
    }
}
