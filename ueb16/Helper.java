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

}
