package ru.kot1a.examples.spring.retryable.component;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import ru.kot1a.examples.spring.retryable.exception.NoRetryException;

public interface ExampleRetry {

    /**
     * С помощью аннотации Retryable можно несколько раз перезапускать метод в случае возникновения ошибки.<br>
     * maxAttemptsExpression - позволяет задать динамически количество попыток с помощью SpEL выражения.<br>
     * backoff - определяет время между попытками.<br>
     * noRetryFor - определяет список исключений, при которых не выполняется повторный запуск метода.
     */
    @Retryable(
            noRetryFor = NoRetryException.class,
            maxAttemptsExpression = "${retry.attempts.max:3}",
            backoff = @Backoff(delayExpression = "${retry.backoff:3000}")
    )
    void retryMethod();
}
