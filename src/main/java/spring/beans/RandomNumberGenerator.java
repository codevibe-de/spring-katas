package spring.beans;

import java.util.Random;

public class RandomNumberGenerator {

    private final Random random = new Random();

    int nextInt() {
        return random.nextInt();
    }

}
