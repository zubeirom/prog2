import java.util.Random;

/**
 * Helper class for sharing functions
 */
public class Helper {
    /**
     * Generates random float utilized by random class
     * 
     * @return random float
     */
    static float getRandomFloat() {
        return new Random().nextFloat() * 100;
    }

    /**
     *  Generate random float array with length between 10 and 20
     * @return float array
     */
    static float[] generateRandomFloatArray() {
        int length = new Random().nextInt(10 + 1) + 10;
        float[] f = new float[length];
        for (int i = 0; i < f.length; i++) {
            f[i] = getRandomFloat();
        }
        return f;
    }

    /**
     * Convert string of float values to float array
     * @param values String of values
     * @return float array
     */
    static float[] convertToFloat(String values) {
        try {
            String[] splitted = values.split(" ");
            float[] f = new float[splitted.length];
            for (int i = 0; i < f.length; i++) {
                f[i] = Float.parseFloat(splitted[i]);
            }
            return f;
        } catch(Exception e) {
            throw new IllegalArgumentException("Bitte achten sie auf die richtige eingabe der werte");
        }
    } 

}
