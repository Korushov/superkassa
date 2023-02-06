package ru.korushov.superkassa.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import ru.korushov.superkassa.model.Example;

/**
 * @author Vitaly Korushov
 */
@Getter
public class ExampleException extends Throwable {
    private String message;

    public ExampleException(String message) {
        super(message);
    }
}
