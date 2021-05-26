/**
 * Anonyme klasse 
 */
public class NumberCruncherAnonym extends NumberCrunch {
    private float[] values;

    public NumberCruncherAnonym(float[] values) {
        if(values.length == 0) {
            throw new IllegalArgumentException("Array muss befüllt sein");
        }
        this.values = values;
    };

    /**
     * Will call methods based on operations 
     * @param operations list of operations
     */
    @Override
    public void crunch(String[] operations) {
        for (String op : operations) {
            if(op == Operations.SUM) {
                sum();
            }
            if(op ==  Operations.SWIRL) {
                swirl();
            }
            if(op == Operations.DIVIDE) {
                divide();
            }
            if(op == Operations.SUBSTRACT) {
                substract();
            }
            if(op == Operations.AVERAGE) {
                average();
            }
        }
    }

    /**
     * Calculate the sum of values and store it in the current index
     * @param values float values
     */
    public void sum() {
        new NumberCruncherTopLevel(values) {
            public void sum() {
                values = Operations.sum(values);
            }
        };
    }

    /**
     * Will change values of each other
     * @param values float array
     */
    public void swirl() {
        new NumberCruncherTopLevel(values) {
            public void swirl() {
                values = Operations.swirl(values);
            }
        };
    }

    /**
     * Will sort and divide the values;
     * @param values float array
     */
    public void divide() {
        new NumberCruncherTopLevel(values) {
            public void divide() {
                values = Operations.divide(values);
            }
        };
    }

    /**
     * Will substract the current and next value and store in current
     * @param values float array
     */
    public void substract() {
        new NumberCruncherTopLevel(values) {
            public void substract() {
                values = Operations.substract(values);
            }
        };
    }

    /**
     * Calculate average of float array
     * @param values float array
     */
    public void average() {
        new NumberCruncherTopLevel(values) {
            public void average() {
                values = Operations.average(values);
            }
        };
    }

    /**
     * Pass the float array of class
     * @return float array attribute
     */
    public float[] getNumbers() {
        return values;
    }
     
}