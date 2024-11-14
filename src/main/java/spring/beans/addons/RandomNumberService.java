package spring.beans.addons;

// No annotations may be added here
public class RandomNumberService {

    private final RandomNumberGenerator generator;

    public RandomNumberService(RandomNumberGenerator generator) {
        this.generator = generator;
    }


    public String getRandomId(String prefix) {
        return prefix + generator.nextInt();
    }

}
