package br.com.maicon.pratica.databasecontroller.model.exception;

public class BadRequestExecption extends RuntimeException {

    public BadRequestExecption(String message) {
        super(message);
    }
}
