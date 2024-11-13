package spring.beans.addons;

import java.util.random.RandomGenerator;

// No Annotations may be added here
public class RandomNumberGenerator {

    private final RandomGenerator random = RandomGenerator.getDefault();

    int nextInt() {
        return random.nextInt();
    }

}
