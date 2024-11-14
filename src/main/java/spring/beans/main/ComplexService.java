package spring.beans.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.beans.addons.RandomNumberService;

public final class ComplexService {

    // use field injection here
    @Autowired
    private RandomNumberService randomNumberService;

    // use method injection for this field
    private SomeService someService;

    // use constructor injection for this field
    private final StringBuilder stringBuilder;

    public ComplexService(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Autowired
    public void setSomeService(SomeService someService) {
        this.someService = someService;
    }

    public RandomNumberService getRandomNumberService() {
        return randomNumberService;
    }

    public SomeService getSomeService() {
        return someService;
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }
}
