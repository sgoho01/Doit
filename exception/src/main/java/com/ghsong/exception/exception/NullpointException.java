package com.ghsong.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author : Song.gunho
 * <p>
 * Date: 2019-04-29
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Null Point Exception")
public class NullpointException extends NullPointerException {

    private static final long serialVersionUID = 2080621194360145170L;

    public NullpointException() {
        super();
    }

    public NullpointException(String s) {
        super(s);
    }
}
