package spring.beans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class SpringBeansTest {

    private AnnotationConfigApplicationContext context;

    @BeforeEach
    void initContext() {
        // given
        context = new AnnotationConfigApplicationContext("spring.beans");
    }


    @Test
    void notEmptyContext() {
        // when
        int count = context.getBeanDefinitionCount();

        // then -- check that we have more than the default 4 beans provided by Spring itself, i.e. that we have some custom beans
        assertThat(count).isGreaterThan(4);
    }


    @Test
    void someServiceExists() {
        // when
        SomeService someService = context.getBean(SomeService.class);

        // then
        assertThat(someService).isNotNull();
    }


    @Test
    void complexServiceExists() {
        // when
        SomeService someService = context.getBean(SomeService.class);

        // then
        assertThat(someService).isNotNull();
    }


    @Test
    void stringBuilderBeanExists() {
        // when -- if bean is missing an exception is thrown
        StringBuilder stringBuilder = context.getBean(StringBuilder.class);

        // then
        assertThat(stringBuilder).startsWith("START");
    }


    @Test
    void methodInjection() {
        // when
        ComplexService1 complexService1 = context.getBean(ComplexService1.class);

        // then
        assertThat(complexService1.someService).isNotNull();
        assertThat(complexService1.randomNumberService).isNotNull();
    }


    @Test
    void fieldInjection() {
        // when
        ComplexService2 complexService2 = context.getBean(ComplexService2.class);

        // then
        assertThat(complexService2.someService).isNotNull();
        assertThat(complexService2.randomNumberService).isNotNull();
    }


    @Test
    void scopedBean() throws InterruptedException {
        // when
        LocalDateTime dateTime1 = context.getBean(LocalDateTime.class);
        Thread.sleep(1000);
        LocalDateTime dateTime2 = context.getBean(LocalDateTime.class);

        // then
        assertThat(dateTime1).isBefore(dateTime2);
    }

}
