package spring.beans.main;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import spring.beans.addons.AddOnsConfiguration;

import java.time.LocalDateTime;

@Configuration
@Import(AddOnsConfiguration.class)
public class BeansConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public LocalDateTime localDateTime() {
        return LocalDateTime.now();
    }

    @Bean
    public StringBuilder stringBuilder() {
        return new StringBuilder("START");
    }

    @Bean
    public SomeComponent someComponent1() {
        return new SomeComponent(1);
    }

    @Bean
    public SomeComponent someComponent2() {
        return new SomeComponent(2);
    }

}
