public class Anonym extends ApplyAndPrint {

    public void powerOf2(int z) {
        new MyFunction() {
            @Override
            public int apply(int i) {
                return (int) Math.pow(i, 2);
            }
        }.apply(z);
    }

    public void factorial(int z) {
        new MyFunction() {
            @Override
            public int apply(int i) {
                int fact = 0;
                for (int a = 1; a <= i; a++) {
                    fact = fact * a;
                }
                return fact;
            }
        }.apply(z);
    }

    public void powerOfX(int z) {
        new MyFunction() {
            @Override
            public int apply(int i) {
                return (int) Math.pow(i, i + 1);
            }
        }.apply(z);
    }

    public void fib(int z) {
        new MyFunction() {
                @Override
                public int apply(int i) {
                    if(i <= 1) {
                        return i;
                    }

                    return apply(i -1) + apply(i - 2);
                }
            
        }.apply(z);
    }

}
