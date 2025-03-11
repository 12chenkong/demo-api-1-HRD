package com.chan.mybatis_hrd.globalexcpetion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(NotFoundExcpetion.class)
    ProblemDetail handleNotFoundException(NotFoundExcpetion ex){
        ProblemDetail exception=ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
        exception.setTitle("Not Found");
        exception.setProperty("Time: ", LocalDateTime.now());
        return exception;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String>errors=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String fieldName =  error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ProblemDetail problem=ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setProperty("errors:",errors);
        return problem;
    }
}
