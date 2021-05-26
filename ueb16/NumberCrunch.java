/**
 * abstract class that with minimal methods
 */
public abstract class NumberCrunch implements CrunchOperation {

     /**
     * Will call methods based on operations 
     * @param operations list of operations
     */
    public abstract void crunch(String[] operations);
    /**
     * Pass float array
     * @return float array attribute
     */
    public abstract float[] getNumbers();
}
