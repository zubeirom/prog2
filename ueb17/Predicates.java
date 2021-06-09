import java.util.function.IntPredicate;

public class Predicates {

    public boolean odd(int z) {
        return new Object() {
            public boolean odd(int z) {
                return z % 2 != 0;
            }
        }.odd(z);
    }

    public IntPredicate even = z -> z % 2 == 0; 
}
