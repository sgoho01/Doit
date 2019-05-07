# Exception

특정 에러 발생 시 에러 커스텀하기 

1 . 발생하는 에러 상속받아 커스텀 에러 생성
```java
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
```

2 . 컨트롤러에서 에러 발생
```java
@RestController
public class EventController {

    @GetMapping("/events")
    public String getEvents() {
        throw new NullpointException("custom exception");
    }

}
```

3 . 에러 발생시 리턴해줄 객체 생성
```java
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
```

4 . 에러를 관장하는 @Controlleradvice 생성
```java
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
```

- @Controlleradvice에서 전체 컨트롤러에서 발생하는 에러를 관리할 수 있다.
- @Controlleradvice 어노테이션에서 관리할 컨트롤러를 따로 지정하여 관리 할 수도 있다. `@ControllerAdvice(basePackages = "com.ghsong.controller")`
  