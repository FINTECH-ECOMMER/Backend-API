package github.fintechecommerce.utils;

import github.fintechecommerce.model.ErrorLog;
import github.fintechecommerce.model.ExemptionMessages;
import github.fintechecommerce.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    protected @ResponseBody ResponseModel<ErrorLog> handleConflict(Exception ex, WebRequest request) {
        var error = new ErrorLog(ExemptionMessages.INTERNAL_SERVER_ERROR.getCustomMessage(), ex.getMessage(), request.getDescription(true) + request.getRemoteUser() + request.getHeader("X-FORWARDED-FOR"));

        return new ResponseModel<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), LocalDateTime.now(), error);

    }
}
