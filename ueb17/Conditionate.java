import java.util.function.IntFunction;
import java.util.function.IntPredicate;

public interface Conditionate extends MyFunction {
    
    public default IntFunction<Integer> conditionateInput(IntPredicate predicate) {
        return (int z) -> predicate.test() ? z : 0;
    }

    public default IntPredicate conditionateOutput(IntPredicate predicate) {
        return () -> predicate.test(z) ? predicate.test(z) : 0;
    }
}
