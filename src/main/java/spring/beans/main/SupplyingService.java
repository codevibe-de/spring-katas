package spring.beans.main;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class SupplyingService implements Supplier<SomeComponent> {

    private final SomeComponent someComponent;

    public SupplyingService(@Qualifier("someComponent2") SomeComponent someComponent) {
        this.someComponent = someComponent;
    }

    @Override
    public SomeComponent get() {
        return someComponent;
    }

}
