package pt.blip.gcm.exception.filter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pt.blip.gcm.purchase.exception.PurchaseException;
import pt.blip.gcm.purchase.exception.PurchaseNotFoundException;

/**
 * Created by gcamaraomarques on 3/7/16.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    ResponseEntity<PurchaseNotFoundException> handleException(PurchaseNotFoundException ex) {
        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseBody
    ResponseEntity<PurchaseException> handleException(PurchaseException ex) {
        return new ResponseEntity<>(ex, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
