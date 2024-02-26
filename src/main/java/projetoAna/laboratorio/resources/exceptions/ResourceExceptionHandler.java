package projetoAna.laboratorio.resources.exceptions;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import projetoAna.laboratorio.services.exceptions.DatabaseException;
import projetoAna.laboratorio.services.exceptions.ResourceNotFoundException;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError er = new StandardError(Instant.now(), status.value(), error, e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(er);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> dataBase(DatabaseException e, HttpServletRequest request){
        String error = "database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError er = new StandardError(Instant.now(), status.value(), error, e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(er);
    }


}