import java.util.Arrays;
import java.util.Random;
/**
 * Class that holds operations
 */
public class Operations {

    static String SUM = "sum";
    static String SWIRL = "swirl";
    static String DIVIDE = "divide";
    static String SUBSTRACT = "substract";
    static String AVERAGE = "average";

    /**
     * Calculate the sum of values and store it in the current index
     * @param values float values
     * @return new calculated float array
     */
    static float[] sum(float[] values) {
        for (int i = 1; i < values.length; i++) {
            values[i] = values[i-1] + values[i];
        }

        return values;
    }

    /**
     * Will change values of each other
     * @param values float array
     * @return new shuffled float array
     */
    static float[] swirl(float[] values) {
        for (int i = 0; i < values.length; i++) {
            int randInt = new Random().nextInt(values.length);
            float temp = values[randInt];
            values[randInt] = values[i];
            values[i] = temp;
        }
        return values;
    }

    /**
     * Will sort and divide the values;
     * @param values float array
     * @return new float array
     */
    static float[] divide(float[] values) {
        Arrays.sort(values);
        for (int i = 0; i < values.length; i++) {
            values[values.length - 1 - i] = values[values.length - i - 1] / values[i];
        }
        return values;
    }

    /**
     * Will substract the current and next value and store in current
     * @param values float array
     * @return new substracted float array
     */
    static float[] substract(float[] values) {
        for (int i = 1; i < values.length; i++) {
            values[i] = values[i-1] - values[i];
        }

        return values;
    }

    /**
     * Calculate average of float array
     * @param values float array
     * @return float array with average in max value index
     */
    static float[] average(float[] values) {
        float sum = 0;

        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }

        values[findMaxIndex(values)] = sum / values.length;
        return values;
    }

    /**
     * Find index of max value
     * @param values float array
     * @return index of max value
     */
    private static int findMaxIndex(float[] values) {
        float max = values[0];
        int index = 0;
        for (int i = 0; i < values.length; i++) {
            if(values[i] > max) {
                max = values[i];
                index = i;
            }
        }
        return index;
    }

}
