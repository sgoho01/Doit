package com.ghsong.exception.advice;

import com.ghsong.exception.exception.NullpointException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author : Song.gunho
 * <p>
 * Date: 2019-04-29
 */

@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(value = NullpointException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleJwtExpiredException(RuntimeException e, HttpServletRequest request) {
        log.debug("NullpointException");
        ErrorResponse errorResponse = getErrorResponse(HttpStatus.UNAUTHORIZED, e, request);
        log.debug("ErrorResponse : {}", errorResponse);

        return ResponseEntity.status(errorResponse.getError()).body(errorResponse);
    }

    private ErrorResponse getErrorResponse(HttpStatus httpStatus, RuntimeException ex, HttpServletRequest request) {

        return ErrorResponse.builder()
                .status(httpStatus.value())
                .error(httpStatus)
                .message(ex.getLocalizedMessage())
                .errorTime(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                .path(request.getRequestURI())
                .build();
    }
}
