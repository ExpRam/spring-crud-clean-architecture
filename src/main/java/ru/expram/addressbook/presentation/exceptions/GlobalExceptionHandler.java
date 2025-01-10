package ru.expram.addressbook.presentation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import ru.expram.addressbook.application.common.BaseException;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<BaseSpringException> baseExceptionHandler(BaseException exception, WebRequest request) {
        String path = request.getDescription(false).replace("uri=", "");
        BaseSpringException baseSpringException = new BaseSpringException(
                exception.getErrorCode(),
                exception.getMessage(),
                path
        );

        return new ResponseEntity<>(baseSpringException, HttpStatus.valueOf(exception.getErrorCode()));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<BaseListedSpringException> methodArgumentNotValidExceptionHandler
            (MethodArgumentNotValidException exception, WebRequest request) {
        List<String> errors = exception.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());

        String path = request.getDescription(false).replace("uri=", "");
        BaseListedSpringException baseSpringException = new BaseListedSpringException(
                HttpStatus.BAD_REQUEST.value(),
                errors,
                path
        );

        return new ResponseEntity<>(baseSpringException, HttpStatus.BAD_REQUEST);
    }
}
