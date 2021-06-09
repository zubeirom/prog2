public class Anonym {

    public MyFunction powerOf2() {
        return new MyFunction() {
            @Override
            public int apply(int i) {
                return (int) Math.pow(i, 2);
            }
        };
    }

    public MyFunction factorial() {
        return new MyFunction() {
            @Override
            public int apply(int i) {
                int fact = 0;
                for (int a = 1; a <= i; a++) {
                    fact = fact * a;
                }
                return fact;
            }
        };
    }

    public MyFunction powerOfX() {
        return new MyFunction() {
            @Override
            public int apply(int i) {
                return (int) Math.pow(i, i + 1);
            }
        };
    }

    public MyFunction fib() {
        return new MyFunction() {
                @Override
                public int apply(int i) {
                    if(i <= 1) {
                        return i;
                    }

                    return apply(i -1) + apply(i - 2);
                }
            
        };
    }

}
