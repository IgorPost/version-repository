package nalyvaiko.versionrepository.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import nalyvaiko.versionrepository.exeption.VersionAlreadyExistsException;

@ControllerAdvice
public class VersionExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(VersionAlreadyExistsException.class)
    public ResponseEntity<Object> handleVersionAlreadyExistsException(VersionAlreadyExistsException e, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
	
}
