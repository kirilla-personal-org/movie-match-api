package ru.afanasyev.app.api;

public class ServiceUnavailableException extends RuntimeException {
    public ServiceUnavailableException(Throwable e) {
        super(e);
    }
}
