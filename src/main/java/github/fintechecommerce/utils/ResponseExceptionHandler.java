package github.fintechecommerce.utils;

import github.fintechecommerce.model.ErrorLog;
import github.fintechecommerce.model.ExemptionMessages;
import github.fintechecommerce.model.ResponseModel;
import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    @ResponseStatus(value = HttpStatus.CONFLICT)
    protected @ResponseBody ResponseModel<ErrorLog> handleConflict(Exception ex, WebRequest request) {

        var error = new ErrorLog(ExemptionMessages.IllegalArgumentException.getCustomMessage(), ex.getMessage(), request.getDescription(false));

        return new ResponseModel<>(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.getReasonPhrase(), LocalDateTime.now(), error);

    }

    @ExceptionHandler(value = {JpaSystemException.class, HibernateException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    protected @ResponseBody ResponseModel<ErrorLog> handleJpaSystemException(Exception ex, WebRequest request) {

        var error = new ErrorLog(ExemptionMessages.IllegalArgumentException.getCustomMessage(), ex.getMessage(), request.getDescription(false));

        return new ResponseModel<>(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.getReasonPhrase(), LocalDateTime.now(), error);
    }

}

