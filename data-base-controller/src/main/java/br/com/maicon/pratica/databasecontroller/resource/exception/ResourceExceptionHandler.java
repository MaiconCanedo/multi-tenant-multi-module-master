package br.com.maicon.pratica.databasecontroller.resource.exception;

import br.com.maicon.pratica.databasecontroller.model.exception.NoContentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StandardError> badRequest(Exception exception, HttpServletRequest request) {
        return getResponse(HttpStatus.BAD_REQUEST, exception, request);
    }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<StandardError> noContent(NoContentException exception, HttpServletRequest request) {
        return getResponse(HttpStatus.NO_CONTENT, exception, request);
    }

    private ResponseEntity<StandardError> getResponse(HttpStatus httpStatus, Exception exception,
                                                      HttpServletRequest request) {
        StandardError standardError = StandardError.Builder.create()
                .now()
                .status(httpStatus)
                .error(httpStatus.getReasonPhrase())
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(httpStatus).body(standardError);
    }
}
