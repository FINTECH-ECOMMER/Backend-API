package github.fintechecommerce.utils;

import github.fintechecommerce.entity.ErrorLog;
import github.fintechecommerce.model.ExemptionMessages;
import github.fintechecommerce.model.ResponseModel;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
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


    private ErrorLog errorLog;


    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseModel<String> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ExemptionMessages.IllegalArgumentException.getCustomMessage();
        return new ResponseModel<>(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.getReasonPhrase(), LocalDateTime.now(), bodyOfResponse);

    }

    @ExceptionHandler(value = {JpaSystemException.class, HibernateException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    protected @ResponseBody ResponseModel<String> handleJpaSystemException(JpaSystemException ex, WebRequest request) {

var x = new ErrorLog(ex.getMessage(), ex.getCause().toString(), ex.getStackTrace().toString()));
        return new ResponseModel<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), LocalDateTime.now());

    }

}

