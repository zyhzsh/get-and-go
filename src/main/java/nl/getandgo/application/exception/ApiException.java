package nl.getandgo.application.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@AllArgsConstructor
@ToString
public class ApiException {
    @Getter private final String message;
    @JsonIgnore @Getter private final Throwable throwable;
    @Getter private final HttpStatus httpStatus;
    @Getter private final ZonedDateTime zonedDateTime;
}
