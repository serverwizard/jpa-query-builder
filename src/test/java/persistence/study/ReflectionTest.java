package persistence.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    @DisplayName("Car 객체 정보 가져오기")
    void showClass() {
        Class<Car> carClass = Car.class;

        Arrays.stream(carClass.getDeclaredFields())
                .forEach(field -> logger.debug("Field: {} ({})", field.getName(), field.getType()));

        Arrays.stream(carClass.getDeclaredConstructors())
                .forEach(constructor -> logger.debug("Constructor: {} ({})",
                        constructor.getName(),
                        formatParameters(constructor.getParameterTypes())));

        Arrays.stream(carClass.getDeclaredMethods())
                .forEach(method -> logger.debug("Method: {}({}) -> {}",
                        method.getName(),
                        formatParameters(method.getParameterTypes()),
                        method.getReturnType()));
    }

    private String formatParameters(Class<?>[] parameterTypes) {
        return Arrays.stream(parameterTypes)
                .map(Class::getTypeName)
                .collect(Collectors.joining(", "));
    }
}