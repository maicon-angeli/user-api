package exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
@Builder
public class ExceptionResponse {

    private String name;
    private Object cause;
    private LocalDateTime timestamp;
    private HttpStatus httpStatus;
}