package com.ghsong.exception.advice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author : Song.gunho
 * <p>
 * Date: 2019-04-29
 */
@Builder
@Getter @Setter
@ToString
public class ErrorResponse {

    private int status;
    private HttpStatus error;
    private String message;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime errorTime;
    private String path;

}
