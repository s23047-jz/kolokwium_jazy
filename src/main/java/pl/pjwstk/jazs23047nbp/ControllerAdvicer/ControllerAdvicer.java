package pl.pjwstk.jazs23047nbp.ControllerAdvicer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.net.ConnectException;

@ControllerAdvice
public class ControllerAdvicer extends RuntimeException {
    @ExceptionHandler(HttpClientErrorException.class)
    ResponseEntity<String> HandlerRuntimeExecption(HttpClientErrorException exception) {
        switch (exception.getStatusCode()){
            case INTERNAL_SERVER_ERROR :
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Exception throw: 500" );
            case  NOT_FOUND:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exception throw: 404" );
            case BAD_REQUEST:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exception throw: 400" );
            case NO_CONTENT:
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Exception throw: 204" );
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Exception trow: 400" );

    }
    @ExceptionHandler(ConnectException.class)
    ResponseEntity<String> Con(ConnectException exception) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("No connect" );

    }
}
