package spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ComplexService2 {

    // You are allowed to ONLY EDIT THE FIELD DECLARATIONS below!

    @Autowired
    RandomNumberService randomNumberService;

    @Autowired
    SomeService someService;

    // No editing below this line please

    public ComplexService2() {
    }

}
