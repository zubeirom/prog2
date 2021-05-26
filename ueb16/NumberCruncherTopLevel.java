import java.util.Arrays;

/**
 *  Top level class implements Crunchoperation
 */
public class NumberCruncherTopLevel extends NumberCrunch {
    private float[] values;

    public NumberCruncherTopLevel(float[] values) {
        if(values.length == 0) {
            throw new IllegalArgumentException("Array muss befüllt sein");
        }
        this.values = values;
    }
    
    /**
     * Will call methods based on operations 
     * @param operations list of operations
     */
    @Override
    public void crunch(String[] operations) {
        for (String op : operations) {
            System.out.println(op);
            if(op.equals(Operations.SUM)) {
                sum();
            }
            if(op.equals(Operations.SWIRL)) {
                swirl();
            }
            if(op.equals(Operations.DIVIDE)) {
                divide();
            }
            if(op.equals(Operations.SUBSTRACT)) {
                substract();
            }
            if(op.equals(Operations.AVERAGE)) {
                average();
            }
        }
    }

    /**
     * Set values attribute
     * @param values float array
     */
    public void setValues(float[] values) {
        System.out.println(Arrays.toString(values));
        this.values = values;
    }

    /**
     * Calculate the sum of values and store it in the current index
     * @param values float values
     */
    public void sum() {
        setValues(Operations.sum(values));
    }

    /**
     * Will change values of each other
     * @param values float array
     */
    public void swirl() {
        setValues(Operations.swirl(values));
    }

    /**
     * Will sort and divide the values;
     * @param values float array
     */
    public void divide() {
        setValues(Operations.divide(values));
    }

    /**
     * Will substract the current and next value and store in current
     * @param values float array
     */
    public void substract() {
        setValues(Operations.substract(values));
    }

    /**
     * Calculate average of float array
     * @param values float array
     */
    public void average() {
        setValues(Operations.average(values));
    }

    /**
     * Pass the float array of class
     * @return float array attribute
     */
    public float[] getNumbers() {
        return values;
    }
    
}
