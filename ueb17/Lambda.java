public class Lambda {

    static MyFunction powerOf2 = (int z) -> (int) Math.pow(z, 2);

    static MyFunction factorial = (int z) -> {
        int fact = 0;
        for (int a = 1; a <= z; a++) {
            fact = fact * a;
        }
        return fact;
    };

    static MyFunction powerOfX = (int z) -> (int) Math.pow(z, z + 1);

    public static MyFunction fib;

    static {
        fib = (int z) -> {
            if (z <= 1) {
                return z;
            }

            return fib.apply(z - 1) + fib.apply(z - 2);
        };
    };

}