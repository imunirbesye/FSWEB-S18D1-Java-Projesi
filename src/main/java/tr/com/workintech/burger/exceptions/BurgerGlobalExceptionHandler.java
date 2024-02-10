package tr.com.workintech.burger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BurgerGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleBurgerException(BurgerException burgerException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(burgerException.getMessage());
        return new ResponseEntity<>(exceptionResponse, burgerException.getHttpStatus());
    }

    @ExceptionHandler(UnknownError.class)
    public ResponseEntity<ExceptionResponse> handleAllException(BurgerException burgerException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(burgerException.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
