package spring.beans.addons;

import java.util.random.RandomGenerator;

// No annotations may be added here
public class RandomNumberGenerator {

    private final RandomGenerator random = RandomGenerator.getDefault();

    int nextInt() {
        return random.nextInt();
    }

}
