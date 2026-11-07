package com.sankalpa.backend.exception;

import java.util.stream.Collectors;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.sankalpa.backend.dto.ApiError;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiError> notFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiError.of(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(NoResourceFoundException.class)          // unknown URL
    ResponseEntity<ApiError> noRoute(NoResourceFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiError.of(HttpStatus.NOT_FOUND, "Resource not found"));
    }

    @ExceptionHandler(HandlerMethodValidationException.class)  // @Min etc. on request params
    ResponseEntity<ApiError> invalidParams(HandlerMethodValidationException ex) {
        String msg = ex.getParameterValidationResults().stream()
                .flatMap(r -> r.getResolvableErrors().stream())
                .map(MessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));
        return ResponseEntity.badRequest().body(ApiError.of(HttpStatus.BAD_REQUEST, msg));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)   // ?day=abc, /materials/abc
    ResponseEntity<ApiError> badType(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity.badRequest()
                .body(ApiError.of(HttpStatus.BAD_REQUEST, "Invalid value for '" + ex.getName() + "'"));
    }
}
