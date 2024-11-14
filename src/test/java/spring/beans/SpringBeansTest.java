package spring.beans;

import org.junit.jupiter.api.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.beans.addons.RandomNumberGenerator;
import spring.beans.addons.RandomNumberService;
import spring.beans.main.ComplexService;
import spring.beans.main.SomeComponent;
import spring.beans.main.SomeService;

import java.time.LocalDateTime;
import java.util.function.Supplier;

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
        // when/then -- if bean is missing, an exception is thrown
        Assertions.assertDoesNotThrow(
                () -> context.getBean(SomeService.class)
        );
    }


    @Test
    @Order(3)
    void beanOfTypeStringBuilderExists() {
        // when/then -- if bean is missing, an exception is thrown
        Assertions.assertDoesNotThrow(
                () -> {
                    StringBuilder stringBuilder = context.getBean(StringBuilder.class);
                    assertThat(stringBuilder).startsWith("START");
                }
        );
    }


    @Test
    @Order(4)
    void beanOfTypeRandomNumberServiceExists() {
        // when/then -- if bean is missing, an exception is thrown
        Assertions.assertDoesNotThrow(
                () -> {
                    context.getBean(RandomNumberGenerator.class);
                    context.getBean(RandomNumberService.class);
                }
        );
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


    /**
     * Tip: Requires creating a new class in the main package.
     */
    @Test
    @Order(6)
    void qualifiedAutowiring() {
        // when
        Supplier<SomeComponent> bean = context.getBean("supplyingService", Supplier.class);
        // then
        assertThat(bean.get().getIndex()).isEqualTo(2);
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
