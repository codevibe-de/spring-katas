package spring.beans.addons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddOnsConfiguration {

    @Bean
    public RandomNumberService randomNumberService(RandomNumberGenerator generator) {
        return new RandomNumberService(generator);
    }

    @Bean
    public RandomNumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }

}
