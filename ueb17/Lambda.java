public class Lambda extends ApplyAndPrint {

    static MyFunction powerOf2  = (int z) -> (int) Math.pow(z, 2);

    static MyFunction factorial = (int z) -> {
        int fact = 0;
        for (int a = 1; a <= z; a++) {
            fact = fact * a;
        }
        return fact;
    };

    static MyFunction powerOfX = (int z) -> (int) Math.pow(z, z + 1);

    static MyFunction fib = (int z) -> {
        int fact = 1;
        for (int a = 2; a <= z; a++) {
            fact = fact * z;
        }
        return fact;
    };
}