package br.com.msandredev.api.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException {

    public DataIntegratyViolationException(String message) {
        super(message);
    }
}
