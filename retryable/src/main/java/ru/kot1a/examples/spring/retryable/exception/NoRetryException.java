package ru.kot1a.examples.spring.retryable.exception;

public class NoRetryException extends RuntimeException {
    public NoRetryException(String message){
        super(message);
    }
}
