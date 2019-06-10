package br.com.maicon.pratica.webserviceprincipal.model.exception;

public class BadRequestExecption extends RuntimeException {

    public BadRequestExecption(String message) {
        super(message);
    }
}
