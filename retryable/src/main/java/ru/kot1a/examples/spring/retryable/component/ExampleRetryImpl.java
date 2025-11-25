package ru.kot1a.examples.spring.retryable.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kot1a.examples.spring.retryable.exception.NoRetryException;

@Slf4j
@Component
public class ExampleRetryImpl implements ExampleRetry {

    @Override
    public void retryMethod(){
        log.info("Запуск метода");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis % 2 == 0) {
            throw new RuntimeException();
        }
        if (currentTimeMillis % 3 == 0) {
            throw new NoRetryException("Ошибка при которой попытки выполнить метод прекращаются");
        }
        log.info("Успех");
    }
}
