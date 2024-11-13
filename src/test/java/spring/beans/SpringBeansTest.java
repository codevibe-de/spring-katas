package spring.beans;

import org.junit.jupiter.api.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.beans.addons.RandomNumberGenerator;
import spring.beans.addons.RandomNumberService;
import spring.beans.main.ComplexService;
import spring.beans.main.SomeService;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpringBeansTest {

    private AnnotationConfigApplicationContext context;

    @BeforeEach
    void initContext() {
        // given
        context = new AnnotationConfigApplicationContext("spring.beans.main");
    }


    @Test
    @Order(2)
    void beanOfTypeSomeServiceExists() {
        // when -- if bean is missing an exception is thrown
        context.getBean(SomeService.class);
    }


    @Test
    @Order(3)
    void beanOfTypeStringBuilderExists() {
        // when -- if bean is missing an exception is thrown
        StringBuilder stringBuilder = context.getBean(StringBuilder.class);
        // then
        assertThat(stringBuilder).startsWith("START");
    }


    @Test
    @Order(4)
    void beanOfTypeRandomNumberServiceExists() {
        // when -- if bean is missing an exception is thrown
        context.getBean(RandomNumberGenerator.class);
        context.getBean(RandomNumberService.class);
    }


    @Test
    @Order(5)
    void injections() {
        // when
        ComplexService complexService = context.getBean(ComplexService.class);

        // then
        assertThat(complexService.getSomeService()).isNotNull();
        assertThat(complexService.getRandomNumberService()).isNotNull();
        assertThat(complexService.getStringBuilder()).isNotNull();
    }


    @Test
    @Order(7)
    void scopedBean() throws InterruptedException {
        // when
        LocalDateTime dateTime1 = context.getBean(LocalDateTime.class);
        Thread.sleep(1000);
        LocalDateTime dateTime2 = context.getBean(LocalDateTime.class);

        // then
        assertThat(dateTime1).isBefore(dateTime2);
    }

}
