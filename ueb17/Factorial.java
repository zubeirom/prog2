public class Factorial extends ApplyAndPrint implements MyFunction {

    public int apply(int z) {
        int fact = 0;
        for (int a = 1; a <= z; a++) {
            fact = fact * a;
        }
        return fact;
    }

    static class Inner implements MyFunction {
        public int apply(int z) {
            int fact = 0;
            for (int a = 1; a <= z; a++) {
                fact = fact * a;
            }
            return fact;
        }
    }

}
