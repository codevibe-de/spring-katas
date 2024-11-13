package spring.beans;

public class RandomNumberService {

    public RandomNumberService(RandomNumberGenerator generator) {
        this.generator = generator;
    }

    private final RandomNumberGenerator generator;

}
